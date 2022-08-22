package bg.softuni.state.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    @RequestMapping(value = "/session",method = RequestMethod.GET)
    public String createSession(HttpSession session){
        session.setAttribute("mainSession","connected");
        return "session_page";
    }

    @RequestMapping(value = "/session/value",method = RequestMethod.GET)
    public String getSessionValue(Model model, HttpSession httpSession){

        Object sessionValue = httpSession.getAttribute("mainSession");

        if(sessionValue == null){
            sessionValue = "not connected";
        }
        model.addAttribute("sessionValue",sessionValue);

        return "session_value_page";
    }

}
