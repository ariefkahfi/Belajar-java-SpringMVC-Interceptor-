import com.arief.ws.domain.Admin;
import com.arief.ws.services.adminDAO.AdminDAO;
import com.arief.ws.services.adminDAO.AdminDAORepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class SpringTestForAdmin {



    @Autowired
    private JdbcTemplate jdbc;



    @Test
    public void testGetOne() throws Exception{
        String sql = "select * from admin where kode = ? ";

        Admin a = jdbc.queryForObject(sql,new BeanPropertyRowMapper<Admin>(Admin.class),"admin-01");

        Assert.assertNotNull(a);

    }

    @Test
    public void getOneByAllProperties() throws Exception{

        String sql = "select * from admin where kode = ? and password = ? ";

        Admin a = jdbc.queryForObject(sql,new BeanPropertyRowMapper<Admin>(Admin.class),"admin-01","arief");



        Assert.assertNotNull(a);

    }

}
