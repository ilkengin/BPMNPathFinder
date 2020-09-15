package org.ilkengin.bpmnpathfinder.service;

import org.ilkengin.bpmnpathfinder.model.BpmnResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BpmnService {
	
	@GET("/prod/engine-rest/process-definition/key/invoice/xml")
	Call<BpmnResponse> getBpmn();
}