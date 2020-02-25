package com.example.demo;

import java.awt.List;
import java.util.ArrayList;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.http.NameValuePair;
@RestController
public class test {
@RequestMapping
public String testdata() {
	return "hello";
	
	
}
private void sendPost() throws Exception {

    HttpPost post = new HttpPost("https://httpbin.org/post");

    // add request parameter, form parameters
    List<NameValuePair> urlParameters = new ArrayList<>();
    urlParameters.add(new BasicNameValuePair("username", "abc"));
    urlParameters.add(new BasicNameValuePair("password", "123"));
    urlParameters.add(new BasicNameValuePair("custom", "secret"));

    post.setEntity(new UrlEncodedFormEntity(urlParameters));

    try (CloseableHttpClient httpClient = HttpClients.createDefault();
         CloseableHttpResponse response = httpClient.execute(post)) {

        System.out.println(EntityUtils.toString(response.getEntity()));
    }

}
}
