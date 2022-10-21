package com.nvwa.remote.annotation;

import com.nvwa.remote.config.RegistryConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author liuzhaolu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RegistryConfiguration.class)
public @interface EnableRegistryServer {
}
