package ru.alfabank.homework14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ObjectInspector {

    public static void inspect(Object obj) throws Exception {
        if (obj == null) return;
        Class<?> clazz = obj.getClass();

        System.out.println();
        System.out.println("<==| КЛАСС: " + clazz.getName() + " |==>");

        System.out.println("\n[ПОЛЯ]");
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);
            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " "
                    + field.getName() + " = " + value);
        }

        System.out.println("\n[КОНСТРУКТОРЫ]");
        for (Constructor<?> c : clazz.getDeclaredConstructors()) {
            System.out.println(Modifier.toString(c.getModifiers()) + " " + c.getName());
        }

        System.out.println("\n[МЕТОДЫ]");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getSimpleName()
                    + " " + method.getName());
        }
    }
}
