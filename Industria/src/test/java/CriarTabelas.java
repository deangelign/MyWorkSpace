import org.hibernate.Session;

import br.com.logap.dao.ClienteDAO;
import br.com.logap.dao.SessionManager;
import br.com.logap.modelo.Cliente;


public class CriarTabelas {

	
	
	public static void main(String args[]){
		SessionManager sessionManager = SessionManager.getInstancia();
		Session session = sessionManager.getSession();
		session.createQuery("from Venda");
		session.close();
		//Cliente cliente = new Cliente();
		//cliente.setNome("miau");
		//cliente.setTelefone("990044");
		//cliente.setTipoPessoa("fisica");
		
		//ClienteDAO clienteDAO = new ClienteDAO();
		//clienteDAO.inserir(cliente);
		
		
	}
}
