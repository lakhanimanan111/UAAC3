package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;

import pojo.AccessToken;
import utils.SessionAttributes;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		OkHttpClient client = new OkHttpClient();
		System.out.println(req.getParameter("Username"));
		System.out.println(req.getParameter("Password"));
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "username=user1&password=cloud&grant_type=password&scope=");
		Request request = new Request.Builder()
		  .url("https://uaa.bosh-lite.com/oauth/token")
		  .post(body)
		  .addHeader("accept", "application/json")
		  .addHeader("content-type", "application/x-www-form-urlencoded")
		  .addHeader("authorization", "Basic Y2Y6")
		  .addHeader("x-uaa-endpoint", "UAA_Endpoint")
		  //.addHeader("cache-control", "no-cache")
		  //.addHeader("postman-token", "07b29808-853d-5079-5401-4ae2973a33a4")
		  .build();

		Response response = client.newCall(request).execute();
		String json = response.body().string();
		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();
		AccessToken obj = mapper.readValue(json, AccessToken.class);
		System.out.println(obj.getAccess_token());
		req.getSession().setAttribute(SessionAttributes.STR_ACCESS_TOKEN,obj.getAccess_token());
		RequestDispatcher rd = req.getRequestDispatcher("/getApps");
		rd.forward(req,resp);
		

		
		
		
	
	}
}
