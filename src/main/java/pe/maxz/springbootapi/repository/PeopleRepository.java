package pe.maxz.springbootapi.repository;


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
    public People getById(int id){
        //return new People(1, "Luck", "182");
        People result =null;
        OkHttpClient client = new OkHttpClient().newBuilder()
        .build();
      Request request = new Request.Builder()
        .url("https://swapi.dev/api/people/"+id+"/")
        .method("GET",null)
        .build();
        try {
            Response response = client.newCall(request).execute();
            String stringResponse = response.body().string();
            if (response.isSuccessful()){
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
                result = objectMapper.readValue(stringResponse, new TypeReference<People>(){});
                result.setId(id);             
    
            }else{
                result=null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result=null;
        }
        return result;
    }
}
