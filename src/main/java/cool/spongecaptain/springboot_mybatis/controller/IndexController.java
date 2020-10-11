package cool.spongecaptain.springboot_mybatis.controller;

import cool.spongecaptain.springboot_mybatis.mapper.UserMapper;
import cool.spongecaptain.springboot_mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    UserMapper userMapper;//这里会飘红，正常情况

    @RequestMapping({"/","index"})
    public String handleRequest(Model model) throws Exception {

        User user = userMapper.getOne(1);

        model.addAttribute("name",user.getName());
        model.addAttribute("age",user.getAge());
        model.addAttribute("id",user.getId());

        return "index";
    }

}
