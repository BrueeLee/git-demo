package cn.learn;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@MapperScan("cn.learn.mapper")
@MapperScan("cn.learn.mapper")
public class SpringConfig {
    public static void main(String[] args) {
        SpringApplication.run(SpringConfig.class,args);
    }
}
