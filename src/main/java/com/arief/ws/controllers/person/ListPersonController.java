package com.arief.ws.controllers.person;

import com.arief.ws.services.personwebservicedao.PersonWebServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class ListPersonController {

    @Autowired
    private PersonWebServiceDAO dao;




    @RequestMapping("/list")
    public String listPerson(Model m){
        try {
            m.addAttribute("data",dao.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "person/listPerson";
    }

}
