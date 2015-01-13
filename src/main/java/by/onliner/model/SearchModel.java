package by.onliner.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("callModel")
public class SearchModel{

    @JsonProperty("manufacturers")
    private String manufacturers;

    @JsonProperty("price")
    private String price;

    @JsonProperty("display")
    private String display;

    public List<String> getManufacturers(){
        List<String> manufacturersList = Arrays.asList(manufacturers.split("\\s+"));
        return manufacturersList;
    }

    public String getMinPrice(){
        return price.split("-")[0];
    }

    public String getMaxPrice(){
        return price.split("-")[1];
    }

    public String getMinScreen(){
        String minScreen = display.split("-")[0];
        minScreen = normalizeScreen(minScreen);
        return minScreen;
    }

    public String getMaxScreen(){
        String maxScreen =  display.split("-")[1];
        maxScreen = normalizeScreen(maxScreen);
        return maxScreen;
    }

    private String normalizeScreen(String size){
        if(size.contains(".")){
            size = size.replaceAll("[.]","");
        } else{
            size = size + "0";
        }
        return size;
    }
}
