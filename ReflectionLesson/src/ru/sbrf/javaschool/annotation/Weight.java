package ru.sbrf.javaschool.annotation;

import java.lang.annotation.*;

/**
 * Собственная реализация аннотации, для определения максиимального и среднего веса для класса
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Weight {

    long max();

    long avg();

}
