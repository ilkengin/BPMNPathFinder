package org.ilkengin.bpmnpathfinder;

import java.io.IOException;

import org.ilkengin.bpmnpathfinder.config.RetrofitConfig;
import org.ilkengin.bpmnpathfinder.model.BpmnResponse;

import retrofit2.Response;

public class Application {

	public static void main(String[] args) {
		try {
			Response<BpmnResponse> response = RetrofitConfig.getBpmnService().getBpmn().execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
