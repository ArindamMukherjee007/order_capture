package com.assignment.OrderUseCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class InventoryDAOImpl implements InventoryDAO{

	//@Autowired
  //  private JdbcTemplate jdbcTemplate;
	@Autowired
	private ProductService service;
	
	public List<String> checkInventory(String userName, List prodList2)
	{
		List<String> prodNotAvailable = new ArrayList<String>();
		System.out.println(userName);
		System.out.println(prodList2.get(0));
		System.out.println(prodList2.get(1));
		System.out.println(prodList2.get(2));
		try {
			List<Product> prodList1 =service.listAll();
			 
			System.out.println("prodList1 size :"+prodList1.size());
			Iterator it=prodList2.iterator();
			while(it.hasNext()) {
				
					String str=(String) it.next();
					System.out.println("Searching for :"+str);
					boolean matchedResult=prodList1.stream().anyMatch(p-> p.getName().toString().equalsIgnoreCase(str));
					if (matchedResult == false)
					{
						prodNotAvailable.add(str);
					}
				}
			
			return prodNotAvailable;
		}catch(Exception e) {
			throw e;
		}
		
	}

	
	
}
