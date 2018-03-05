package pl.edu.wat.CommunicateModule;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Topology {
	String controller,src_switch,dst_switch,type,direction;
	int src_port,dst_port,latency;
	
	public Topology() {}
	public Topology(String controller, String src_switch, String dst_switch, String type, String direction,
			int src_port, int dst_port, int latency) {
		this.controller = controller;
		this.src_switch = src_switch;
		this.dst_switch = dst_switch;
		this.type = type;
		this.direction = direction;
		this.src_port = src_port;
		this.dst_port = dst_port;
		this.latency = latency;
	}
	public String getController() {
		return controller;
	}
	public String getSrcSwitch() {
		return src_switch;
	}
	public int getSrcPort() {
		return src_port;
	}
	public String getDstSwitch() {
		return dst_switch;
	}
	public int getDstPort() {
		return dst_port;
	}
	public String getType() {
		return type;
	}
	public String getDirection() {
		return direction;
	}
	public int getLatency() {
		return latency;
	}
	
	public void setController(String controller) {
		this.controller=controller;
	}
	public void setSrcSwitch(String src_switch) {
		this.src_switch=src_switch;
	}
	public void setSrcPort(int src_port) {
		this.src_port=src_port;
	}
	public void setDstSwitch(String dst_switch) {
		this.dst_switch=dst_switch;
	}
	public void setDstPort(int dst_port) {
		this.dst_port=dst_port;
	}
	public void setType(String type) {
		this.type=type;
	}
	public void setDirection(String direction) {
		this.direction=direction;
	}
	public void setLatency(int latency) {
		this.latency=latency;
	}
	 
}
