package guru.qa.homework.tests.helpers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import guru.qa.homework.tests.api.ApiMethods;
import guru.qa.homework.tests.config.ProjectConfig;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Cookie;

public class HelperMethods {

  private static final ProjectConfig cfg = ConfigFactory.create(ProjectConfig.class);
  private final ApiMethods apiMethods = new ApiMethods();

  public String getCookieValue(String cookieName) {
    Response response = apiMethods.postMethodLogin(cfg.getLogin(), cfg.getPassword());
    response.then().statusCode(302);
    return response.getCookie(cookieName);
  }

  public void addCookieAndRefresh(String name, String value) {
    WebDriverRunner.getWebDriver().manage().addCookie(new Cookie(name, value));
    Selenide.refresh();
  }

}
