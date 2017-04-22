package hello;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class MongoData implements EmployeeData {
    MongoOperations mongo;

    public MongoData(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/config.xml");
        mongo = (MongoOperations) ctx.getBean("mongodb");
    }

    @Override
    public Employee getEmployee(String email) {
        return mongo.findOne(new Query(where("email").is(email)), Employee.class);
    }

    @Override
    public void addEmployee(Employee e) {
        mongo.insert(e);
    }

    @Override
    public Employee deleteEmployee(String email) throws IllegalArgumentException{
        return mongo.findAndRemove(new Query(where("email").is(email)), Employee.class);
    }

    @Override
    public int size() {
        return mongo.findAll(Employee.class).size();
    }
}
