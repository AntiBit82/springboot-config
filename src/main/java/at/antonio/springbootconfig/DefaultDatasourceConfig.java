package at.antonio.springbootconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class DefaultDatasourceConfig implements DatasourceConfig {
    @Override
    public String toString() {
        return "DefaultRepository{}";
    }

    @Override
    public void setup() {

    }
}
