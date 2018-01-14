package com.example.testoc;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.databene.benerator.anno.Source;
import org.databene.feed4testng.FeedTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class FormTest extends FeedTest{
	@Test(dataProvider="feeder")
	@Source("./data/add.csv")
	public void doGet(String a, String b, String expected) throws Exception {
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet("http://192.168.119.159:8080/demo/FormServlet?a=" + a + "&b=" + b);
		CloseableHttpResponse response = client.execute(request);
		String actual = EntityUtils.toString(response.getEntity());
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}


}
