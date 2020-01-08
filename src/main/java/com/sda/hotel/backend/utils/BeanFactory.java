/*
 * Created by Dmitry Scherbakov in 08.01.2020, 0:08
 */

package com.sda.hotel.backend.utils;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BeanFactory {
    private Map <String, Object> singletons = new HashMap();

    public Object getBean(String beanName) {
        return singletons.get(beanName);
    }

    public void instantiate(String basePackage) {
        Reflections reflections = new Reflections(basePackage);

        Set <Class <?>> annotated = reflections.getTypesAnnotatedWith(Component.class);

        for (Class classObject : annotated) {
            if (!classObject.isInterface()) {
                // System.out.println("Component: " + classObject);
                Object instance = null;
                try {
                    instance = classObject.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                String beanName = classObject.getSimpleName().substring(0, 1).toLowerCase() + classObject.getSimpleName().substring(1);
                singletons.put(beanName, instance);
            }

        }
    }

    public void populateProperties() {
        //System.out.println("populateProperties");
        for (Object object : singletons.values()) {
            for (Field field : object.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    for (Object dependency : singletons.keySet()) {

                        if (dependency.equals(field.getName())) {
                            try {
                                String setterName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                                //System.out.println("Setter name = " + setterName);
                                Object instance = singletons.get(dependency);
                                if (dependency.getClass().isInterface()) {
                                }
                                Method setter = object.getClass().getMethod(setterName, field.getType());
                                setter.invoke(object, singletons.get(dependency));
                            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

}
