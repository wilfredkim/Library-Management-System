package Qualifiers;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Qualifier
@Retention(RUNTIME)
@Target({TYPE,METHOD, FIELD,PARAMETER})
public @interface  LoginQ {
    LoginChoice value();
    public  enum LoginChoice {
        Student,
        Librarian,
        Admin,
    }
}
