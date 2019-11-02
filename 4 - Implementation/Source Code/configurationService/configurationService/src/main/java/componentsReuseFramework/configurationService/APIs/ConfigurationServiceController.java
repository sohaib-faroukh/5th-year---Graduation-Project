package componentsReuseFramework.configurationService.APIs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ConfigurationServiceController {

    @RequestMapping("/")
    public String welcome_1(){
        return "Welcome";
    }


    @RequestMapping("/index")
    public String welcome_2(){
        return "Welcome";
    }
}
