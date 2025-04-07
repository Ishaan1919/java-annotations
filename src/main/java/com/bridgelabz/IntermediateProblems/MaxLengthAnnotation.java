package com.bridgelabz.IntermediateProblems;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength{
    int value() default 10;
}

class Username{
    @MaxLength
    private String username;

    public Username(String name) throws IllegalAccessException {

        Class obj = Username.class;
        Field[] field = obj.getDeclaredFields();

        for(Field i:field){
            if(i.isAnnotationPresent(MaxLength.class)){
                MaxLength max = i.getAnnotation(MaxLength.class);
                int val = max.value();
                int len = name.length();

                if(val>=len){
                    i.setAccessible(true);
                    i.set(this,name);
                }
                else{
                    throw new IllegalArgumentException("Username is too large");
                }
            }
        }
    }

    public String getUsername(){
        return this.username;
    }
}

public class MaxLengthAnnotation {
    public static void main(String[] args) {
        try{
            Username name = new Username("Ishaan");
            System.out.println(name.getUsername());
        } catch (IllegalArgumentException  | IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
