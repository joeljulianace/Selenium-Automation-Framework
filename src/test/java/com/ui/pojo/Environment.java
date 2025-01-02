package com.ui.pojo;

public class Environment {
    private String url;
    private int MAX_NUMBER_OF_ATTEMPTS;

    public int getMAX_NUMBER_OF_ATTEMPTS() {
        return MAX_NUMBER_OF_ATTEMPTS;
    }

    public Environment setMAX_NUMBER_OF_ATTEMPTS(int MAX_NUMBER_OF_ATTEMPTS) {
        this.MAX_NUMBER_OF_ATTEMPTS = MAX_NUMBER_OF_ATTEMPTS;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Environment setUrl(String url) {
        this.url = url;
        return this;
    }
}
