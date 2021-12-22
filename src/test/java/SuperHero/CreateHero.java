package SuperHero;

import SuperHeroDto.HeroRequiestDto;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.AuthRequestDto;
import dto.AuthResponseDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class CreateHero {
    @BeforeMethod
    public void precondition() {
        RestAssured.baseURI = "https://superhero.qa-test.csssr.com/+";
        RestAssured.basePath = "api";
    }
    @Test
    public void createTestSucces() {
        HeroRequiestDto hero = HeroRequiestDto.builder()
                .birthDate("")
                .city("Dd12345~")
                .fullName("")
                .gender()
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
    public void createHeroNeg(){

            AuthRequestDto auth = AuthRequestDto.builder()
                    .email("dolly@gmail.com")
                    .password("Dd12345")
                    .build();

            String message = given().contentType(ContentType.JSON)
                    .body(auth)
                    .when()
                    .get("login")
                    .then()
                    .assertThat().statusCode(401)
                    .extract().path("message");

            System.out.println(message);
            Assert.assertEquals(message,"Wrong email or password");
    }


}
