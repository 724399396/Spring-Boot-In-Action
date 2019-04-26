package readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoTraceRepository implements HttpTraceRepository {
    private MongoOperations mongoOperations;

    @Autowired
    public MongoTraceRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<HttpTrace> findAll() {
        return mongoOperations.findAll(HttpTrace.class);
    }

    @Override
    public void add(HttpTrace trace) {
        mongoOperations.save(trace);
    }
}
