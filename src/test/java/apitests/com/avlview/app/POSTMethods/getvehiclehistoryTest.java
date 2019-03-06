package apitests.com.avlview.app.POSTMethods;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.alview.client.RestClient;
import com.avlview.base.TestBase;
import com.avlview.data.Vehiclehistory;
import com.avlview.util.TestUtil;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class getvehiclehistoryTest extends TestBase {

	TestBase testbase;
	String serviceurl;
	String apiposturl;
	String url;
	RestClient restclient;
	CloseableHttpResponse httpresponse;
	JSONObject xmlJSONObj;

	@BeforeMethod
	public void setup() {
		testbase = new TestBase();

		serviceurl = prop.getProperty("URL");
		apiposturl = prop.getProperty("getvehiclehistory");

		url = serviceurl + apiposturl;
		System.out.println(url);

	}

	@Test(enabled = true)
	public void getvehiclehistory()
			throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();

		headers.put("apiKey", prop.getProperty("apiKey_Get"));
		headers.put("Accept", prop.getProperty("Accept"));

		Vehiclehistory vh = new Vehiclehistory(prop.getProperty("Vehicleid"), prop.getProperty("sdate_time"),
				prop.getProperty("edate_time"));

		XmlMapper xmlMapper = new XmlMapper();
		String destfilepath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\avlview\\data\\Vehiclehistory.xml";
		xmlMapper.writeValue(new File(destfilepath), vh);

		String resstring = xmlMapper.writeValueAsString(vh);
		System.out.println(resstring);

		httpresponse = restclient.post(url, resstring, headers);
		System.out.println(httpresponse);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, testbase.RESPONSE_STATUS_CODE_200);

		String responseStringpost = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");
		System.out.println(responseStringpost);

		JSONObject responsejson = new JSONObject(responseStringpost);

		String status = TestUtil.getValueByJPath(responsejson, "/status");
		Assert.assertEquals(status, "200");

		JSONArray apn = responsejson.getJSONArray("vehiclehistory");
		System.out.println(apn.length());

		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		System.out.println(allheaders);

	}

}
