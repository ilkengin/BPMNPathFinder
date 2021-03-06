package org.ilkengin.bpmnpathfinder;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.ilkengin.bpmnpathfinder.config.AppConfig;
import org.ilkengin.bpmnpathfinder.model.BpmnResponse;
import org.ilkengin.bpmnpathfinder.service.BpmnTraverserService;

import retrofit2.Response;

public class Application {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Start and target nodeID's should be supplied!");
			System.exit(-1);
		}
		
		String startNodeId = args[0];
		String targetNodeId = args[1];
		
		try {
			// Get BPMN from server
			Response<BpmnResponse> response = AppConfig.constructBpmnService().getBpmn().execute();
			
			// Build the model instance
			BpmnModelInstance modelInstance = Bpmn.readModelFromStream(new ByteArrayInputStream(response.body().getBpmn20Xml().getBytes()));
			
			// Get Traverser Service
			AppConfig appConfig = new AppConfig();
			BpmnTraverserService bpmnTraverserService = appConfig.getBpmnTraverser(modelInstance);
			
			List<String> inBetweenNodeIds = bpmnTraverserService.findPathBetween(startNodeId, targetNodeId);
			if (inBetweenNodeIds == null) {
				System.exit(-1);
			}
			
			System.out.println(String.format("The path from %s to %s is:", startNodeId, targetNodeId));
			System.out.print(inBetweenNodeIds);
			System.exit(0);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
