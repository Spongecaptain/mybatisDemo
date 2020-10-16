package cool.spongecaptain.springboot_mybatis.controller;

import cool.spongecaptain.springboot_mybatis.mapper.UserMapper;
import cool.spongecaptain.springboot_mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    //访问 jsp 以及 all 页面来测试 jsp 是否正常运行
    @RequestMapping({"jsp","all"})
    public ModelAndView all() throws Exception {

        List<User> list = userMapper.getAllUser();

        ModelAndView map = new ModelAndView("/all");

        map.addObject("list",list);

        list.forEach(System.out::println);
        return map;
    }

}
