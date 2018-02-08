package cn.codeforfun;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author wangbin
 */
@SpringCloudApplication
@EnableScheduling
@RestController
public class App {
  @GetMapping("/test")
  public ResponseEntity test() {
    return ResponseEntity.ok("test");
  }

  @Bean
  public ServerEndpointExporter serverEndpointExporter() {
    return new ServerEndpointExporter();
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
