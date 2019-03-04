package apitests.com.avlview.app.POSTMethods;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.alview.client.RestClient;
import com.avlview.base.TestBase;
import com.avlview.data.adddriver;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class adddriverTest extends TestBase {
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
		apiposturl = prop.getProperty("adddriver");

		url = serviceurl + apiposturl;
		System.out.println(url);

	}

	@Test(enabled = true)
	public void PostAPITest() throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();

		headers.put("apiKey", prop.getProperty("apiKey_Odometer"));
		headers.put("Accept", prop.getProperty("Accept"));

		adddriver gir = new adddriver(prop.getProperty("driver_name"), prop.getProperty("mobile"),
				prop.getProperty("ibutton"), prop.getProperty("icense_num"), prop.getProperty("license_exp"));

		XmlMapper xmlMapper = new XmlMapper();
		String destfilepath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\avlview\\data\\adddriver.xml";
		xmlMapper.writeValue(new File(destfilepath), gir);

		String resstring = xmlMapper.writeValueAsString(gir);
		System.out.println(resstring);

		httpresponse = restclient.post(url, resstring, headers);
		System.out.println(httpresponse);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, testbase.RESPONSE_STATUS_CODE_200);

		String responseStringpost = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");
		System.out.println(responseStringpost);

		Assert.assertEquals(responseStringpost, "Success");

	}

}
