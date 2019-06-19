package com.myservice;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.myservice.dao")
@EnableSwagger2
@Import(FdfsClientConfig.class)
//@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class MyserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyserviceApplication.class, args);
	}

}
