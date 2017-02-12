package ru.skrser.ctci3dot7;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Animal shelter
 */
public class Solution {

    private Deque<Animal> animals = new LinkedList<Animal>();
    private Deque<Cat> cats = new LinkedList<Cat>();
    private Deque<Dog> dogs = new LinkedList<Dog>();

    public void enqueue(Animal animal) {
        animals.add(animal);
        if (animal instanceof Cat)
            cats.add((Cat) animal);
        if (animal instanceof Dog)
            dogs.add((Dog) animal);
    }

    public Animal dequeAny() {
        Animal animal = animals.poll();
        if (animal instanceof Cat)
            cats.poll();
        if (animal instanceof Dog)
            dogs.poll();
        return animal;
    }

    public Cat dequeCat() {
        Cat cat = cats.poll();
        animals.removeLastOccurrence(cat);
        return cat;
    }

    public Dog dequeDog() {
        Dog dog = dogs.poll();
        animals.removeLastOccurrence(dog);
        return dog;
    }

    public static abstract class Animal {
        private String nickname;

        protected Animal(String nickname) {
            this.nickname = nickname;
        }

        public String getNickname() {
            return nickname;
        }
    }

    public static class Cat extends Animal {
        public Cat(String nickname) {
            super(nickname);
        }
    }

    public static class Dog extends Animal {
        public Dog(String nickname) {
            super(nickname);
        }
    }

}
