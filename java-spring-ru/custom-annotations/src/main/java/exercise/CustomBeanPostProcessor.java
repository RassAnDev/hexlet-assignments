package exercise;

import java.lang.reflect.Proxy;

import exercise.calculator.Calculator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// BEGIN
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    Map<Class, String> annotatedBeans = new HashMap<>();

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        String valueOfAnnotation;
        if (beanClass.isAnnotationPresent(Inspect.class)) {
            valueOfAnnotation = bean.getClass().getAnnotation(Inspect.class).level();
            annotatedBeans.put(beanClass, valueOfAnnotation);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        final Logger LOGGER = LoggerFactory.getLogger(Calculator.class);

        if (bean.getClass().isAnnotationPresent(Inspect.class)) {
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                   bean.getClass().getInterfaces(),
                   (proxy, method, args) -> {
               if (method.getName().equals("sum")) {
                   LOGGER.info("Was called method: " + method.getName() + "()"+ " with arguments: "
                           + Arrays.toString(args));
                   return method.invoke(bean, args);
               } else if (method.getName().equals("mult")) {
                   LOGGER.info("Was called method: " + method.getName() + "()" + " with arguments: "
                           + Arrays.toString(args));
                   return method.invoke(bean, args);
               }
                       return proxy;
            });
        }
        return bean;
    }
}
// END
