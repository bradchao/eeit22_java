package tw.brad.h2.tutor;

import java.util.List;

import org.hibernate.Session;

import tools.jackson.databind.ObjectMapper;
import tw.brad.h2.dto.OrderItem;
import tw.brad.h2.entity.Employee;
import tw.brad.h2.utils.HibernateUtil;

public class Brad07 {
	private static final String hql = """
			SELECT
				o.customer.cname,
				o.employee.lastName,
				o.orderDate,
				p.productName,
				d.unitPrice,
				d.quantity
			FROM Order o
			JOIN o.orderDetails d
			JOIN d.product p
			WHERE o.orderId = :orderId
			""";
	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			List<Object[]> result = 
				session.createQuery(hql, Object[].class)
					.setParameter("orderId", 10248)
					.getResultList();
			//---------------------------------
			for (Object[] row : result) {
				System.out.println(row[0]);
				System.out.println(row[1]);
				System.out.println(row[2]);
			}
			//----------------------
			System.out.println("----------JSON----------");
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writerWithDefaultPrettyPrinter()
							.writeValueAsString(result);
			System.out.println(json);
			System.out.println("----------Object----------");
			toOrderItem(json);
			
		}	
	}
	
	private static void toOrderItem(String json) {
		ObjectMapper mapper = new ObjectMapper();
		OrderItem order = mapper.readValue(json, OrderItem.class);
		System.out.println(order.customer);
		System.out.println(order.employee);
		System.out.println(order.date);
		
		
		
	} 

}
