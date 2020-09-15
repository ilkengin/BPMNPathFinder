package org.ilkengin.bpmnpathfinder.config;

import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.ilkengin.bpmnpathfinder.service.BpmnService;
import org.ilkengin.bpmnpathfinder.service.BpmnTraverserService;
import org.ilkengin.bpmnpathfinder.service.BpmnTraverserStrategyFactory;
import org.ilkengin.bpmnpathfinder.service.StrategyType;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppConfig {
	
	private BpmnTraverserStrategyFactory bpmnTraverserStrategyFactory;
	
	public AppConfig() {
		bpmnTraverserStrategyFactory = new BpmnTraverserStrategyFactory();
	}
	
	public static BpmnService constructBpmnService() {

		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("https://n35ro2ic4d.execute-api.eu-central-1.amazonaws.com/")
			    .addConverterFactory(GsonConverterFactory.create())
			    .build();

		return retrofit.create(BpmnService.class);
	}
	
	public BpmnTraverserService getBpmnTraverser(BpmnModelInstance bpmnModelInstance) {
		return new BpmnTraverserService(bpmnModelInstance, bpmnTraverserStrategyFactory.getStrategy(StrategyType.RECURSIVE));
	}
}
