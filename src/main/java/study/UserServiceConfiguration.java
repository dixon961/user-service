package study;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import study.hello.EmployeeSet;
import study.hello.MongoData;

/**
 * @author alexey.markov@bostongene.com
 */
@Configuration
public class UserServiceConfiguration {

    @Bean
    public MongoClient mongoClient() {return new MongoClient(); }

    @Bean
    public MongoTemplate mongoTemplate(){ return new MongoTemplate(mongoClient(), "mycustomers"); }

    @Bean
    @Profile("mongo")
    public MongoData mongoData(){ return new MongoData(); }

    @Bean
    @Profile("default")
    public EmployeeSet employeeSet() {return new EmployeeSet();}

}
