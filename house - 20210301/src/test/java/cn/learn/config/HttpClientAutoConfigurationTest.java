package cn.learn.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientAutoConfigurationTest {
    @Autowired
private org.apache.http.client.HttpClient HttpClient;
@Test
    public void HttpClient() throws IOException {
    System.out.println(HttpClient.execute(new HttpGet("http://www.baidu.com")).getEntity().toString());
}

}
