import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.logap.dao.ConnectionFactory;


public class CriarTabelas {

	
	
	public static void main(String args[]){
		ConnectionFactory connectionFactory = new ConnectionFactory();
		SessionFactory sessionFactory = connectionFactory.getInstancia();
		Session session = sessionFactory.getCurrentSession();
		
		session.createQuery("FROM Venda");
		session.close();
		
	}
}
