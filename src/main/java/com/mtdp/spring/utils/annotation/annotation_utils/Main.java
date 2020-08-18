package com.mtdp.spring.utils.annotation.annotation_utils;

import com.mtdp.spring.utils.annotation.annotation_utils.anno.Service;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/16
 */
public class Main {

    /**
     * AnnotationUtils.getAnnotationAttributes 获取annotation下的所有属性以Map的形式返回
     */
    private static void test1() {
        Annotation[] annotations = Bean.class.getAnnotations();
        for (Annotation annotation : annotations) {
            Map<String, Object> annotationAttributes = AnnotationUtils.getAnnotationAttributes(annotation);
            annotationAttributes.forEach((k, v) -> System.out.println(k + "-> " + v));
        }
    }

    /**
     * AnnotationUtils.findAnnotation(Class<?> clazz, Class<A> annotationType)
     * algorithm:
     * first:Search for the annotation on the given class and return it if found.
     * second:Recursively search through all annotations that the given class declares.
     * third:Recursively search through all interfaces that the given class declares.
     * fourth:Recursively search through the superclass hierarchy of the given class.
     */
    private static void test2() {
        Service annotation = AnnotationUtils.findAnnotation(Bean.class, Service.class);
        if (annotation != null) {
            //Annotation.annotationType -> Returns the annotation type of this annotation.
            //interface com.mtdp.spring.utils.annotation.annotation_utils.anno.Service
            System.out.println(annotation.annotationType());

            Map<String, Object> annotationAttributes = AnnotationUtils.getAnnotationAttributes(annotation);
            //value-> bean
            //classes-> [Ljava.lang.Class;@26a1ab54
            annotationAttributes.forEach((k, v) -> System.out.println(k + "-> " + v));
        }
    }

    /**
     * 1、获取注解中'value'属性的值
     * AnnotationUtils.getValue(Annotation annotation)
     * 2、获取注解中指定'attributeName'属性的值
     * AnnotationUtils.getValue(Annotation annotation,String attributeName)
     * <p>
     * AnnotationUtils.getValue原理：
     * getValue会传递Annotation和attributeName两个值
     * 1）Method method = annotation.annotationType().getDeclaredMethod(attributeName);
     * 2）method.invoke(annotation);
     */
    private static void test3() {
        try {
            Method method = Bean.class.getMethod("method", null);
            Service annotation = AnnotationUtils.findAnnotation(method, Service.class);
            if (annotation != null) {
                Object value = AnnotationUtils.getValue(annotation, "classes");
                System.out.println(value);
            }
        } catch (NoSuchMethodException e) {
            //nothing to do
        }
    }

    /**
     * 1、获取注解属性的默认值
     * AnnotationUtils.getDefaultValue(Annotation annotation,String attributeName)
     * 原理：
     * annotationType.getDeclaredMethod(attributeName).getDefaultValue();
     */
    private static void test4() {
        Annotation[] annotations = Bean.class.getAnnotations();
        for (Annotation annotation : annotations) {
            Map<String, Object> annotationAttributes = AnnotationUtils.getAnnotationAttributes(annotation);
            for (String attributeName : annotationAttributes.keySet()) {
                Object defaultValue = AnnotationUtils.getDefaultValue(annotation, attributeName);
                System.out.println(defaultValue);
            }
        }
    }


    /**
     * 如何判断一个方法是否是注解类中属性方法？
     * AnnotationUtils.isAttributeMethod(method)
     * 原理：
     * (method != null && method.getParameterCount() == 0 && method.getReturnType() != void.class)
     * <p>
     * Annotation:Service
     * method.getName -> value
     * method.getName -> classes
     * method.getAnnotatedReturnType -> sun.reflect.annotation.AnnotatedTypeFactory$AnnotatedArrayTypeImpl@12a3a380
     * method.getAnnotatedReturnType -> sun.reflect.annotation.AnnotatedTypeFactory$AnnotatedTypeBaseImpl@7ea987ac
     */
    private static void test5() {
        Method[] methods = Service.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method.getName -> " + method.getName());
            System.out.println("method.getAnnotatedReturnType -> " + method.getAnnotatedReturnType());
        }
    }


    /**
     * 1、AnnotationElement.getAnnotations
     * Returns annotations that are <em>present</em> on this element.
     * If there are no annotations <em>present</em> on this element, the return
     * value is an array of length 0.
     * <p>
     * 2、AnnotationElement.getDeclaredAnnotations
     * Returns annotations that are <em>directly present</em> on this element.
     * This method ignores inherited annotations.
     * 该方法将忽略继承（@Inherited）的注解
     */
    private static void test6() {
        Annotation[] annotations = Bean.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Annotation[] declaredAnnotations = Bean.class.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }
    }

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        test5();
        //test6();
    }
}
