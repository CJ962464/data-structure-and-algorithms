package com.cj;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            ints.add(i);
        }

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(20, "John"));
        persons.add(new Person(20, "John"));
        persons.add(new Person(20, "John"));
        persons.add(new Person(20, "John"));

        System.out.println(persons);


    }
}
