package org.ilkengin.bpmnpathfinder.service;

import java.util.List;

import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.FlowNode;

public class BpmnTraverserService {
	
	private BpmnModelInstance bpmnModelInstance;
	private BpmnTraverserStrategy bpmnTraverserStrategy;
	
	public BpmnTraverserService(BpmnModelInstance instance, BpmnTraverserStrategy strategy) {
		this.bpmnModelInstance = instance;
		this.bpmnTraverserStrategy = strategy;
	}
	
	public List<String> findPathBetween(String startNodeId, String targetNodeId) throws IllegalArgumentException {
		
		if(startNodeId.equals(targetNodeId)) {
			throw new IllegalArgumentException("Start and target nodes cannot be the same");
		}
		
		FlowNode startNode = (FlowNode) bpmnModelInstance.getModelElementById(startNodeId);
		
		return bpmnTraverserStrategy.findPath(null, startNode, targetNodeId);
	}
}
