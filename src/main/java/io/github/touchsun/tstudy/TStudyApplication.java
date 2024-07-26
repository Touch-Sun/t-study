package io.github.touchsun.tstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * t-study
 *
 * @author lee
 * @since 2024/7/25 17:13
 */
@SpringBootApplication
@EnableMongoAuditing // enable mongo auditing autofill create_time... create_by... update_time... update_by...
@EnableReactiveMongoRepositories(basePackages = "io.github.touchsun.tstudy") // enable reactive mongo repositories for aspect logic del
public class TStudyApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TStudyApplication.class, args);
    }
}
