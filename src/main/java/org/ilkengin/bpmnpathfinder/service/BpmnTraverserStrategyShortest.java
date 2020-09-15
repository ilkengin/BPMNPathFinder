package org.ilkengin.bpmnpathfinder.service;

import java.util.List;

import org.camunda.bpm.model.bpmn.instance.FlowNode;

public class BpmnTraverserStrategyShortest implements BpmnTraverserStrategy {

	public BpmnTraverserStrategyShortest() {
		throw new IllegalAccessError("This class is not yet implemented. It will be implemented in a future release!");
	}
	
	@Override
	public List<String> findPath(List<String> visitedNodeIds, FlowNode currentNode, String targetNodeId) {
		// TODO: This is not yet implemented, but we might want to find the shortest path in the future
		// There, we will need to implement this method
		return null;
	}

}
