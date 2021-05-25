package com.assignment.OrderUseCase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EnventryDAOImpl implements EnventryDAO{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public void checkEnventry(String userName, List products)
	{
		
		System.out.println(userName);
		System.out.println(products.get(0));
		System.out.println(products.get(1));
		System.out.println(products.get(2));
		
		List result =jdbcTemplate.queryForList("select * from product");
		
		System.out.println(result);
	}

	
	
}
