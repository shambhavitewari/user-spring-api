package com.user.spring.api.userspringapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserRepo repo;

    @RequestMapping("/")
    public String home()
    {
        return "home.jsp";
    }

    @RequestMapping("/addUser")
    public String addUser(User user)
    {

        User u1 = repo.findById(user.getUserid()).orElse(new User());
    {
            if (user.getUserid()==u1.getUserid())
            {
                return "showUserError.jsp";
            }
    }
        repo.save(user);
        return "home.jsp";


    }

    @RequestMapping("/getUser")
    public ModelAndView getUser(@RequestParam int userid)
    {
        ModelAndView mv = new ModelAndView("showUser.jsp");
        User user = repo.findById(userid).orElse(new User());
        mv.addObject(user);
        return mv;
    }
}
