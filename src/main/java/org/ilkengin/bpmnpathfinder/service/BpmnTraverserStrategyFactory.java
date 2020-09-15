package org.ilkengin.bpmnpathfinder.service;

public class BpmnTraverserStrategyFactory {
	
	public BpmnTraverserStrategy getStrategy(StrategyType type) {
		switch (type) {
		case SHORTEST:
			return new BpmnTraverserStrategyShortest();
		case RECURSIVE:
		default:
			return new BpmnTraverserStrategyRecursive();
		}
	}
}
