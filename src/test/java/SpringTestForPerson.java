import com.arief.ws.domain.Person;
import com.arief.ws.services.personwebservicedao.PersonWebServiceDAO;
import com.arief.ws.services.personwebservicedao.PersonWebServiceDAOImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;

import java.io.IOException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersonWebServiceDAOImpl.class})
public class SpringTestForPerson {


    @Autowired
    private PersonWebServiceDAO dao;


    @Test
    public void testSave() throws Exception{
    }


    public void selectOnePersonDAO(int id){


    }



    @Test
    public void testSelectOne()throws Exception{
        selectOnePersonDAO(2);
    }

    @Test
    public void testSelectAll() throws Exception{
        dao.getAll().forEach(c->{
            System.out.println(c.toString());
        });
    }


}
