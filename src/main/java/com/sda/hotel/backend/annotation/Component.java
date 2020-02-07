/*
 * Created by Dmitry Scherbakov in 06.01.2020, 16:36
 */
package com.sda.hotel.backend.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String type() default "";
}
