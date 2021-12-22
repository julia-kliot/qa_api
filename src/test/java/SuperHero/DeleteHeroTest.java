package SuperHero;

public class DeleteHeroTest {
    @Test
    public void deleteRecordsSuccess(){

//        String  status = given().header("Authorization",token)
//                .when()
//                .delete("record/{id}",19988)
//                .then()
//                .statusCode(200)
//                .extract().path("status");
//        System.out.println(status);
        //was deleted

        given().header("Authorization",token)
                .when()
                .delete("record/{id}",19987)
                .then()
                .statusCode(200)
                .assertThat()
                .body("status", containsString("was deleted"));

    }
}
