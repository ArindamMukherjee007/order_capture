package com.assignment.OrderUseCase;

import java.util.ArrayList;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;


public class OfferListner implements TaskListener{

	@Override
	public void notify(DelegateTask delegateTask) {
		// TODO Auto-generated method stub
		DelegateExecution  exec=(DelegateExecution) delegateTask.getExecution();
		ArrayList offer=(ArrayList) exec.getVariable("Offer");
		System.out.println("Offer Details :"+offer.toString());
		System.out.println(delegateTask.getVariable("Offer").toString());
	}

}
