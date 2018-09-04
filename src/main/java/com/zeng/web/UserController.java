package com.zeng.web;

import com.zeng.entity.UserEntity;
import com.zeng.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/list")
    public String list(Model model) {
        List<UserEntity> users=userRepository.findAll();
        model.addAttribute("users", users);
        logger.info("user list "+ users);
        return "user/list";
    }

}
