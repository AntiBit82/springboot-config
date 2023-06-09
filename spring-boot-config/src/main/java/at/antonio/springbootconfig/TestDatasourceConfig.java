package at.antonio.springbootconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestDatasourceConfig implements DatasourceConfig {
    @Override
    public String toString() {
        return "TestRepository{}";
    }

    @Override
    public void setup() {

    }
}
