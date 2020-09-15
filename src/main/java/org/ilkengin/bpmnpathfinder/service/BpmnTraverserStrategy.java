package org.ilkengin.bpmnpathfinder.service;

import java.util.List;

import org.camunda.bpm.model.bpmn.instance.FlowNode;

public interface BpmnTraverserStrategy {
	
	public List<String> findPath(List<String> visitedNodeIds, FlowNode currentNode, String targetNodeId);

}
