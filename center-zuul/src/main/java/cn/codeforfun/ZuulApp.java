package cn.codeforfun;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author wangbin
 */
@SpringCloudApplication
@EnableZuulProxy
public class ZuulApp {
  public static void main(String[] args) {
    SpringApplication.run(ZuulApp.class, args);
  }
}
