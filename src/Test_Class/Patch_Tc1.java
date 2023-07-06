package Test_Class;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_Api_Method.Api_Method_Patch;
import Request_Repository.Patch_Request_Repository;
import io.restassured.path.json.JsonPath;

public class Patch_Tc1 {
	
	@Test
	public static void extractor() {
		for (int i = 0; i < 5; i++) {
			int statusCode = Api_Method_Patch.ResponseStatusCode(Patch_Request_Repository.BaseURI(),
					Patch_Request_Repository.patch_Resource(), Patch_Request_Repository.patch_Req_TC1());

			if (statusCode == 200) {
				System.out.println(statusCode);
				String responseBody = Api_Method_Patch.Response_Body(Patch_Request_Repository.BaseURI(),
						Patch_Request_Repository.patch_Resource(), Patch_Request_Repository.patch_Req_TC1());
				String requestBody = Patch_Request_Repository.patch_Req_TC1();
				Validation(requestBody, responseBody);
				break;
			} else {
				System.out.println("Incorrect Status Code");
			}
		}
	}

	public static void Validation(String requestBody, String responseBody) {

		JsonPath jspRequest = new JsonPath(requestBody);
		String req_name = jspRequest.getString("name");
		String req_job = jspRequest.getString("job");

		JsonPath jspResponse = new JsonPath(responseBody);
		String res_name = jspResponse.getString("name");
		String res_job = jspResponse.getString("job");
		System.out.println(res_name);
		System.out.println(res_job);

		String res_updatedAt = jspResponse.getString("updatedAt");
		res_updatedAt = res_updatedAt.substring(0, 11);
		System.out.println(res_updatedAt);

		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);

	}


}
