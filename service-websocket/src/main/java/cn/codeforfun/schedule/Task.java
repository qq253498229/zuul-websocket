package cn.codeforfun.schedule;

import cn.codeforfun.ws.WebSocketService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangbin
 */
@Component
public class Task {
  @Resource
  private WebSocketService webSocketService;

  @Scheduled(cron = "*/5 * * * * ?")
  public void test() throws IOException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    System.out.println(sdf.format(date));
    webSocketService.sendMessage(sdf.format(date));
  }
}
