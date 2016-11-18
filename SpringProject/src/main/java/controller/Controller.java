package controller;

import model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admarcu on 11/14/2016.
 */

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
