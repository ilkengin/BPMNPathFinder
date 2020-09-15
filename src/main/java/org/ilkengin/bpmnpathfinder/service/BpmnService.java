package org.ilkengin.bpmnpathfinder.service;

import org.ilkengin.bpmnpathfinder.model.BPMNResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BpmnService {
	@GET("/")
	Call<BPMNResponse> getBpmn();
}