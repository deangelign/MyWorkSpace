package br.com.logap.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.logap.dao.AlmoxarifadoDAO;
import br.com.logap.dao.FabricanteDAO;
import br.com.logap.dao.FornecedorDAO;
import br.com.logap.dao.UsuarioDAO;
import br.com.logap.modelo.Almoxarifado;
import br.com.logap.modelo.Fabricante;
import br.com.logap.modelo.Fornecedor;
import br.com.logap.modelo.Usuario;

@ManagedBean(name = "almoxarifadoBean")
@ViewScoped
public class AlmoxarifadoBean {

	
		private Almoxarifado almoxarifado;
		private AlmoxarifadoDAO almoxarifadoDAO;		
		private List<Almoxarifado>almoxarifados ;
				
		public AlmoxarifadoBean() {
			almoxarifado = new Almoxarifado();
			almoxarifadoDAO =  new AlmoxarifadoDAO();
		}
			
		public void atualizarLista(){
			almoxarifados = almoxarifadoDAO.buscarTodos();
		}

		public Almoxarifado getAlmoxarifado() {
			return almoxarifado;
		}
		
		public List<Almoxarifado> getAlmoxarifados() {
			return almoxarifados;
		}

		public void setAlmoxarifados(List<Almoxarifado> almoxarifados) {
			this.almoxarifados = almoxarifados;
		}

		public void setAlmoxarifado(Almoxarifado almoxarifado) {
			this.almoxarifado = almoxarifado;
		}
		
		public void cadastrar(){
			almoxarifadoDAO.inserir(almoxarifado);
			atualizarLista();
		}

		public void deletarAction(Almoxarifado almoxarifado){
			
			almoxarifadoDAO.remover(almoxarifado);
			this.atualizarLista();
		}
		
				
		
		
		
		
		
		
		
			
		
}
