package com.ui.pojo;

import java.util.Map;

public class Config {
    private Map<String, Environment> environments;

    public Map<String, Environment> getEnvironments() {
        return environments;
    }

    public Config setEnvironments(Map<String, Environment> environments) {
        this.environments = environments;
        return this;
    }
}
