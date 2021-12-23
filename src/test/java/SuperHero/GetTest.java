package SuperHero;

import SuperHeroDto.HeroResponseDto;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class GetTest {
    Integer id= 56789;

    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI = "";
        RestAssured.basePath = "api";
    }
    @Test
    public void deleteHeroSuccess(){

        given().header("Description", id)
                .when()
                .get("superheroes/{id}",19987)
                .then()
                .statusCode(200)
                .assertThat()
                //.body();
                .extract().response().as(HeroResponseDto.class);

        //for (RecordDto record : allRecordsDto.getRecords()) {
         //   System.out.println(record.getId());
          //  System.out.println("***********");
        }
    }
}
