package com.assignment.OrderUseCase;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.javassist.bytecode.Descriptor.Iterator;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InventoryDeligate implements JavaDelegate{

	@Autowired
	InventoryDAO edao;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		try {
			
		
		ArrayList products=new ArrayList();
		products.add((String) execution.getVariable("productname1"));
		products.add((String) execution.getVariable("productname2"));
		products.add((String) execution.getVariable("productname3"));
		
		System.out.println((String)execution.getVariable("username"));
		System.out.println((String) execution.getVariable("productname1"));
		System.out.println((String) execution.getVariable("productname2"));
		System.out.println((String) execution.getVariable("productname3"));
		
		List<String> returnedList= edao.checkInventory((String)execution.getVariable("username"),products);
		if (returnedList.size()==0)
		{
			//All products are available
			System.out.println("inside null");
			execution.setVariable("isAvailable", true);
			System.out.println("sending to DMN " + products.toString());
		//	execution.setVariable("Product", products.toString());
			
			execution.setVariable("Product", "Laptop");
			
		}else {
			//Not available products are 
			System.out.println("Products not available :"+returnedList.toString());
			execution.setVariable("isAvailable", false);
			execution.setVariable("productsNotAvailable", returnedList);
			
		}
	}catch(Exception e) {
		System.out.println("Exception :"+e);
	}
	}
}
