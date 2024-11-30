package com.icaroerasmo.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ClassUtil {
    public static  <T> List<String> getPropertyNames(Class<T> clazz) {
        return Arrays.stream(clazz.getDeclaredFields()).map(Field::getName).toList();
    }
    public static <T> Boolean containsProperty(Class<T> clazz, String property) {
        return containsProperty(clazz, property, List.of());
    }
    public static <T> Boolean containsProperty(Class<T> clazz, String property, List<String> ignore) {
        return getPropertyNames(clazz).stream().
                filter(name -> !ignore.contains(name)).
                anyMatch(name -> name.equals(property));
    }
}
