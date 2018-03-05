package pl.edu.wat.CommunicateModule;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;

@Path("/switches")
public class SwitchResources {
SwitchService switchService=new SwitchService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Switch> getMessages() throws IOException, JSONException {
		return switchService.getAllSwitch();
		
	}
}
