package Test;


import com.jayway.restassured.response.Response;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class GettingRoomAvailability {

    //1. To check the room availability with valid date format
    @Test()
    public void bookingRoomAvailability(){
        Response respo = given().when().get("http://localhost:9090/checkAvailability/2014-01-01");
        System.out.println(respo.asString());
    }

    //2. To check the room availability with invalid date
    @Test()
    public void bookingRoomAvailabilityInvalidDate(){
        Response respo = given().when().get("http://localhost:9090/checkAvailability/2014-01");
        System.out.println(respo.asString());
    }

    //3. To check the room availability with invalid date format
    @Test()
    public void bookingRoomAvailabilityInvalidFormat(){
        Response respo = given().when().get("http://localhost:9090/checkAvailability/2014-31-31");
        System.out.println(respo.asString());
    }

    //4. To check the room availability with maximum integer entered in  date format
    @Test()
    public void bookingRoomAvailabilityMaxDate(){
        Response respo = given().when().get("http://localhost:9090/checkAvailability/9999-99-99");
        System.out.println(respo.asString());
    }

    //5. To check the room availability with zero value in date format
    @Test()
    public void bookingRoomAvailabilityZeroDate(){
        Response respo = given().when().get("http://localhost:9090/checkAvailability/0000-00-00");
        System.out.println(respo.asString());
    }

    //6. To check the room availability with special characters in date format
    @Test()
    public void bookingRoomAvailabilitySpecialChar(){
        Response respo = given().when().get("http://localhost:9090/checkAvailability/@@@@-@@-@@");
        System.out.println(respo.asString());
    }


}