package helpers;
import org.aeonbits.owner.ConfigFactory;
import tests.config.BrowserStackConfig;

import static io.restassured.RestAssured.given;

public class Browserstack {
    public static String videoUrl(String sessionId) {
        BrowserStackConfig credentials =
                ConfigFactory.create(BrowserStackConfig.class);
        return given()
                .auth().basic(credentials.getBrowserstackUser(), credentials.getBrowserstackKey())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}
