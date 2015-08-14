import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.logap.dao.SessionManager;


public class CriarTabelas {

	
	
	public static void main(String args[]){
		SessionManager sessionManager = SessionManager.getInstancia();
		Session session = sessionManager.getSession();
		
		session.createQuery("FROM Venda");
		session.close();
		
	}
}
