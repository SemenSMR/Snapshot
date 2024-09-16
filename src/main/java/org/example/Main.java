package org.example;

public class Main {
    public static void main(String[] args) {
        CustomBuilder customBuilder = new CustomBuilder();

        customBuilder.append("Hello, ");
        customBuilder.append("world! ");

        customBuilder.delete(5,7);
        customBuilder.undo();
        customBuilder.undo();
        System.out.println(customBuilder);
    }
}