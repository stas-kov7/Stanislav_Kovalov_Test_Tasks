package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BookingTest {
    private String myToken;

    @BeforeTest
    public void auth() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"username\": \"admin\", \"password\": \"password123\" }")
                .post("https://restful-booker.herokuapp.com/auth");
        myToken = response.jsonPath().getString("token");
    }

    @Test
    public void creatingBookingTest() {
        String requestBody = "{ \"firstname\": \"John\", \"lastname\": \"Doe\", \"totalprice\": 222, \"depositpaid\": true, \"bookingdates\": { \"checkin\": \"2023-04-01\", \"checkout\": \"2023-04-10\" }, \"additionalneeds\": \"Breakfast\" }";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + myToken)
                .body(requestBody)
                .post("https://restful-booker.herokuapp.com/booking");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.jsonPath().getString("booking.firstname"), "John");
        softAssert.assertEquals(response.jsonPath().getString("booking.lastname"), "Doe");
        softAssert.assertEquals(response.jsonPath().getInt("booking.totalprice"), 222);
        softAssert.assertAll();
    }

    @Test
    public void getBookingTest() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + myToken)
                .get("https://restful-booker.herokuapp.com/booking/2");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void getBookingsTest() {

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + myToken)
                .get("https://restful-booker.herokuapp.com/booking");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void updateBookingTest() {
        String requestBody = "{ \"firstname\": \"Adam\", \"lastname\": \"Dork\", \"totalprice\": 100, \"depositpaid\": true, \"bookingdates\": { \"checkin\": \"2023-04-01\", \"checkout\": \"2023-04-10\" }, \"additionalneeds\": \"Breakfast\" }";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + myToken)
                .body(requestBody)
                .put("https://restful-booker.herokuapp.com/booking/932");
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void removeBookingTest() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" )
                .delete("https://restful-booker.herokuapp.com/booking/12065");
        Assert.assertNotNull(response.getBody());
    }
}