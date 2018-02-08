package cn.codeforfun;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author wangbin
 */
@SpringCloudApplication
@EnableScheduling
public class App {
  @Bean
  public ServerEndpointExporter serverEndpointExporter() {
    return new ServerEndpointExporter();
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
