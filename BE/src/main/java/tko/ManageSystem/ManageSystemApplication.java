package tko.ManageSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Daniel kim
 * MapperScan : basePackageClass와 동일한 패키지 혹은 하위 패키지들의 @Mapper 클래스들을 탐색
 * 2023-04-12
 */



@MapperScan(basePackageClasses = ManageSystemApplication.class)
@EnableAspectJAutoProxy // 오토 프록싱(AOP)
@EnableScheduling
@SpringBootApplication
public class ManageSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageSystemApplication.class, args);
	}

}
