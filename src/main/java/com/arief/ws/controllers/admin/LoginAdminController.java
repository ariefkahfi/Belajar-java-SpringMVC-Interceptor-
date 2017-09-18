package com.arief.ws.controllers.admin;

import com.arief.ws.domain.Admin;
import com.arief.ws.services.adminDAO.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
@Scope("session")
public class LoginAdminController {


    @Autowired
    private AdminDAO dao;


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView formAdminView(@ModelAttribute("pesan")String pesan){
        return new ModelAndView("admin/Login","admin",new Admin());
    }




    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String submitLoginForAdmin(
            @Valid @ModelAttribute("admin")Admin a ,
                                      BindingResult bind ,
                                      Model m,
                                      HttpServletRequest servletRequest,
                                      HttpServletResponse response) throws IOException {
        if(bind.hasErrors()){
            return "admin/Login";
        }else{
            try{
                Admin findOne = dao.getOne(a.getKode());
                servletRequest.getSession().setAttribute("admin",findOne.getKode());
                return "redirect:/home";
            }catch (EmptyResultDataAccessException empty){
                m.addAttribute("pesan","Data Tidak Ada");
                return "redirect:/admin/login";
            }
        }
    }

}


