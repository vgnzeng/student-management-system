package com.zeng.web;

import com.zeng.entity.UserEntity;
import com.zeng.param.UserParam;
import com.zeng.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
    public String add(@Valid UserParam userParam,BindingResult result, ModelMap model) {
        String errorMsg="";
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg=errorMsg + error.getCode() + "-" + error.getDefaultMessage() +";";
            }
            model.addAttribute("errorMsg",errorMsg);
            return "user/userAdd";
        }
        UserEntity u= userRepository.findByUserNameOrEmail(userParam.getUserName(),userParam.getEmail());
        if(u!=null){
            model.addAttribute("errorMsg","用户已存在!");
            return "user/userAdd";
        }
        UserEntity user=new UserEntity();
        BeanUtils.copyProperties(userParam,user);
        user.setRegTime(new Date());
        user.setUserType("user");
        userRepository.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }



}
