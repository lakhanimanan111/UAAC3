package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import pojo.AccessToken;
import pojo.AppData;
import pojo.Resources;
import pojo.appsDetails.AppsDetail;
import pojo.orgs.Orgs;
import pojo.spaces.Spaces;
import utils.SessionAttributes;

@WebServlet("/getApps")
public class AppsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acess_token = (String) req.getSession().getAttribute(SessionAttributes.STR_ACCESS_TOKEN);
		OkHttpClient client = new OkHttpClient();
		
		String responseString = "<HTML> ";
		responseString += "<style>\n" + 
				"table {\n" + 
				"    font-family: arial, sans-serif;\n" + 
				"    border-collapse: collapse;\n" + 
				"    width: 100%;\n" + 
				"}\n" + 
				"\n" + 
				"td, th {\n" + 
				"    border: 1px solid #dddddd;\n" + 
				"    text-align: left;\n" + 
				"    padding: 8px;\n" + 
				"}\n" + 
				"\n" + 
				"tr:nth-child(even) {\n" + 
				"    background-color: #dddddd;\n" + 
				"}\n" + 
				"</style>";
				responseString += "<Body>";	
		responseString += " <table> ";
		responseString += "<tr> Spaces </tr>";
		
		
		//spaces
		Request request1 = new Request.Builder()
				  .url("http://api.bosh-lite.com/v2/spaces")
				  .get()
				  .addHeader("authorization", "bearer " +acess_token)
				  .build();

				Response response1 = client.newCall(request1).execute();
				String json1 = response1.body().string();
				ObjectMapper mapper1 = new ObjectMapper();
				Spaces spaceobj = mapper1.readValue(json1, Spaces.class);
				List<pojo.spaces.Resources> resources = spaceobj.getResources();
			
				for(pojo.spaces.Resources r : resources) {
					
					responseString += ("<tr> " + r.getEntity().getName() + " </tr>");
				}
				responseString+= "</table>";
				responseString += " <table> ";
				responseString += "<th> Orgs </th>";
		
		//orgs
				Request request2 = new Request.Builder()
						  .url("http://api.bosh-lite.com/v2/organizations")
						  .get()
						  .addHeader("authorization", "bearer " +acess_token)
						  .build();

						Response response2 = client.newCall(request2).execute();
						String json2 = response2.body().string();
						ObjectMapper mapper2 = new ObjectMapper();
						Orgs orgobj2 = mapper2.readValue(json2, Orgs.class);
						
						List<pojo.orgs.Resources> resources2 = orgobj2.getResources();
						
						for(pojo.orgs.Resources r : resources2) {
							
							responseString += "<tr> " + r.getEntity().getName() + " </tr>";
						}
						responseString+= "</table>";
						responseString += " <table> ";
						responseString += "<tr> Orgs </tr>";
						
		
		//apps
		Request request3 = new Request.Builder()
		  .url("http://api.bosh-lite.com/v2/apps")
		  .get()
		  .addHeader("authorization", "bearer " +acess_token)
		  .build();

		Response response3 = client.newCall(request3).execute();
		String json3 = response3.body().string();
		ObjectMapper mapper3 = new ObjectMapper();
		AppData obj3 = mapper3.readValue(json3, AppData.class);
		List<Resources> resources3 = obj3.getResources();
		
		
		for(Resources r : resources3) {
			responseString += " <tr> <th>" + (r.getEntity().getName()) + "</th></tr>";
		}
		
		
		responseString += "</table>";
		//getting the URl
		for(Resources r : resources3) {
			String url = "http://api.bosh-lite.com/v2/apps";
			String guid = r.getMetadata().getGuid();
			String finalUrl = url+"/"+guid+"/env";
			
			System.out.println(finalUrl);
			 
//			Request request4 = new Request.Builder()
//					  .url(finalUrl)
//					  .get()
//					  .addHeader("authorization", "bearer " +acess_token)
//					  .build();
//
//					Response response4 = client.newCall(request4).execute();
//					String json4 = response4.body().string();
//					ObjectMapper mapper4 = new ObjectMapper();
//					AppsDetail obj4 = mapper4.readValue(json4, AppsDetail.class);
//					List<String> Uris = obj4.getApplication_env_json().getVCAP_APPLICATION().getApplication_uris();
//					responseString += "<table>";
//					for(String uri:Uris) {
//						System.out.println(uri);
//						responseString += "<tr>application URI: "+uri+" </tr>";
//						
//					}
				}

		responseString+= "</table></Body></HTML>";
		resp.getWriter().println(responseString);

	}
	

}
