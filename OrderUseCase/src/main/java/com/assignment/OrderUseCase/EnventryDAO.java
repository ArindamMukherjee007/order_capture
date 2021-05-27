package com.assignment.OrderUseCase;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface EnventryDAO {
	public List<String> checkEnventry(String userName, List products); 
}
