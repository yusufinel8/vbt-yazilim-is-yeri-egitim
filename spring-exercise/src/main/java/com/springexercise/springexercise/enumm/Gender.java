package com.springexercise.springexercise.enumm;

import lombok.Getter;

@Getter
public enum Gender {
    Male("Erkek",1),
    Female("Kadın",0);

    private String name;
    private int code;

    Gender(String name,int code) {
        this.name = name;
        this.code=code;
    }
}
