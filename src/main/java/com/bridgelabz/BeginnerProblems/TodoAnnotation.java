package com.bridgelabz.BeginnerProblems;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class TodoList{

    @Todo(task = "Go GYM", assignedTo = "me", priority = "HIGH")
    public void addTask(){

    }

    @Todo(task = "Go to training", assignedTo = "friend", priority = "HIGH")
    public void removeTask(){

    }

    public void doTask(){

    }

}

public class TodoAnnotation {
    public static void main(String[] args) {
        Class obj = TodoList.class;
        Method[] methods = obj.getDeclaredMethods();

        ArrayList<Method> pending = new ArrayList<>();
        for(Method i:methods){
            if(i.isAnnotationPresent(Todo.class)){
                Todo todo = i.getAnnotation(Todo.class);
                System.out.println("Pending task: " + todo.task());
                System.out.println("Task assigned to: " + todo.assignedTo());
                System.out.println("Priority of task: " + todo.priority());
                pending.add(i);
            }
        }
    }
}
