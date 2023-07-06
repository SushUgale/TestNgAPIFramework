package Request_Repository;

public class Post_Request_Repository {
	
	public static String BaseURI() {
		String BaseURI = "https://reqres.in/";
		return BaseURI;

	}

	public static String post_Resource() {
		String Resource = "api/users";
		return Resource;
	}

	public static String post_Req_TC1() {

		String requestBody = "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}";
		return requestBody;
	}



}
