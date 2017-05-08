package test.jersey.series.spring.hibernate.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class TestBookService {

	public static void main(String[] args) {

		// setting & invoking first service getBook/10001
		System.out.println("Invoking and executing getBook service for book id 2");
		String httpGetURL = "http://localhost:8080/Jersey-Spring-Hibernate/rest/bookservice/getbook/2";
		String responseStringGet = testBookServiceForGetRequest(httpGetURL);
		System.out.println("GET >> Response String : " + responseStringGet);

		// setting & invoking second service addBook with XML request
		System.out.println("\n\nInvoking and executing addBook service with request XML");
		String httpPostURL = "http://localhost:8080/Jersey-Spring-Hibernate/rest/bookservice/addbook";
		String requestString = "{"
				+ 					" \"bookId\": 6, " 
				+ 					" \"bookName\": \"Lange Microbiology and Infectious Diseases\","
				+ 					" \"author\": \"Kenneth D. Somers\","
				+					" \"category\": \"Microbiology\""
				+				"}";
		String responseStringPost = testBookServiceForPostRequest(httpPostURL, requestString);
		System.out.println("POST >> Response String : " + responseStringPost);
	}

	/**
	 * 
	 * @param httpURL
	 * @return
	 */
	public static String testBookServiceForGetRequest(String httpURL){

		// local variables
		ClientConfig clientConfig = null;
		Client client = null;
		WebTarget webTarget = null;
		Invocation.Builder invocationBuilder = null;
		Response response = null;
		int responseCode;
		String responseMessageFromServer = null;
		String responseString = null;

		try{
			// invoke service after setting necessary parameters
			clientConfig = new ClientConfig();
			client =  ClientBuilder.newClient(clientConfig);
			//			client.property("Content-Type", MediaType.APPLICATION_FORM_URLENCODED);
			//			client.property("accept", MediaType.APPLICATION_XML);
			webTarget = client.target(httpURL);

			// invoke service
			invocationBuilder = webTarget.request(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_XML);
			//			invocationBuilder.header("some-header", "header-value");
			response = invocationBuilder.get();

			// get response code
			responseCode = response.getStatus();
			System.out.println("Response code: " + responseCode);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + responseCode);
			}

			// get response message
			responseMessageFromServer = response.getStatusInfo().getReasonPhrase();
			System.out.println("ResponseMessageFromServer: " + responseMessageFromServer);

			// get response string
			responseString = response.readEntity(String.class);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			// release resources, if any
			response.close();
			client.close();
		}
		return responseString;
	}

	/**
	 * 
	 * @param httpURL
	 * @param requestString
	 * @return
	 */
	public static String testBookServiceForPostRequest(String httpURL, String requestString) {

		// local variables
		ClientConfig clientConfig = null;
		Client client = null;
		WebTarget webTarget = null;
		Builder builder = null;
		Response response = null;
		int responseCode;
		String responseMessageFromServer = null;
		String responseString = null;

		try{
			// invoke service after setting necessary parameters
			clientConfig = new ClientConfig();
			client =  ClientBuilder.newClient(clientConfig);
			//			client.property("Content-Type", MediaType.APPLICATION_FORM_URLENCODED);
			//			client.property("accept", MediaType.APPLICATION_JSON);
			webTarget = client.target(httpURL);

			// invoke service
			builder = webTarget.request(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_JSON);
			response = builder.post(Entity.entity(requestString, MediaType.APPLICATION_JSON));

			// get response code
			responseCode = response.getStatus();
			System.out.println("Response code: " + responseCode);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + responseCode);
			}

			// get response message
			responseMessageFromServer = response.getStatusInfo().getReasonPhrase();
			System.out.println("ResponseMessageFromServer: " + responseMessageFromServer);

			// get response string
			responseString = response.readEntity(String.class);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			// release resources, if any
			response.close();
			client.close();
		}
		return responseString;
	}
}