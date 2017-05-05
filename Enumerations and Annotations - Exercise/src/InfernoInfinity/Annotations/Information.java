package InfernoInfinity.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Information {
    public String author() default "No author";
    public int revision() default 0;
    public String description()default "No description";
    public String[] reviewers();

}
