package com.github.cukedoctor.example;

import java.io.Serializable;

public class Belly implements Serializable {
    private static final long serialVersionUID = -1182468379585134676L;
    
    private int cukes;
    
    public int getCukes() {
        return cukes;
    }
    
    public boolean isHungry() {
        return cukes <= 0;
    }
    
    public void setCukes(int cukes) {
        this.cukes = cukes;
    }
}
