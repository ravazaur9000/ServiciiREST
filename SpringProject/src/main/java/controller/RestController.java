package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;
/**
 * Created by admarcu on 11/17/2016.
 */

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/users")
public class RestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<User> getAllUsersAsJson() {
        return userService.getAllUsers();
    }

/*    @RequestMapping(value = "/list2")
    @ResponseBody
    public String listUsers2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userService.getAllUsers());
    }*/


    @RequestMapping(value = "/id/{id}")
    @ResponseBody
    public User findUserById(@PathVariable int id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUserById(@PathVariable int id) {

        userService.removeUser(id);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

}
