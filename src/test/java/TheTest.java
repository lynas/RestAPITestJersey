import com.jayway.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

/**
 * Created by sazzad on 1/27/16.
 */
public class TheTest {

    @Test
    public void theDet(){
        RestAssured.baseURI = "https://api.github.com/users/";
        RestAssured.given().expect().body("login", Matchers.equalTo("lynas")).when().get("lynas");
    }

    @Test
    public void theDet2(){
        String myJson = "{\"Header\": {},\"Params\": {\"PackageID\": 1}}";
        RestAssured.baseURI  = "http://127.0.0.1/web-corporate/api/submit/corporate/package/get";
        RestAssured.given().contentType("application/json")
                .body(myJson)
                .when()
                .post("")
                .then()
                .statusCode(200)
                .body("Data.PackageID",Matchers.equalTo(1));
    }

    @Test
    public void theDet3(){
        String myJson = "{\"Header\": {},\"Params\": {\"PackageIDs\": [49,50]}}";
        RestAssured.baseURI  = "http://127.0.0.1/web-corporate/api/submit/corporate/package/getCollection";
        RestAssured.given().contentType("application/json")
                .body(myJson)
                .when()
                .post("")
                .then()
                .statusCode(200)
                .body("Data[0].PackageID",Matchers.equalTo(50))
                .body("Data[1].PackageID",Matchers.equalTo(49));
    }
}
