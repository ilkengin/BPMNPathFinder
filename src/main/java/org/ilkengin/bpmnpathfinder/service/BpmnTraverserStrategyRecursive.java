package org.ilkengin.bpmnpathfinder.service;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.model.bpmn.instance.FlowNode;
import org.camunda.bpm.model.bpmn.instance.SequenceFlow;

public class BpmnTraverserStrategyRecursive implements BpmnTraverserStrategy {

	@Override
	public List<String> findPath(List<String> visitedNodeIds, FlowNode currentNode, String targetNodeId) {
		if (currentNode.getOutgoing() == null) {
			return null;
		}
		if (visitedNodeIds == null) {
			visitedNodeIds = new ArrayList<String>();
		} else {			
			//This is to clone the list from given nodes
			visitedNodeIds = new ArrayList<String>(visitedNodeIds);
		}
		visitedNodeIds.add(currentNode.getId());
		
		for (SequenceFlow flow : currentNode.getOutgoing()) {
			if (flow.getTarget().getId().equals(targetNodeId)) {
				return new ArrayList<String>() {{
					add(currentNode.getId());
					add(targetNodeId);
				}};
			}
			if (visitedNodeIds.contains(flow.getTarget().getId())) {
				continue;
			}
		
			List<String> listFromChildNode = findPath(visitedNodeIds, flow.getTarget(), targetNodeId);
			if (listFromChildNode != null) {
				listFromChildNode.add(0, currentNode.getId());
				return listFromChildNode;
			}
		}
		return null;
	}

}
