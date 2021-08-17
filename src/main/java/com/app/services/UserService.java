package com.app.services;

import com.app.dao.UserDao;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public String validateUser(User user) {
        String answer = "";
        if (user.getFirstName().isEmpty()) {
            answer += "First Name is empty; ";
        }
        if (user.getLastName().isEmpty()) {
            answer += "Last Name is empty; ";
        }
        if (user.getEmail().isEmpty()) {
            answer += "Email is empty; ";
        }
        if(user.getPassword().equals(user.getPasswordCheck())) {
        } else {
            answer += "Passwords are not the same!";
        }
        if(answer.isEmpty()==true)
        {

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPassword());//Захешировали пароль
            user.setPassword(encodedPassword);//Сохраняем этот пароль для пользователя который идет в базу данных

            userDao.storeUser(user);
        }
        return answer;
    }
}
