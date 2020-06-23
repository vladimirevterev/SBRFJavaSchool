package ru.sbrf.javaschool;

import ru.sbrf.javaschool.animal.Animal;
import ru.sbrf.javaschool.animal.AnimalAbstarctProxy;
import ru.sbrf.javaschool.animal.AnimalAbstract;
import ru.sbrf.javaschool.animal.Dog;
import ru.sbrf.javaschool.proxy.AnimalLogHandler;
import ru.sbrf.javaschool.reflection.AnimalReflectionService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class ReflectionMain {

    public static void main(String[] args)
            throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException,
            NoSuchFieldException
    {
        // Создание объекта типа Class<>
        Class<? extends Integer> intClass = Integer.class;
        Integer intObj = 1;
        intClass = intObj.getClass();
        intClass.getConstructor(int.class).newInstance(1);

        // Получение информации о суперклассе
        System.out.println(intClass.getSuperclass());
        System.out.println(Object.class.getSuperclass());

        Animal animal = new Dog();
        AnimalReflectionService animalReflectionService = new AnimalReflectionService();

        // Полчение списка имен методов
        List<String> animalMethodsNames = animalReflectionService.getClassMethods(animal.getClass());
        System.out.println(animalMethodsNames);

        // Выполнение метода makeNoize класса Dog
        Method makeNoizeMethod = Dog.class.getMethod("makeNoize");
        System.out.println(makeNoizeMethod.invoke(animal));

        // Получение списка реализуемых классом интерфейсов
        for (Class<?> clazz : AnimalAbstract.class.getInterfaces()) {
            System.out.println(clazz.getName());
        }

        // Получение типа, которым параметризовано generic-поле класса
        System.out.println(
                animalReflectionService.getGenericFieldType(
                        animal.getClass().getSuperclass(),
                        "colors"
                )
        );

        // Получение атрибута max аннотации Weight, которой помечен класс
        System.out.println(animalReflectionService.getMaxWeight(animal.getClass()));

        // Пример использования статического лог-прокси для объекта animal класса, реализующего Animal
        AnimalAbstarctProxy animalAbstarctProxy = new AnimalAbstarctProxy(animal);
        animalAbstarctProxy.makeNoize();

        // Пример использования динамического прокси для объекта animal класса, реализующего Animal
        Class<?> proxyClass = Proxy.getProxyClass(
                Animal.class.getClassLoader(),
                new Class<?>[]{Animal.class}
        );
        Animal animalDynamicProxy = (Animal) proxyClass.getConstructor(InvocationHandler.class)
                .newInstance(new AnimalLogHandler(animal));
        animalDynamicProxy.move(2);

//      Вызов следующей строчки приведет к возникновению исключения: в реализации прокси есть проверка по аннотации
//      @NotOne для параметров вызываемого метода
//        animalDynamicProxy.move(1);
    }

}
