package com.bridgelabz.ExerciseProblems;

import java.util.ArrayList;

public class SuppressWarningsAnnotation {
    public static void main(String[] args) {

        @SuppressWarnings("unsed")
        SuppressWarningsAnnotation obj = new SuppressWarningsAnnotation();

        @SuppressWarnings("unchecked")
        ArrayList list = new ArrayList();
        list.add("hello");
        list.add(12);
    }
}
