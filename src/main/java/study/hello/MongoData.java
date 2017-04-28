package study.hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
@Profile("mongo")
public class MongoData implements EmployeeData {

    @Autowired
    private MongoOperations mongo;

    @Override
    public Employee getEmployee(String email) {
        return this.mongo.findOne(new Query(where("email").is(email)), Employee.class);
    }

    @Override
    public void addEmployee(Employee e) { this.mongo.insert(e); }

    @Override
    public Employee deleteEmployee(String email) throws IllegalArgumentException{
        return this.mongo.findAndRemove(new Query(where("email").is(email)), Employee.class);
    }

    @Override
    public int size() {
        return mongo.findAll(Employee.class).size();
    }
}
