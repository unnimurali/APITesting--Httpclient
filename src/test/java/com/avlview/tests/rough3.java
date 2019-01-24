package com.avlview.tests;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.avlview.util.TestUtil;

public class rough3 {
	
	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	static String jsonPrettyPrintString ;
	static JSONObject xmlJSONObj ;
    public static void main(String[] args) {
    	
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://parabank.parasoft.com/parabank/services/bank/customers/12212/");
        

        try {
            HttpResponse response = client.execute(request);
            String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
    		System.out.println("respnsestrng is" + responseString);
    		
    		String str2 = responseString.replace("<customer>", "").replace("</customer>", "");
    		System.out.println(str2);
    		

            
           // String content = EntityUtils.toString(entity);
           // System.out.println(content);
            
          try {
        	   xmlJSONObj = XML.toJSONObject(str2);
              jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
              
             // jsonPrettyPrintString = jsonPrettyPrintString.substring(0, responseString.length());
             // System.out.println("actual json response string is: " + jsonPrettyPrintString);
              //jsonPrettyPrintString = responseString.substring(0, responseString.length()-1);
      		   
              System.out.println(jsonPrettyPrintString);
         } catch (JSONException je) {
              System.out.println(je.toString());
  	        }
           
           
        JSONObject responsejson = new JSONObject(jsonPrettyPrintString);
   		System.out.println(responsejson);
   		
   	//get the values from json object:
   		//String countryName = responsejson.getString("firstName");
   		//System.out.println("the country name is: "+ countryName);
   		
  		
   	String total = TestUtil.getValueByJPath(responsejson, "/firstName");
   System.out.println(total);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
