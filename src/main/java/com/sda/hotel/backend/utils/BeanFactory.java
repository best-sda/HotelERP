/*
 * Created by Dmitry Scherbakov in 08.01.2020, 0:08
 */

package com.sda.hotel.backend.utils;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class BeanFactory {
    private static BeanFactory instance;

    public Map<String, Object> getSingletons() {
        return singletons;
    }

    public void setSingletons(Map<String, Object> singletons) {
        this.singletons = singletons;
    }

    private BeanFactory() {
    }

    private Logger logger = LogManager.getLogger(BeanFactory.class);

    public static BeanFactory getInstance() {
        if (instance == null) {
            instance = new BeanFactory();
        }
        return instance;
    }

    public static void setInstance(BeanFactory instance) {
        BeanFactory.instance = instance;
    }

    private Map<String, Object> singletons = new HashMap();

    public Object getBean(String beanName) {
        return singletons.get(beanName);
    }

    public void instantiate(String basePackage) {
        Reflections reflections = new Reflections(basePackage);

        Set<Class<?>> annotated = reflections
                .getTypesAnnotatedWith(Component.class);
        for (Class classObject : annotated) {
            if (!classObject.isInterface()) {
                logger.info("bean: " + classObject.getName());
                Object instance = null;
                try {
                    instance = classObject.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    logger.error("object not instsnceing " + classObject.getName() + e.getMessage());
                }
                String beanName = classObject.getSimpleName()
                        .substring(0, 1).toLowerCase()
                        + classObject.getSimpleName().substring(1);
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
                                logger.trace("call set method in " + field.getName());
                                String setterName = "set" + field.getName()
                                        .substring(0, 1).toUpperCase()
                                        + field.getName().substring(1);
                                Object instance = singletons.get(dependency);
                                if (!dependency.getClass().isInterface()) {
                                    Method setter = object.getClass()
                                            .getMethod(setterName, field.getType());
                                    setter.invoke(object,
                                            singletons.get(dependency));
                                }
                            } catch (NoSuchMethodException
                                    | InvocationTargetException
                                    | IllegalAccessException e) {
                                logger.error(e);
                            }
                        }
                    }
                }
            }
        }
    }

}
