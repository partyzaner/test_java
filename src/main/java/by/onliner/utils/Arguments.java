package by.onliner.utils;

import org.kohsuke.args4j.Option;

public class Arguments {
    @Option(name = "-browser", required = false)
    private String browser;

    public String getBrowser(){
        return browser;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        return builder.append("Browser = ").append(browser).toString();
    }
}
