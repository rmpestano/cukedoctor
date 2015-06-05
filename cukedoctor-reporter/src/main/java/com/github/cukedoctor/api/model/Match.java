package com.github.cukedoctor.api.model;

import java.util.List;

public class Match {

    private String location;

    private List<Argument> arguments;

    public List<Argument> getArguments() {
        return arguments;
    }

    public String getLocation() {
        return location;
    }

}
