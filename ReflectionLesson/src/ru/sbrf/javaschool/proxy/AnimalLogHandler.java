package ru.sbrf.javaschool.proxy;

import ru.sbrf.javaschool.annotation.NotOne;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Обработчик динамичесокого прокси для логгирования событий старта и завершения проксируемого метода
 * Так же, выполняется проверка: в случае, если метод помечен аннотацией @NotOne, то все аргументы метода не равны 1
 */
public class AnimalLogHandler implements InvocationHandler {

    private final Object original;

    public AnimalLogHandler(Object original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Start " + method.getName());
        checkIfArgumentsNotOne(method, args);
        method.invoke(original, args);
        System.out.println("Stop " + method.getName());
        return null;
    }

    /**
     * Проверка, что в случае, если метод помечен аннотацией @NotOne, все аргументы метода не равны 1
     *
     * @param method {@link Method} описание метода класса
     * @param args {@link Object[]} список аргументов
     */
    private void checkIfArgumentsNotOne(Method method, Object[] args) {
        if (method.isAnnotationPresent(NotOne.class)) {
            for (Object arg: args) {
                if (arg instanceof Integer && (int) arg == 1) {
                    throw new RuntimeException("Аргумент не должен быть 1");
                }
            }
        }
    }

}
