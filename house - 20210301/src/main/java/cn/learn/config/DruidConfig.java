package cn.learn.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;

@Configuration
public class DruidConfig {
    @Bean(initMethod = "init",destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.druid")
    public DruidDataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        return new DruidDataSource();
    }
    @Bean
    public Filter statFilter(){
        StatFilter statFilter=new StatFilter();
        statFilter.setSlowSqlMillis(5000);
        statFilter.setLogSlowSql(true);
        statFilter.setMergeSql(true);
        return statFilter;
    }
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
    }
}
