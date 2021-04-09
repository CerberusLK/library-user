package lk.cerberus.libraryuser.controller;

import lk.cerberus.libraryuser.entity.User;
import lk.cerberus.libraryuser.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class User_Controller {

    @Autowired
    private User_Service userService;

    @GetMapping
    public String test(){
        return "Online";
    }

    @RequestMapping(path = "/debug", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public boolean userLogin(@RequestBody User user){
        return userService.userLogin(user);
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public int userSignUp(@RequestBody User user){
        return userService.userSignUp(user);
    }
}
