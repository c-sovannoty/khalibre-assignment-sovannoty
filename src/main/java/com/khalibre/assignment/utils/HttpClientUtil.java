package com.khalibre.assignment.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientUtil {

	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String URL = "https://api.github.com/search/repositories";
	//https://api.github.com/search/repositories?q=liferay-portal+language:JavaScript
	// HTTP GET request
	public static String sendGet(String requestParameters) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(URL+requestParameters);
		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		 return result.toString();
	}

}
