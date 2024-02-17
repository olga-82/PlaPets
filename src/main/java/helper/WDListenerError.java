package helper;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface WDListenerError {


    public static void onError(Object target, Method method, Object[] args, Throwable throwable, WebDriver driver) {

    }

    void onError(Object target, Method method, Object[] args, InvocationTargetException e, WebDriver driver);
}
