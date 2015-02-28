package sparkapp;

import spark.ResponseTransformer;
import com.google.gson.Gson;

public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }
    
    public <T>T parse(String json, Class<T> classe) {
    	return gson.fromJson(json, classe);
    }

}