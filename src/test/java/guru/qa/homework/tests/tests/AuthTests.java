package guru.qa.homework.tests.tests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.homework.tests.config.Locators.ACCOUNT_INFO;

import guru.qa.homework.tests.config.ProjectConfig;
import guru.qa.homework.tests.helpers.HelperMethods;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class AuthTests {

  private static final ProjectConfig cfg = ConfigFactory.create(ProjectConfig.class);
  private final HelperMethods helperMethods = new HelperMethods();

  @Test
  void authCheckTest() {
    String cookieAuthValue = helperMethods.getCookieValue(cfg.getCookieAuthName());
    open(cfg.getBaseUri());
    helperMethods.addCookieAndRefresh(cfg.getCookieAuthName(), cookieAuthValue);
    $x(ACCOUNT_INFO).shouldHave(exactText(cfg.getLogin()));
  }

}
