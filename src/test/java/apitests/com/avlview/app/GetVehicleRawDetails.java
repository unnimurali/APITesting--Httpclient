package apitests.com.avlview.app;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.alview.client.RestClient;
import com.avlview.base.TestBase;
import com.avlview.util.TestUtil;

public class GetVehicleRawDetails extends TestBase {

	TestBase testbase;
	String serviceurl;
	String apiurl;
	String url;
	RestClient restclient;
	CloseableHttpResponse httpresponse;

	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	String jsonPrettyPrintString;
	JSONObject xmlJSONObj;
	String responseString;

	@BeforeMethod
	public void setup() {
		testbase = new TestBase();
		serviceurl = prop.getProperty("URL");
		apiurl = prop.getProperty("getVehicleRawDetails");

		url = serviceurl + apiurl;
	}

	@Test(enabled = true)
	public void getAPITestWithHeaders() throws ClientProtocolException, IOException, SAXException,
			ParserConfigurationException, URISyntaxException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/xml");
		headers.put("apiKey", "eFYqcQJOYW563VDxPia4");// nabeel

		URIBuilder builder = new URIBuilder();
		builder.setScheme(url).setParameter("vehicleId", "19838").setParameter("fromDate", "26-01-2019")
				.setParameter("toDate", "26-01-2019");

		URI uri = builder.build();
		System.out.println(uri);

		httpresponse = restclient.get(url, headers);
		System.out.println(httpresponse);
		System.out.println(headers);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		// Assert.assertEquals(statuscode, testbase.RESPONSE_STATUS_CODE_200);

		responseString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");
		// System.out.println(responseString);

		responseString = responseString.replace("<vehiclerawdetaillist>", "").replace("</vehiclerawdetaillist>", "");
		// System.out.println(str2);
		System.out.println(responseString);

		try {
			xmlJSONObj = XML.toJSONObject(responseString);
			jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
			// System.out.println(jsonPrettyPrintString);
		} catch (JSONException je) {
			System.out.println(je.toString());
		}

		JSONObject responsejson = new JSONObject(jsonPrettyPrintString);
		System.out.println(responsejson);

		String status = TestUtil.getValueByJPath(responsejson, "/status");
		System.out.println(status);
		// Assert.assertEquals(status, "200");

		String id = TestUtil.getValueByJPath(responsejson, "/vehiclerRawDetail[0]/vehicleId");
		System.out.println(id);

		String name = TestUtil.getValueByJPath(responsejson, "/vehiclerRawDetail[0]/vehicleName");
		System.out.println(name);

		JSONArray DevicArray = responsejson.getJSONArray("vehiclerRawDetail");
		// System.out.println("values from devices: " + spellingsArray);
		System.out.println(DevicArray.length());

		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		System.out.println(allheaders);

	}

}
