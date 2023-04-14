package memo.liquor.myliquor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MyliquorApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyliquorApplication.class, args);
  }

}
