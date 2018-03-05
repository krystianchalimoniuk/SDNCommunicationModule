package pl.edu.wat.CommunicateModule;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Switch {
	String dpid,controller,inetAddress,OPFversion;
	public Switch() {}
	public Switch(String dpid, String controller, String inetAddress, String oPFversion) {
		this.dpid = dpid;
		this.controller = controller;
		this.inetAddress = inetAddress;
		this.OPFversion = oPFversion;
	}
	public String getDpid() {
		return dpid;
	}
	public String getController() {
		return controller;
	}
	public String getInetAddress() {
		return inetAddress;
	}
	public String getOPFversion() {
		return OPFversion;
	}
	public void setDpid(String dpid) {
		this.dpid=dpid;
	}
	public void setController(String controller) {
		this.controller=controller;
	}
	public void setOPFversion(String OPFversion) {
		this.OPFversion=OPFversion;
	}
	public void setInetAddress(String inetAddress) {
		this.inetAddress=inetAddress;
	}
	 
	
	


}
