package com.zeng.web;

import com.zeng.entity.UserEntity;
import com.zeng.param.UserParam;
import com.zeng.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;
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

    @RequestMapping("/add")
    public String add(@Valid UserParam userParam, BindingResult result, ModelMap model) {
        UserEntity user=new UserEntity();
        user.setUserName(userParam.getUserName());
        user.setPassword(userParam.getPassword());
        user.setEmail(userParam.getEmail());
        user.setAge(userParam.getAge());
        user.setRegTime(new Date());
        user.setUserType("user");
        userRepository.save(user);
        return "redirect:/list";
    }

}
