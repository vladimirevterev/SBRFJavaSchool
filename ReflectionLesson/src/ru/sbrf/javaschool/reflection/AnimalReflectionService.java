package ru.sbrf.javaschool.reflection;

import ru.sbrf.javaschool.animal.Animal;
import ru.sbrf.javaschool.annotation.Weight;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Сервис получения метаинформации о классах, реализующих Animal
 */
public class AnimalReflectionService {

    public AnimalReflectionService() {
    }

    /**
     * Получение списка наименований методов класса
     *
     * @param aClass {@link Class} тип класса
     * @return {@link List} список наименований методов
     */
    public List<String> getClassMethods(Class<? extends Animal> aClass) {
        List<String> result = new ArrayList<>();
        List<Method> methods = Arrays.asList(aClass.getDeclaredMethods());
        for(Method method : methods) {
            result.add(method.getName());
        }
        return result;
    }

    /**
     * Получение атрибута max аннотации Weight, которой помечен класс
     *
     * @param aClass {@link Class} тип класса
     * @return {@link Long} значение атрибута max
     */
    public long getMaxWeight(Class<? extends Animal> aClass) {
        if (aClass.isAnnotationPresent(Weight.class)) {
            Weight weight = aClass.getAnnotation(Weight.class);
            return weight.max();
        }
        throw new IllegalArgumentException("Максимальный вес не определен");
    }

    /**
     * Получение типа класса, которым параметризовано generic-поле класса
     *
     * @param aClass aClass {@link Class} тип класса
     * @param fieldName наименование поля класса
     * @return {@link Class} тип класса, которым параметризован generic поле
     * @throws NoSuchFieldException
     */
    public Class<?> getGenericFieldType(Class<?> aClass, String fieldName) throws NoSuchFieldException {
        Field field = aClass.getDeclaredField(fieldName);
        ParameterizedType colorsGenericType = (ParameterizedType) field.getGenericType();
        return  (Class<?>) colorsGenericType.getActualTypeArguments()[0];
    }

}
