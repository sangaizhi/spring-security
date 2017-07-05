package org.sangaizhi.security.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sangaizhi
 * @date 2017/7/5
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/loginPage")
    public ModelAndView loginPage( String logout){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("logout", logout);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/loginSuccess")
    public String loginSuccess(){
        return "loginSuccess";
    }

    @RequestMapping("/loginFailure")
    public String loginFailure(){
        return "loginFailure";
    }

    @RequestMapping(value = "/myLogout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(null != authentication){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/loginPage?logout=\"you have logged out \"";
    }
}
