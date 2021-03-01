package cn.learn.config;


import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({HttpClient.class})
@EnableConfigurationProperties(HttpClientProperties.class)
public class HttpClientAutoConfiguration {
    private final HttpClientProperties properties;


    public HttpClientAutoConfiguration(HttpClientProperties properties) {
        this.properties = properties;
    }
    @Bean
    @ConditionalOnMissingBean(HttpClient.class)
    public HttpClient httpClient(){
        RequestConfig requestConfig= RequestConfig.custom().setConnectTimeout(properties.getConnectTimeOut())
                .setSocketTimeout(properties.getSocketTimeOut()).build();
        HttpClient client=  HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig) //设置requestConfig
                .setUserAgent(properties.getAgent())//设置User-Agent
                .setMaxConnPerRoute(properties.getMaxConnPerRoute())//设置一个远端IP最大的连接数
                .setMaxConnTotal(properties.getMaxConnTotal())//设置总的连接数
                .build();
        return client;
    }
}
