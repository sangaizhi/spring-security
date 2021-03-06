package org.sangaizhi.security.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sangaizhi
 * @date 2017/7/6
 */
@Controller
public class LoginController {


    private String getPrincipal(){
        String userName = null;
        Object proincipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(proincipal instanceof UserDetails){
            userName = ((UserDetails)proincipal).getUsername();
        }else userName = proincipal.toString();
        return userName;
    }


    @RequestMapping(value = { "/", "/welcome**" })
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.addObject("user", getPrincipal());
        model.setViewName("index");
        return model;

    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout",required = false) String logout ){
        ModelAndView model = new ModelAndView();
        if(null != error){
            model.addObject("error", "Invalid username and password");
        }
        if(null != logout){
            model.addObject("msg", "You have been logger out successfully");
        }
        model.setViewName("login");
        return model;
    }

    @RequestMapping("/loginSuccess")
    public String loginSuccess(){
        return "loginSuccess";
    }

    @RequestMapping("/loginFailure")
    public String loginFailure(){
        return "loginFailure";
    }

}
