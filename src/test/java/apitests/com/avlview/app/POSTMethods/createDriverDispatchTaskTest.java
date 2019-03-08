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
import com.avlview.data.createDriverDispatchTask;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class createDriverDispatchTaskTest extends TestBase {

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
		apiposturl = prop.getProperty("createDriverDispatchTask");

		url = serviceurl + apiposturl;
		System.out.println(url);

	}

	@Test(enabled = true, groups = { "Post Requests" })
	public void createDriverDispatchTask()
			throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();

		headers.put("apiKey", prop.getProperty("apiKey_Odometer"));
		headers.put("Accept", prop.getProperty("Accept"));

		createDriverDispatchTask cdt = new createDriverDispatchTask(prop.getProperty("task_id"),
				prop.getProperty("driver_id"), prop.getProperty("group_code"), prop.getProperty("task_desc"),
				prop.getProperty("task_dt"), prop.getProperty("task_f_desc"), prop.getProperty("contact_code"),
				prop.getProperty("contact_name"), prop.getProperty("email"), prop.getProperty("isd_code"),
				prop.getProperty("mobile"), prop.getProperty("lat"), prop.getProperty("lon"),
				prop.getProperty("contact_location"));

		XmlMapper xmlMapper = new XmlMapper();
		String destfilepath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\avlview\\data\\createDriverDispatchTask.xml";
		xmlMapper.writeValue(new File(destfilepath), cdt);

		String resstring = xmlMapper.writeValueAsString(cdt);
		System.out.println(resstring);

		httpresponse = restclient.post(url, resstring, headers);
		System.out.println(httpresponse);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, testbase.RESPONSE_STATUS_CODE_200);

		String responseStringpost = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");
		System.out.println(responseStringpost);

		Assert.assertEquals(responseStringpost, "S");

	}

}
