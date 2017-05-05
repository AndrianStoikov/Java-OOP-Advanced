package tests.fakes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Andrian on 22.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NonDisposableAnnotation {
}
