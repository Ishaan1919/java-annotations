package com.bridgelabz.BeginnerProblems;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod{
    String level() default "High";
}

class Sports{

    @ImportantMethod()
    public void football(){
        System.out.println("Play football now");
    }

    @ImportantMethod(level = "low")
    public void cricket(){
        System.out.println("Play cricket now");
    }
    public void chess(){
        System.out.println("Play chess now");
    }
}

public class ImportantMethodsAnnotation {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Sports sports = new Sports();
        Class obj = Sports.class;

        Method[] methods = obj.getMethods();
        for(Method i:methods){
            if(i.isAnnotationPresent(ImportantMethod.class)){
                ImportantMethod im = i.getAnnotation(ImportantMethod.class);
                System.out.println("Method name: " + i.getName() + ", Level: " + im.level());
                i.invoke(sports);
            }
        }
    }
}
