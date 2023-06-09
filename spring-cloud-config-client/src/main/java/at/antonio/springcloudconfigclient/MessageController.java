package at.antonio.springcloudconfigclient;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //Refresh props from the server without needing to restart anything (needs actuator dependency)
//+needs a POST request to microservice endpoint localhost:8081/actuator/refresh
public class MessageController {

    @Value("${ENV_VAR: No env var found :(}")
    private String envVar;

    @Value("${some.list}")
    private List<String> someList;

    @Value("${my.server.port}")
    private String mySpecificPort;

    //Doesn't exist on ConfigServer, nor in application.properties
    @Value("${i.dont.exist: I need a default value}")
    private String iDontExistAnywhere;

    //Doesn't exist on ConfigServer but in application.properties
    @Value("${i.exist.in.localprops.only}")
    private String iExistOnlyInLocalProps;

    @Autowired
    private DbSettings dbSettings;

    @GetMapping("envvar")
    public String envvar() {
        return envVar;
    }

    @GetMapping("list")
    public List<String> list() {
        return someList;
    }

    @GetMapping("db")
    public String dbSettings() {
        return dbSettings.toString();
    }

    @GetMapping("port")
    public String port() {
        return mySpecificPort;
    }
}
