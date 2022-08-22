package bg.softuni.state.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {


    @RequestMapping(value = "/cookie", method = RequestMethod.GET)
    public String sendCookie(HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("cookie","12345");
        cookie.setPath("/");
        cookie.setDomain("localhost");
        cookie.setMaxAge(10*60*60);
        httpServletResponse.addCookie(cookie);
        return "cookie_page";
    }



    @RequestMapping(value = "/cookie/value", method = RequestMethod.GET)
    public String getCookieValue(@CookieValue( name = "cookie",defaultValue = "none") String cookieValue, Model model){
        model.addAttribute("cookieValue",cookieValue);
        return "cookie_value_page";
    }




}
