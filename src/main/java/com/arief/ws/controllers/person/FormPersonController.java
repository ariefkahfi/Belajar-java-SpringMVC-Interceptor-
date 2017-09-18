package com.arief.ws.controllers.person;

import com.arief.ws.domain.Person;
import com.arief.ws.services.personwebservicedao.PersonWebServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@RequestMapping("/person")
public class FormPersonController {

    private Logger log = Logger.getLogger(this.getClass().getName());


    @Autowired
    private PersonWebServiceDAO dao;


    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public ModelAndView formViewForInsert(){
        return new ModelAndView("person/FormInsert","person",new Person());
    }


    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String formSubmitInsert(@ModelAttribute("person")Person p ,  Model m) throws Exception {
       dao.save(p);
       m.addAttribute("pesan","Data berhasil disimpan");
       return "home/HomePage";
    }

}
