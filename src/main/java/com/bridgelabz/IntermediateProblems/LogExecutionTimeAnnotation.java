package com.bridgelabz.IntermediateProblems;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime{

}

public class LogExecutionTimeAnnotation {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        LogExecutionTimeAnnotation log = new LogExecutionTimeAnnotation();
        Class obj = LogExecutionTimeAnnotation.class;
        Method[] methods = obj.getDeclaredMethods();

        for(Method i:methods){
            if(i.isAnnotationPresent(LogExecutionTime.class)){
                long start = System.nanoTime();
                i.invoke(log,2,4);
                long end = System.nanoTime();
                System.out.println(", Time taken: " + (end-start));
            }
        }
    }

    @LogExecutionTime
    public void add(int a, int b){
        System.out.print("Add: " + (a+b));
    }

    @LogExecutionTime
    public void subtract(int a, int b){
        System.out.print("Subtract: " + (a-b));
    }

    @LogExecutionTime
    public void multiply(int a, int b){
        System.out.print("Multiply: " + (a*b));
    }
}
