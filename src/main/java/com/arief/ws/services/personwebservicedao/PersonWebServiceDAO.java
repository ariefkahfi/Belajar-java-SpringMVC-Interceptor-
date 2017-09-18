package com.arief.ws.services.personwebservicedao;

import com.arief.ws.domain.Person;
import java.util.List;

public interface PersonWebServiceDAO {

    void save(Person p) throws Exception;
    Person getOne(int id);
    List<Person> getAll() throws Exception;

}
