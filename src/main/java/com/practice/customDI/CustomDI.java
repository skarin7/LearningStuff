package com.practice.customDI;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Purpose is to maintain object life cycle
 * 1. Priority for Constructor injection
 *      - If no constructors are having @Inject annotation, then fall back to default constrcutor
 * 2. Field level injection
 * 3. Method level injection
 *
 *
 * When a client class is annotated with @Inject, DI should maintain its life cycle.
 * Use reflection to get the meta data about the class that is to injected.
 * 1. Treat singletons's separately as DI should make sure there should only one instance of it at any time
 * 2. Container should be thread-safe as it would be accessed by different classes indiffeent threads
 * 3. DI should be aware of the class package it should scan while it is searching for the class to be annaotated
 * 4. DI should work for any class : CLass<T>
 * 5. Expose a public method to customize the interface vs implementation binding.
 *
 */
@SuppressWarnings("unchecked")
public class CustomDI {
    private Map<Class<?>, Class<?>> implementations = new ConcurrentHashMap<>();
    private Map<Class<?>, Object> singletons = new ConcurrentHashMap<>();


    public <T> void bind(Class<T> inteface,  Class<? extends T> implementation) {
        implementations.putIfAbsent(inteface, implementation);
    }

    public Set<Class<?>> objectsInContainer() {
        Set<Class<?>> allSets = new HashSet<>();
        allSets.addAll(implementations.keySet());
        allSets.addAll(singletons.keySet());
        return allSets;
    }

    public <T> T getInstance(Class<T> classz) {
        //see if it already exists otherwise create one
        try {
            boolean isSingleton = classz.isAnnotationPresent(Singleton.class);
            if(isSingleton) {
                return (T) singletons.computeIfAbsent(classz, this::createInstance);
            } else {
                return createInstance(classz);
            }
        } catch (Exception e) {
            throw new RuntimeException(" can not create instance of it " + classz.getName() + " "  + e.getMessage());
        }
    }

    private <T> T createInstance(Class<T> classz) {
        //get all the constructores first, then see if they have Inject annotation
        //if not get the object created usig default constructor.
        //then see field injection
        //then method injecton (setter injection

        try {
            boolean isInterfaceInjection = implementations.containsKey(classz);
            if(isInterfaceInjection) {
                classz = (Class<T>) implementations.get(classz);
            }
            Constructor<?> injectableCOnstructor = findInjectableCOnstructor(classz);
            T instance =   (T) (injectableCOnstructor != null ?  createInstanceWithConstructor(injectableCOnstructor)
                    : classz.getDeclaredConstructor().newInstance());

            //second priority to field injection
            injectFields(classz, instance);
            injectMethods(classz, instance);

            return instance;
        } catch (Exception e) {
            throw new RuntimeException(" Error creating object" + classz.getName() + " : " + e.getMessage());
        }
    }

    private <T> void injectMethods(Class<T> classz, T instance) throws Exception {
        for (Method declaredMethod : classz.getDeclaredMethods()) {
            if(declaredMethod.isAnnotationPresent(Inject.class)) {

                //inject all the params before modifying this method in the actual instance being created.
                Object[] params = Arrays.stream(declaredMethod.getParameterTypes())
                        .map(this::getInstance)
                        .toArray();
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(instance, params);
            }
        }

    }

    private <T> void injectFields(Class<T> classz, T instance) throws Exception {
        for (Field declaredField : classz.getDeclaredFields()) {
            if(declaredField.isAnnotationPresent(Inject.class)) {
                Object fieldInstnce = getInstance(declaredField.getType());
                declaredField.setAccessible(true);
                declaredField.set(instance, fieldInstnce);
            }
        }

    }

    /**
     * Construct all the params recursively and then the current class object
     * @param constructor
     * @return
     * @throws Exception
     */
    private Object createInstanceWithConstructor(Constructor<?> constructor) throws Exception {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] params = Arrays.stream(parameterTypes)
                .map(this::getInstance)
                .toArray();
        return constructor.newInstance(params);
    }

    private static  Constructor<?> findInjectableCOnstructor(Class<?> classz) {
        return Arrays.stream(classz.getDeclaredConstructors()).filter(x -> x.isAnnotationPresent(Inject.class)).
                findFirst().orElse(null);
    }




}
