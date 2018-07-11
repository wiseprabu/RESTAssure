package Test;


import com.jayway.restassured.RestAssured;

import org.junit.Test;

/**
 * Unit test for response check.
 */
public class ServiceResponseCheck
{


    @Test()
    public void bookRoomResponseCheck(){
        RestAssured.baseURI="http://localhost:9090/bookRoom";
        String response = RestAssured.given().param("numOfDays","checkInDate").param("1","2013-01-10").when().get().then().extract().asString();
        System.out.println("Response is:" +response);
    }



}

