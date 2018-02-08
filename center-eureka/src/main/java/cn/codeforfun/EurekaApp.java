package cn.codeforfun;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wangbin
 */
@SpringCloudApplication
@EnableEurekaServer
public class EurekaApp {
  public static void main(String[] args) {
    SpringApplication.run(EurekaApp.class, args);
  }
}
