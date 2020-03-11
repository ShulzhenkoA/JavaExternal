package ua.javaexternal_shulzhenko.tariffs.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TariffElement {
    String elementName();
    boolean required() default false;
    double minvalue() default 0;
    String defaultValue() default "";
}
