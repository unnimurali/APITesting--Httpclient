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
import com.avlview.data.apnvehid;
import com.avlview.util.TestUtil;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class getapnlistbyvehicleidTest extends TestBase {

	TestBase testbase;
	String serviceurl;
	String apiposturl;
	String url;
	RestClient restclient;
	CloseableHttpResponse httpresponse;
	JSONObject xmlJSONObj;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		testbase = new TestBase();

		serviceurl = prop.getProperty("URL");
		apiposturl = prop.getProperty("getapnlistbyvehicleid");

		url = serviceurl + apiposturl;
		System.out.println(url);

	}

	@Test(enabled = true, groups = { "Post Requests" })
	public void getapnlistbyvehicleid()
			throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();

		headers.put("apiKey", prop.getProperty("apiKey_Get"));
		headers.put("Accept", prop.getProperty("Accept"));

		apnvehid avc = new apnvehid(prop.getProperty("Vehicleid"));

		XmlMapper xmlMapper = new XmlMapper();
		String destfilepath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\avlview\\data\\apnvehid.xml";
		xmlMapper.writeValue(new File(destfilepath), avc);

		String resstring = xmlMapper.writeValueAsString(avc);
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

		JSONArray apn = responsejson.getJSONArray("provider");
		System.out.println(apn.length());

		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		System.out.println(allheaders);

	}

}
