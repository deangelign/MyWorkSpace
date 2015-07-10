package br.com.logap.financeiro2.model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.logap.financeiro2.repository.Lancamentos;
import br.com.logap.financeiro2.util.CDILocator;

@FacesConverter(forClass = Lancamento.class)
public class LancamentosConverter implements Converter{

	// @Inject (ainda não é suportado)
	private Lancamentos lancamentos;
	
	public LancamentosConverter() {
		this.lancamentos = CDILocator.getBean(Lancamentos.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		if (value != null) {
			return this.lancamentos.porId(new Long(value));
		}
		return null;
		
	
	}
	

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		if (value != null) {
			Lancamento lancamento = ((Lancamento) value);
			return lancamento.getId() == null ? null
			: lancamento.getId().toString();
		}
		return null;
		
		
		
	}

}
