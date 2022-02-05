package guru.qa.homework.tests.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.MERGE)
@Sources({"file:./project.properties", "classpath:default.properties"})
public interface ProjectConfig extends Config {

  @Key("base.uri")
  @DefaultValue("http://demowebshop.tricentis.com")
  String getBaseUri();

  @Key("login")
  @DefaultValue("test2467851@mai.ru")
  String getLogin();

  @Key("password")
  @DefaultValue("123456")
  String getPassword();

  @Key("cookie.auth.name")
  @DefaultValue("NOPCOMMERCE.AUTH")
  String getCookieAuthName();

}
