package com.bridgelabz.ExerciseProblems;

class Animal{
    void makeSound(){
        System.out.println("Voice of Animal");
    }
}

class Dog extends Animal{

    @Override
    void makeSound(){
        System.out.println("Voice of Dog");
    }
}

public class OverrideAnnotation {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();
    }
}
