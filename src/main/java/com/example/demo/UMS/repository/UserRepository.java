package com.example.demo.UMS.repository;

import com.example.demo.UMS.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRepository {

    private static List<User> userList;
    private static int id = 0;

    public UserRepository() {
        if (userList == null) {
            userList = new ArrayList<>();
            userList.add(new User(++id, "Artem", "Kravt", "qwe@mail.ru"));
            userList.add(new User(++id, "Tanya", "Degt", "sss@mail.ru"));
            userList.add(new User(++id, "Vann", "Damm", "ddd@mail.ru"));
        }
    }


    public List<User> findAll() {
        return userList;
    }

    public User findById(int id) {
        return userList.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    public boolean deleteById(int id) {
        return userList.remove(findById(id));
    }

    public void save(User user) {
        user.setId(++id);
        userList.add(user);
    }

}
