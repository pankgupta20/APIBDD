package apiTests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiConfigs.APIPaths;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest extends BaseTest {

	@Test
	public void getTest() {
		Response response = RestAssured.given().when().get(APIPaths.GET_LIST_OF_POSTS);

		JSONArray jarray = new JSONArray(response.getBody().asString());
		for (int i = 0; i < jarray.length(); i++) {
			JSONObject obj = jarray.getJSONObject(i);
			System.out.println(obj);
			test.log(LogStatus.INFO, obj.toString());
		}
	}

}
