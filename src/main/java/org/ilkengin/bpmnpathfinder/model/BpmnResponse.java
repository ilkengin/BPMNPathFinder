package org.ilkengin.bpmnpathfinder.model;

public class BpmnResponse {
	private String id;
	private String bpmn20Xml;
	
	public BpmnResponse() { }
	
	public BpmnResponse(String id, String bpmn20Xml) {
		this.id = id;
		this.bpmn20Xml = bpmn20Xml;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBpmn20Xml() {
		return bpmn20Xml;
	}
	public void setBpmn20Xml(String bpmn20Xml) {
		this.bpmn20Xml = bpmn20Xml;
	}

	@Override
	public String toString() {
		return "BpmnResponse [id=" + id + ", bpmn20Xml=" + bpmn20Xml + "]";
	}
}
