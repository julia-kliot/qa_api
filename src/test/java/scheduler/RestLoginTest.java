package scheduler;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.AuthRequestDto;
import dto.AuthResponseDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class RestLoginTest {
    @BeforeMethod
    public void precondition() {
        RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/";
        RestAssured.basePath = "api";
    }

    @Test
    public void loginTestSuccess() {
        AuthRequestDto auth = AuthRequestDto.builder()
                .email("dolly@gmail.com")
                .password("Dd12345~")
                .build();

        AuthResponseDto responseDto = given()
                .contentType("application/json")
                .body(auth)
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);

        System.out.println( responseDto.getToken());
        System.out.println(responseDto.getStatus());
        System.out.println(responseDto.getRegistration());

    }
    @Test
    public void loginWrongPassword(){
        AuthRequestDto auth = AuthRequestDto.builder()
                .email("dolly@gmail.com")
                .password("Dd12345")
                .build();

        Error errorDto = given().contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(Error.class);

        System.out.println(errorDto.toString());
    }
    @Test
    public void loginWrongPassword2(){
        AuthRequestDto auth = AuthRequestDto.builder()
                .email("dolly@gmail.com")
                .password("Dd12345")
                .build();

        String message = given().contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(401)
                .extract().path("message");

        System.out.println(message);
        Assert.assertEquals(message,"Wrong email or password");
    }
}
