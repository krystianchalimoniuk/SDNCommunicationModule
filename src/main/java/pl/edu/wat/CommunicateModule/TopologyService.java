package pl.edu.wat.CommunicateModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class TopologyService {
	
	public ArrayList<Topology> getTopology() throws IOException, JSONException{
		ArrayList<Topology> topologyArray=downloadTopologyInfoFloodlight("http://127.0.0.1:8080/wm/topology/links/json");
		//TODO: Wywołać metodę pobierającą dane z RYU i zapisać jej wynik do ArrayList jak powyżej.Scalić obie tablice i zwrócić w returnie

	return topologyArray;
	}
	

	public static ArrayList<Topology> downloadTopologyInfoFloodlight(String url) throws IOException, JSONException {
		InputStream is=new URL(url).openStream();
		ArrayList<Topology> topologyArray=new ArrayList<>();
		try {
			BufferedReader rd=new BufferedReader(new InputStreamReader(is,Charset.forName("UTF-8")));
			String jsonText=readAll(rd);
			
			JSONArray ja=new JSONArray(jsonText);
			JSONObject jo=null;
			topologyArray.clear();
			Topology topology;
			for (int i=0;i<ja.length();i++) {
				jo=ja.getJSONObject(i);
				String controller="Floodlight";
				String src_switch=jo.getString("src-switch");
				int src_port=jo.getInt("src-port");
				String dst_switch=jo.getString("dst-switch");
				int dst_port=jo.getInt("dst-port");
				String type=jo.getString("type");
				String direction=jo.getString("direction");
				int latency=jo.getInt("latency");
				topology=new Topology();
				topology.setController(controller);
				topology.setSrcSwitch(src_switch);
				topology.setSrcPort(src_port);
				topology.setDstSwitch(dst_switch);
				topology.setDstPort(dst_port);
				topology.setType(type);
				topology.setDirection(direction);
				topology.setLatency(latency);
				topologyArray.add(topology);
				
			}
			
			
			
			return topologyArray;
		}finally{
			is.close();
		}
	}
	
	//TODO: Stworzyć metodę na podstawie powyższej pobierającą dane z RYU. Przeanalizować pola występujące w RYU i Floodlight oraz zostawić tylko wspólne
	
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb=new StringBuilder();
		int cp;
		while((cp=rd.read()) !=-1) {
			sb.append((char)cp);
		}
		return sb.toString();
	}
}
