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
import com.avlview.data.getvehiclesnapshotinaccountSG;
import com.avlview.util.TestUtil;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class getvehiclesnapshotinaccountSGTest extends TestBase {

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
		apiposturl = prop.getProperty("getvehiclesnapshotinaccountSG");

		url = serviceurl + apiposturl;
		System.out.println(url);

	}

	@Test(enabled = true, groups = { "Post Requests" })
	public void getvehiclesnapshotinaccountSG()
			throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();

		headers.put("apiKey", prop.getProperty("apiKey_Get_Halwani"));
		headers.put("Accept", prop.getProperty("Accept"));

		String Vehicle1 = prop.getProperty("veh1id");
		String Vehicle2 = prop.getProperty("veh2id");
		String megedlist = Vehicle1 + " " + Vehicle2;
		System.out.println(megedlist);

		String result = megedlist.replaceAll(" ", ",");

		System.out.println(result);

		getvehiclesnapshotinaccountSG gvsa = new getvehiclesnapshotinaccountSG(result);

		XmlMapper xmlMapper = new XmlMapper();
		String destfilepath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\avlview\\data\\getvehiclesnapshotinaccountSG.xml";
		xmlMapper.writeValue(new File(destfilepath), gvsa);

		String resstring = xmlMapper.writeValueAsString(gvsa);
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

		JSONArray apn = responsejson.getJSONArray("vehiclesnapshot");
		System.out.println(apn.length());

		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		System.out.println(allheaders);

	}

}
