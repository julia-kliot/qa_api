package SuperHero;

import SuperHeroDto.HeroRequiestDto;
import SuperHeroDto.HeroResponseDto;
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
                .gender("")
                .phone("")
                .build();

        HeroResponseDto responseHDto = given()
                .contentType("application/json")
                .body(hero)
                .when()
                .post("superheroes")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(HeroResponseDto.class);

        System.out.println( responseHDto.getId());
       // System.out.println(responseHDto.getBirthDate());
        //System.out.println(responseHDto.getFullName());

    }
    @Test
    public void createHeroNeg(){

            HeroRequiestDto hero = HeroRequiestDto.builder()
                    .birthDate("")
                    .city("Dd12345~")
                    .fullName("")
                    .gender("")
                    .phone("")
                    .build();

            String message = given().contentType(ContentType.JSON)
                    .body(hero)
                    .when()
                    .get("superheroes")
                    .then()
                    .assertThat().statusCode(401)
                    .extract().path("message");

            System.out.println(message);
            Assert.assertEquals(message,"Unauthorized");
    }


}
