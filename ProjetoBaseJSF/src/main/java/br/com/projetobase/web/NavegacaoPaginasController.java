package br.com.projetobase.web;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewParameter;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewDeclarationLanguage;
import javax.faces.view.ViewMetadata;

@ApplicationScoped
public class NavegacaoPaginasController {
	public static class Pagina {
		
		private final String viewId;
		
		private final Map<String, String> params;

		private Pagina(String viewId) {
			this.viewId = viewId;
			this.params = new LinkedHashMap<String, String>();
		}

		private Pagina(String viewId, Map<String, String> params) {
			this.viewId = viewId;
			this.params = params;
		}

		public Pagina redirect() {
			return includeParam("faces-redirect", "true");
		}

		public Pagina includeViewParams() {
			return includeParam("includeViewParams", "true");
		}

		public Pagina includeViewParam(String name) {
			// Getting the metadata facet of the view
			FacesContext ctx = FacesContext.getCurrentInstance();
			ViewDeclarationLanguage vdl = ctx.getApplication().getViewHandler().getViewDeclarationLanguage(ctx, viewId);
			ViewMetadata viewMetadata = vdl.getViewMetadata(ctx, viewId);
			UIViewRoot viewRoot = viewMetadata.createMetadataView(ctx);
			UIComponent metadataFacet = viewRoot.getFacet(UIViewRoot.METADATA_FACET_NAME);

			// Looking for a view parameter with the specified name
			UIViewParameter viewParam = null;
			for (UIComponent child : metadataFacet.getChildren()) {
				if (child instanceof UIViewParameter) {
					UIViewParameter tempViewParam = (UIViewParameter) child;
					if (name.equals(tempViewParam.getName())) {
						viewParam = tempViewParam;
						break;
					}
				}
			}

			if (viewParam == null) {
				throw new FacesException("Unknown parameter: '" + name + "' for view: " + viewId);
			}

			// Getting the value
			String value = viewParam.getStringValue(ctx);
			return includeParam(name, value);
		}

		public Pagina includeParam(String name, String value) {
			Map<String, String> newParams = new LinkedHashMap<String, String>(params);
			newParams.put(name, value);
			return new Pagina(viewId, newParams);
		}

		public String construir() {
			StringBuilder sb = new StringBuilder();
			sb.append(viewId);

			String paramSeparator = "?";
			for (Map.Entry<String, String> nameValue : params.entrySet()) {
				sb.append(paramSeparator).append(nameValue.getKey()).append("=").append(nameValue.getValue());
				paramSeparator = "&";
			}

			return sb.toString();
		}
	}
	
    private final Pagina login = new Pagina("/login");
    private final Pagina home = new Pagina("/paginas/home");
    private final Pagina cadastrarEquipamento = new Pagina("/paginas/form_equipamento");
    private final Pagina cadastrarSensor = new Pagina("/paginas/form_sensor");
    private final Pagina cadastrarUsuario = new Pagina("/form_usuario");
    private final Pagina gerenciamentoUsuario = new Pagina("/paginas/manager/manager_user");

	public Pagina getLogin() {
		return login;
	}
	
	
	public Pagina getCadastrarUsuario() {
		return cadastrarUsuario;
	}
	
	public Pagina getGerencioamentoUsuario() {
		return gerenciamentoUsuario;
	}

	
	public Pagina getCadastrarEquipamento() {
		return cadastrarEquipamento;
	}
	
	public Pagina getCadastrarSensor() {
		return cadastrarSensor;
	}


	public Pagina getHome() {
		return home;
	}
	
}
