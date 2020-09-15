package org.ilkengin.bpmnpathfinder.service;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.model.bpmn.BpmnModelInstance;

public class BpmnTraverserService {
	
	private BpmnModelInstance bpmnModelInstance;
	
	public BpmnTraverserService(BpmnModelInstance instance) {
		this.bpmnModelInstance = instance;
	}
	
	public List<String> findPathBetween(String startNodeId, String targetNodeId) {
		return new ArrayList<String>();
	}
	
}
