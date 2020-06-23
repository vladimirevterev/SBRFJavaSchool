package ru.sbrf.javaschool.animal;

import ru.sbrf.javaschool.annotation.Weight;

@Weight(max = 10, avg = 5)
public class Cat extends AnimalAbstract {

    @Override
    public String makeNoize() {
        return "meows";
    }

    @Override
    public void move(Integer count) {
        for (int i = 0; i < count; ++i) {
            System.out.println("cat step");
        }
    }
}
