package ru.sbrf.javaschool.animal;

import ru.sbrf.javaschool.annotation.NotOne;

public interface Animal {

    String makeNoize();

    @NotOne
    void move(Integer count);

}
