package org.ilkengin.bpmnpathfinder.config;

import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.ilkengin.bpmnpathfinder.service.BpmnService;
import org.ilkengin.bpmnpathfinder.service.BpmnTraverserService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppConfig {
	
	public static BpmnService constructBpmnService() {

		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("https://n35ro2ic4d.execute-api.eu-central-1.amazonaws.com/")
			    .addConverterFactory(GsonConverterFactory.create())
			    .build();

		return retrofit.create(BpmnService.class);
	}
	
	public static BpmnTraverserService getBpmnTraverser(BpmnModelInstance bpmnModelInstance) {
		return new BpmnTraverserService(bpmnModelInstance);
	}
}
