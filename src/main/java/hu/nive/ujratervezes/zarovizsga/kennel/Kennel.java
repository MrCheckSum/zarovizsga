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


    public void findByName(String name) {

    }


    public void playWith(String bigli, int i) {
    }


    public <E> List<E> getHappyDogNames(int i) {
    }
}

