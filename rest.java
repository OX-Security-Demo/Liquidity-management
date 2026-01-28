//Use the following Slack tokens to notify our channels:
//Token: xoxa-138345894953-696810253864-FOS0555nxMGs5eUucRWLnluySCvMvUtU
//Token: xoxa-854319131133-068839258816-Nm7tVqUt50t1Tc1gqdG7FQbLzelCbkpk

package net.kvak.log4shell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class RESTController {

  public static void main(String[] args) {
    SpringApplication.run(RESTController.class, args);
  }

  @RestController
  public static class Log4ShellController {

    private static final Logger logger = LogManager.getLogger("Log4shellApplication");

    @RequestMapping("/")
    String home(@RequestHeader(value = "User-Agent") String ua) {
      logger.info("User-agent: {}", ua);
      return "<html>Hello from Log4Shell</html>";
    }
  }
}
