package at.antonio.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MessageController {

    @Value("${my.greeting}")
    private String greetingFromProperty;

    @Value("${ENV_VAR: No env var found :(}")
    private String envVar;

    @Value("${some.list}")
    private List<String> someList;

    @Value("#{${some.spel.map}}") //SPEL expression
    private Map<String, String> someMap;

    @Autowired
    private DbSettings dbSettings;

    @Autowired
    private DatasourceConfig datasourceConfig;

    @Autowired
    private Environment environment;

    @GetMapping("greeting")
    public String greeting() {
        return greetingFromProperty;
    }

    @GetMapping("envvar")
    public String envvar() {
        return envVar;
    }

    @GetMapping("list")
    public List<String> list() {
        return someList;
    }

    @GetMapping("map")
    public Map<String, String> map() {
        return someMap;
    }

    @GetMapping("db")
    public String dbSettings() {
        return dbSettings.toString();
    }

    @GetMapping("datasource")
    public String repo() {
        return datasourceConfig.toString();
    }

    //Try to avoid Environment, whenever possible use Value injection
    @GetMapping("envdetails")
    public String envDetails() {
        return environment.toString();
    }
}
