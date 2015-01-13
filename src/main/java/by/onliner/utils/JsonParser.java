package by.onliner.utils;

import by.onliner.model.SearchModel;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParser {
    public static SearchModel deserializeJson(File inFile){
        ObjectMapper objectMapper = new ObjectMapper();
        SearchModel searchModel = null;
        try {
            searchModel = objectMapper.readValue(inFile, SearchModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchModel;
    }
}
