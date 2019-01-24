package com.avlview.tests;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.avlview.util.TestUtil;

public class rough1 {
	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	static String jsonPrettyPrintString ;
    public static void main(String[] args) {
    	
        HttpClient client = HttpClientBuilder.create().build();
        //HttpGet request = new HttpGet("http://parabank.parasoft.com/parabank/services/bank/customers/12212/");
        //HttpGet request = new HttpGet("http://json.parser.online.fr/beta/");
        //HttpGet request = new HttpGet("http://services.groupkt.com/country/get/iso2code/IN");
       // HttpGet request = new HttpGet("http://ip.jsontest.com/");
        HttpGet request = new HttpGet("https://restcountries.eu/rest/v2/name/united");

        try {
            HttpResponse response = client.execute(request);
            //HttpEntity entity = response.getEntity();

            // Read the contents of an entity and return it as a String.

            String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
    		System.out.println(responseString);
    		

            
           // String content = EntityUtils.toString(entity);
           // System.out.println(content);
            
          /* try {
        	   JSONObject xmlJSONObj = XML.toJSONObject(content);
              jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
             // System.out.println(jsonPrettyPrintString);
         } catch (JSONException je) {
              System.out.println(je.toString());
  	        }*/
           
           
        JSONObject responsejson = new JSONObject(responseString);
   		System.out.println(responsejson);
   		
   		//JSONObject obj = new JSONObject(responsejson);
        //String pageName = responsejson.getJSONObject("ip").toString();

        //System.out.println(pageName);

   		
   	String total = TestUtil.getValueByJPath(responsejson, "/name");
   	System.out.println(total);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
