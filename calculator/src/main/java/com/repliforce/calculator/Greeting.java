package com.repliforce.calculator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content){
        super();
        this.id = id;
        this.content = content;
    }

}
