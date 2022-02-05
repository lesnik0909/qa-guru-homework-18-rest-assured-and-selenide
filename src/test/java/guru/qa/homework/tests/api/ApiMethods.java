package guru.qa.homework.tests.api;

import static guru.qa.homework.tests.config.EndPoints.LOGIN;
import static io.restassured.RestAssured.given;

import guru.qa.homework.tests.utils.Specifications;
import io.restassured.response.Response;

public class ApiMethods {

  public Response postMethodLogin(String login, String password) {
    return given()
        .spec(Specifications.requestSpec())
        .formParam("Email", login)
        .formParam("Password", password)
        .post(LOGIN);
  }

}
