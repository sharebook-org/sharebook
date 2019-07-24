package org.sharebook.utils;

import org.junit.Test;
import org.sharebook.model.User;
import org.sharebook.repository.impl.UserRepositoryImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserTest {
    @Test
    public void findAllUsers(){
        UserRepositoryImpl userRepository=new UserRepositoryImpl();
        List<User> users = userRepository.findAll(1, 2);
        System.out.println(users);
    }

    @Test
    public void getUsersCount(){
        UserRepositoryImpl userRepository=new UserRepositoryImpl();
        System.out.println(userRepository.getUsersCount());
    }

    @Test
    public void getBirthday() throws ParseException {
        String d="0121";
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(d.substring(0,2));
        stringBuffer.append("-");
        stringBuffer.append(d.substring(2,4));
        String s=stringBuffer.toString();
        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd");
        Date birthday = sdf.parse(s);
        System.out.println(birthday);
    }
}
