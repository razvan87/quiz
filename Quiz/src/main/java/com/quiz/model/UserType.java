package com.quiz.model;

public enum UserType {

	 USER(0), ADMIN(1);

    private final int value;

    UserType(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
