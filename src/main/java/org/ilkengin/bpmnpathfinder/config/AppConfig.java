package org.ilkengin.bpmnpathfinder.config;

import org.ilkengin.bpmnpathfinder.service.BpmnService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
	
	public static BpmnService getBpmnService() {
		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("https://n35ro2ic4d.execute-api.eu-central-1.amazonaws.com/")
			    .addConverterFactory(GsonConverterFactory.create())
			    .build();

		return retrofit.create(BpmnService.class);
	}
}
