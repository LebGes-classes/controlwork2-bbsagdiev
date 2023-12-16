package itproger;

import java.util.Random;

abstract class Pet {
    int satiety;

    Pet() {
        // Инициализация сытости случайным числом от 1 до 100
        Random random = new Random();
        satiety = random.nextInt(100) + 1;
    }

    abstract void eat();
}

class Dog extends Pet {
    @Override
    void eat() {
        System.out.println("Гав");
        satiety = Math.min(100, satiety + 75);
    }
}

class Cat extends Pet {
    @Override
    void eat() {
        System.out.println("Мяу");
        satiety = Math.min(100, satiety + 75);
    }
}

public class Main {
    public static void main(String[] args) {
        Pet[] pets = new Pet[5]; // Создаем массив из 5 питомцев

        // Заполняем массив случайным образом собаками и кошками
        Random random = new Random();
        for (int i = 0; i < pets.length; i++) {
            if (random.nextBoolean()) {
                pets[i] = new Dog();
            } else {
                pets[i] = new Cat();
            }
        }

        // Печатаем состояние до кормления
        System.out.println("Состояние до кормления:");
        for (Pet pet : pets) {
            System.out.println("Сытость: " + pet.satiety);
        }

        // Кормим всех питомцев
        for (Pet pet : pets) {
            pet.eat();
        }

        // Печатаем состояние после кормления
        System.out.println("\nСостояние после кормления:");
        for (Pet pet : pets) {
            System.out.println("Сытость: " + pet.satiety);
        }
    }
}