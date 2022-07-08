package com.nvwa.registry.annotation;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author liuzhaolu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RegistryServer {

    /**
     * 服务类
     * @return
     */
    Class<?> service() default Void.class;
}
