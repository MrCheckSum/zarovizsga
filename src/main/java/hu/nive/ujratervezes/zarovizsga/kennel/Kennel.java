package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dogList = new ArrayList<>();

    public void addDog(Dog dog) {
        dogList.add(dog);
    }

    public List<Dog> getDogs() {
        return new ArrayList<>(dogList);
    }


    public Dog findByName(String name) {
        for (Dog dog : dogList) {
            if (dog.getName().contains(name)) {
                return dog;
            }
        }
        throw new IllegalArgumentException("No dog in the list!");
    }


    public void playWith(String name, int hour) {
        for (Dog dog : dogList) {
            if (dog.getName().contains(name)) {
                dog.play(hour);
            }
        }
    }


    public List<String> getHappyDogNames(int minHappiness) {
        List<String> happyDogs = new ArrayList<>();
        for (Dog dog : dogList) {
            if (dog.getHappiness() > minHappiness) {
                happyDogs.add(dog.getName());
            }
        }
        return happyDogs;
    }

    public void feedAll() {
        for (Dog dog : dogList) {
            dog.feed();
        }
    }
}

