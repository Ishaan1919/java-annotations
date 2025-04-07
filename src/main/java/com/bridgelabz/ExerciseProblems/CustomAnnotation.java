package com.bridgelabz.ExerciseProblems;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo{
    int priority();
    String assignedTo();
}

class TaskManager{

    @TaskInfo(priority = 1, assignedTo = "Manager")
    void retrieveAnnotationDetails(){

    }
}

public class CustomAnnotation {
    public static void main(String[] args) {
        Class obj = TaskManager.class;
        Method[] method = obj.getDeclaredMethods();

        for(Method i : method){
            if(i.isAnnotationPresent(TaskInfo.class)){
                TaskInfo tk = i.getAnnotation(TaskInfo.class);
                System.out.println("Assigned to: " + tk.assignedTo());
                System.out.println("Priority to: " + tk.priority());
            }
        }
    }
}
