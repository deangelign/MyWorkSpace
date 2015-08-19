import br.com.logap.dao.ClienteDAO;
import br.com.logap.modelo.Cliente;


public class CriarTabelas {

	
	
	public static void main(String args[]){
		Cliente cliente = new Cliente();
		cliente.setNome("miau");
		cliente.setTelefone("990044");
		cliente.setTipoPessoa("fisica");
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserir(cliente);
		
		
	}
}
