package com.assignment.OrderUseCase;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDAO {
	public List<String> checkInventory(String userName, List products); 
}
