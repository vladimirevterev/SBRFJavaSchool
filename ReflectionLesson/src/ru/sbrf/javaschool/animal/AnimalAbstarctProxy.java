package ru.sbrf.javaschool.animal;

public class AnimalAbstarctProxy implements Animal {

    private Animal animal;

    public AnimalAbstarctProxy(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String makeNoize() {
        System.out.println("start makeNoize");
        String result = animal.makeNoize();
        System.out.println("stop makeNoize");
        return result;
    }

    @Override
    public void move(Integer count) {
        System.out.println("start move");
        animal.move(count);
    }
}
