package ru.sbrf.javaschool.animal;

import ru.sbrf.javaschool.annotation.Weight;

@Weight(max = 70, avg = 20)
public class Dog extends AnimalAbstract {

    @Override
    public String makeNoize() {
        return "gav";
    }

    @Override
    public void move(Integer count) {
        for (int i = 0; i < count; ++i) {
            System.out.println("dog step");
        }
    }

}
