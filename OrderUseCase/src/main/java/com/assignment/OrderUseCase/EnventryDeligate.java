package com.assignment.OrderUseCase;

import java.util.ArrayList;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnventryDeligate implements JavaDelegate{

	@Autowired
	EnventryDAO edao;
	
	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		// TODO Auto-generated method stub
		ArrayList products=new ArrayList();
		products.add((String) arg0.getVariable("productname1"));
		products.add((String) arg0.getVariable("productname2"));
		products.add((String) arg0.getVariable("productname3"));
		
		System.out.println((String)arg0.getVariable("username"));
		System.out.println((String) arg0.getVariable("productname1"));
		System.out.println((String) arg0.getVariable("productname2"));
		System.out.println((String) arg0.getVariable("productname3"));
		
		edao.checkEnventry((String)arg0.getVariable("username"),products);
	}

}
