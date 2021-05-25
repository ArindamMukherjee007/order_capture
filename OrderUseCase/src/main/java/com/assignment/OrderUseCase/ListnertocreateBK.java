package com.assignment.OrderUseCase;

import java.util.UUID;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class ListnertocreateBK implements ExecutionListener{

	@Override
	public void notify(DelegateExecution arg0) throws Exception {
		// TODO Auto-generated method stub
		arg0.setVariable("Business Key", UUID.randomUUID().toString());
	}

}
