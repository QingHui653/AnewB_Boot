package com.newb.starter_log;

/**
 * @Auther:woshizbh
 * @Date: 2018/12/12
 * @Deseription
 */
public class ExampleService {

    private String prefix;
    private String suffix;

    public ExampleService(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }
    public String wrap(String word) {
        return prefix + word + suffix;
    }
}
