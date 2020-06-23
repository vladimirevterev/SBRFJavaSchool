package ru.sbrf.javaschool.animal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AnimalAbstract implements Animal, Serializable {

    public List<Long> colors = new ArrayList<>();

    @Override
    public abstract String makeNoize();

    @Override
    public void move(Integer count) {
        for (int i = 0; i < count; ++i) {
            System.out.println("step");
        }
    }
}
