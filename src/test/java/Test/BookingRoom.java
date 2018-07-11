package Test;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.Test;


/**
 * Test scripts for book a room.
 */
public class BookingRoom
{
    //1. To Check rooms availability based on valid check in date and valid number of days
    @Test()
    public void bookingRoomValid(){
        Response resp =   given().body("{\"numOfDays\":\"4\",\"checkInDate\":\"2014-01-10\"}").when().contentType(ContentType.JSON).post("http://localhost:9090/bookRoom");
        System.out.println(resp.asString());
    }

    //2. To check rooms availability based on invalid check in date and valid number of days
    @Test()
    public void bookingRoomInvalidDate(){
        Response resp =   given().body("{\"numOfDays\":\"4\",\"checkInDate\":\"2014-10\"}").when().contentType(ContentType.JSON).post("http://localhost:9090/bookRoom");
        System.out.println(resp.asString());
    }

    //3. To check rooms availability based on invalid check in date format and valid number of days
    @Test()
    public void bookingRoomInvalidDateFormat(){
        Response resp =   given().body("{\"numOfDays\":\"4\",\"checkInDate\":\"2014-31-31\"}").when().contentType(ContentType.JSON).post("http://localhost:9090/bookRoom");
        System.out.println(resp.asString());
    }

    //4. To check rooms availability based on invalid check in date and NULL number of days
    @Test()
    public void bookingRoomInvalidDateNullDay(){
        Response resp =   given().body("{\"numOfDays\":\"0\",\"checkInDate\":\"2014-10\"}").when().contentType(ContentType.JSON).post("http://localhost:9090/bookRoom");
        System.out.println(resp.asString());
    }

    //5. To check rooms availability based on NULL check in date and NULL number of days
    @Test()
    public void bookingRoomNullDateNullDay(){
        Response resp =   given().body("{\"numOfDays\":\"0\",\"checkInDate\":\"\"}").when().contentType(ContentType.JSON).post("http://localhost:9090/bookRoom");
        System.out.println(resp.asString());
    }

    //6. To check rooms availability based on zero check in date and number of days
    @Test()
    public void bookingRoomZeroDate(){
        Response resp =   given().body("{\"numOfDays\":\"1\",\"checkInDate\":\"0000-00-00\"}").when().contentType(ContentType.JSON).post("http://localhost:9090/bookRoom");
        System.out.println(resp.asString());
    }

    //7. To check rooms availability based on max check in date and number of days
    @Test()
    public void bookingRoomMaxDate(){
        Response resp =   given().body("{\"numOfDays\":\"1\",\"checkInDate\":\"9999-99-99\"}").when().contentType(ContentType.JSON).post("http://localhost:9090/bookRoom");
        System.out.println(resp.asString());
    }

    //8. To check rooms availability based on valid check in date and null days
    @Test()
    public void bookingRoomNullDate(){
        Response resp =   given().body("{\"numOfDays\":\"0\",\"checkInDate\":\"2014-01-10\"}").when().contentType(ContentType.JSON).post("http://localhost:9090/bookRoom");
        System.out.println(resp.asString());

    }

    // 9. To check rooms availability based on special character entered in date field with proper date
    @Test()
    public void bookingRoomSpecialChar(){
        Response resp =   given().body("{\"numOfDays\":\"$\",\"checkInDate\":\"2014-01-10\"}").when().contentType(ContentType.JSON).post("http://localhost:9090/bookRoom");
        System.out.println(resp.asString());

    }
}

