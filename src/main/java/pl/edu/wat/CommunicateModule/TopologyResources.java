package pl.edu.wat.CommunicateModule;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;


	@Path("/topology")
	public class TopologyResources {
	TopologyService topologyService=new TopologyService();
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Topology> getMessages() throws IOException, JSONException {
			return topologyService.getTopology();
			
		}
	}