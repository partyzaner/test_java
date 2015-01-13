package by.onliner.model;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notebook {

    private String name;

    private int minPrice = 0;

    private int maxPrice = 0;

    private static final Pattern PRICE_PATTERN = Pattern.compile("(\\d+)");


    public Notebook(String name, String prices){
        this.name = name;
        initializePrices(prices);
    }

    private void initializePrices(String prices){

        Set<Integer> parsedPrices = new HashSet<Integer>();

        Matcher matcher = PRICE_PATTERN.matcher(prices);
        while (matcher.find()){
            parsedPrices.add(Integer.parseInt(matcher.group(0)));
        }

        for (int price: parsedPrices){
            if (minPrice > price || minPrice == 0){
                minPrice = price;
            }
            if (maxPrice < price){
                maxPrice = price;
            }
        }
    }

    public String getName(){
        return name;
    }

    public int getMinPrice(){
        return minPrice;
    }

    public int getMaxPrice(){
        return maxPrice;
    }

    @Override
    public String toString() {
        return "NotebookItem{" +
                "name='" + name + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notebook notebook = (Notebook) o;

        if (maxPrice != notebook.maxPrice) return false;
        if (minPrice != notebook.minPrice) return false;
        if (name != null ? !name.equals(notebook.name) : notebook.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + minPrice;
        result = 31 * result + maxPrice;
        return result;
    }
}
