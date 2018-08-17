package com.example.springboot2;

import com.example.springboot2.model.User;
import com.example.springboot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    @ResponseBody
    public User index(HttpServletRequest request){



       /* user.setId(null);
        user.setAge(2);
        user.setName("a");
        user.setAddress(null);
        user.setNiceName(null);
        List<User> users = userService.queryUsersWithCondi(user);
        System.out.println(users.toString());*/

       /* User user =new User();
        user.setId(1);
        user.setAge(22);
        user.setAddress("北京");
        user.setNiceName("a小明的爸爸是大明");
        user.setName("北京");

        int update = userService.update(user);
        System.out.println("update:"+update);
        user.setId(17);
        int delete = userService.delete(user);
        System.out.println("delete:"+user.getId());*/

//        User user = userService.queryUserById(1);

//        Map<String, Object> map = userService.selectOne(new HashMap<>());
       /* List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("小明");
        user1.setAge(12);
        User user2 = new User();
        user2.setName("小华");
        user2.setAge(13);

        users.add(user1);
        users.add(user2);*/

        User user1 = new User();
        user1.setId(18);
        User user2 = new User();
        user2.setId(19);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        int i = userService.deleteAll(users);
        System.out.println(i);
        return user1;
    }

}
