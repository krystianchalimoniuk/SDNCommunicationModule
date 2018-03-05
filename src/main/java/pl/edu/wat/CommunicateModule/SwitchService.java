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




public class SwitchService {

	public ArrayList<Switch> getAllSwitch() throws IOException, JSONException{
		ArrayList<Switch> switchesArray=downloadSwitchInfoFloodlight("http://127.0.0.1:8080/wm/core/controller/switches/json");
		//TODO: Wywołać metodę pobierającą dane z RYU i zapisać jej wynik do ArrayList jak powyżej.Scalić obie tablice i zwrócić w returnie

	return switchesArray;
	}
	
	public static ArrayList<Switch> downloadSwitchInfoFloodlight(String url) throws IOException, JSONException {
		InputStream is=new URL(url).openStream();
		ArrayList<Switch> switchesArray=new ArrayList<>();
		try {
			BufferedReader rd=new BufferedReader(new InputStreamReader(is,Charset.forName("UTF-8")));
			String jsonText=readAll(rd);
			
			JSONArray ja=new JSONArray(jsonText);
			JSONObject jo=null;
			switchesArray.clear();
			Switch switches;
			for (int i=0;i<ja.length();i++) {
				jo=ja.getJSONObject(i);
				String dpid=jo.getString("switchDPID");
				String controller="Floodlight";
				String OPFversion=jo.getString("openFlowVersion");
				String inetAddress=jo.getString("inetAddress");
				switches=new Switch();
				switches.setController(controller);
				switches.setDpid(dpid);
				switches.setOPFversion(OPFversion);
				switches.setInetAddress(inetAddress);
				switchesArray.add(switches);
			
			}
			
			
			
			return switchesArray;
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
