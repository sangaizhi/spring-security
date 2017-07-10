package org.sangaizhi.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sangaizhi
 * @date 2017/7/6
 */
@Controller
public class LoginController {


    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }



    @RequestMapping(value = { "/", "/welcome**" })
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.addObject("user", getPrincipal());
        model.setViewName("index");
        return model;

    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelAndView model) {
        model.addObject("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(ModelAndView model) {
        model.addObject("user", getPrincipal());
        return "dba";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelAndView model) {
        model.addObject("user", getPrincipal());
        return "accessDenied";
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

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
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
