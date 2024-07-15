package com.delerycarmate;

import com.delerycarmate.model.User;
import com.delerycarmate.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.awt.AppContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppContext.class);

        UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setUsername("John Doe");
        user.setEmail("john.doe@example.com");

        userService.saveUser(user);

        context.close();
    }
}

