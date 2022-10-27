package pe.maxz.springbootapi.repository;

import java.io.IOException;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pe.maxz.springbootapi.entity.Starship;
@Repository
public class StarshipRepositoryHttp implements StarshipRepository{

    @Override
    public Starship get(int id) throws Exception  {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
            .url("https://swapi.dev/api/starships/"+ id)
            .method("GET", null)
            .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.code()==200){
                String strResponse= response.body().string();
                System.out.println(strResponse);
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return objectMapper.readValue(strResponse,new TypeReference<Starship>() {});
            }else if (response.code()==404)return null;
            else throw new Exception(response.message());
        } catch (IOException e) {
            return null;
        }
    }
    
}
