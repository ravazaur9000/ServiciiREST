package service;

import model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by admarcu on 11/15/2016.
 */
@Service
public class UserService {

    public static List<User> userList;


    static {
        userList = new ArrayList<User>();
        userList.add(new User(1, "User 1", 10));
        userList.add(new User(2, "User 2", 15));
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User saveUser(User user) {
        user.setId(user.getId()+1);
        this.userList.add(user);
        return user;
    }

    public User findById(int id) {
        for(User user : userList) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }


    public User updateUser(User user) {
        ListIterator<User> iterator = userList.listIterator();
        User usr;
        while(iterator.hasNext()) {
            usr = iterator.next();
            if(usr.getId() == user.getId()) {
                iterator.set(user);
                return user;
            }
        }
        return null;
    }

    public void removeUser(int id) {
        Iterator<User> iterator = userList.iterator();
        User usr;
        while(iterator.hasNext()) {
            usr = iterator.next();
            if(usr.getId() == id) {
                iterator.remove();
            }
        }
    }



}
