package pe.maxz.springbootapi.repository;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pe.maxz.springbootapi.entity.People;

@Repository
public class PeopleRepository {
    @Value("${api.starwar.url}")
    String urlBase;
    
    public People getById(int id) throws Exception{
        People result =null;
        OkHttpClient client = new OkHttpClient()
            .newBuilder()
            .build();
        Request request = new Request.Builder()
            .url(urlBase + "/people/"+id+"/")
            .method("GET",null)
            .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.code()==200){
                String stringResponse = response.body().string();
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
                result = objectMapper.readValue(stringResponse, new TypeReference<People>(){});
                result.setId(id);             
            }else if (response.code()==404){
                result=null;
            }
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
}
