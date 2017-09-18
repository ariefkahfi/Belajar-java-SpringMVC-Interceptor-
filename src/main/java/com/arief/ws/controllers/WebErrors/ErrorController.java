package com.arief.ws.controllers.WebErrors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {


    @RequestMapping(value = "errors",method = RequestMethod.GET)
    public ModelAndView codeError(HttpServletRequest servletRequest){
        ModelAndView view = new ModelAndView("errors/ErrorPage");


        int errorCode = getErrorCode(servletRequest);

        String pesan = "";

        switch (errorCode){
            case 403 :
                pesan = "You Are not Allowed to access this page";
                break;
            case 404 :
                pesan = "Data Not Found";
                break;
        }

        view.addObject("pesan",pesan);
        return view;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }
}
