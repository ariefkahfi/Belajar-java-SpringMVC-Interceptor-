package com.arief.ws.services.personwebservicedao;

import com.arief.ws.domain.Person;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class PersonWebServiceDAOImpl implements PersonWebServiceDAO {

    private  Logger logger = Logger.getLogger(this.getClass().getName());

    private static final String BASE_URL_API = "http://localhost/android-ok1/";




    public void save(Person p) throws Exception{

        OkHttpClient client =new OkHttpClient();

        FormBody form = new FormBody.Builder()
                .add("nama",p.getNama())
                .add("alamat",p.getAlamat())
                .build();

        Request req = new Request.Builder()
                .url(BASE_URL_API+"insert.php")
                .post(form)
                .build();

        try {
            Response response = client.newCall(req).execute();

            logger.info(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Person getOne(int id) {
        Person p = null;

        OkHttpClient client = new OkHttpClient();

        HttpUrl http = new HttpUrl.Builder()
                .scheme("http")
                .host("localhost")
                .addPathSegments("/android-ok1/select_one_person.php")
                .addQueryParameter("id",String.valueOf(id))
                .build();

        Request req = new Request.Builder()
                .url(http)
                .get()
                .build();


        String json = "";

        try {
            Response response = client.newCall(req).execute();
            json = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }


        JsonElement element = new JsonParser().parse(json);

        JsonArray arr = element.getAsJsonObject().get("hasil").getAsJsonArray();


        for(JsonElement el : arr){



            int idPerson = el.getAsJsonObject().get("id").getAsInt();
            String nama=  el.getAsJsonObject().get("nama").getAsString();
            String alamat = el.getAsJsonObject().get("alamat").getAsString();


            p = new Person(idPerson,nama,alamat);
            //System.out.println(new Person(idPerson,nama,alamat).toString());

        }

        return p;
    }

    public List<Person> getAll() throws Exception{
        OkHttpClient client =new OkHttpClient();


        List<Person> data = new ArrayList<Person>();


        String json = "";

        Request req = new Request.Builder()
                .url(BASE_URL_API+"select.php")
                .get()
                .build();

        try {
            Response response = client.newCall(req).execute();
            json = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonParser parser = new JsonParser();

        JsonElement element  = parser.parse(json);


        JsonArray array = element.getAsJsonArray();

        for(JsonElement el : array){
           int id = el.getAsJsonObject().get("id").getAsInt();
           String nama = el.getAsJsonObject().get("nama").getAsString();
           String alamat = el.getAsJsonObject().get("alamat").getAsString();


            data.add(new Person(id,nama,alamat));


            logger.info("person : " + new Person(id,nama,alamat).toString());

        }


        return data;
    }
}
