package com.bridgelabz.ExerciseProblems;

class LegacyAPI{

    @Deprecated
    void oldFeature(){
        System.out.println("This is an old feature");
    }

    void newFeature(){
        System.out.println("This is the new feature");
    }
}

public class DeprecatedAnnotation {
    public static void main(String[] args) {
        LegacyAPI obj = new LegacyAPI();
        obj.newFeature();
        obj.oldFeature();
    }
}
