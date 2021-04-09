package lk.cerberus.libraryuser.service;

import lk.cerberus.libraryuser.entity.User;
import lk.cerberus.libraryuser.repository.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class User_Service {

    boolean valid;

    @Autowired
    private User_Repository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public boolean confirmUserName(String userName) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                valid = false;
            }
            else{
                valid=true;
            }
        }
        return valid;
    }

    public int userSignUp(User user){
        if (confirmUserName(user.getUserName())){
            userRepository.save(user);
            return 1;
        }
        else{
            return 0;
        }
    }

    public boolean userLogin(User user){
        List<User> users = getAllUsers();
        for (User _user:users) {
            if(_user.getUserName().equals(user.getUserName()) && _user.getPassword().equals(user.getPassword())){
                valid = true;
            }
            else {
                valid=false;
            }
        }
        return valid;
    }
}
