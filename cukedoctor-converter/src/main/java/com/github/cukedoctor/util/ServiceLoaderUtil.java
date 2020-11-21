package com.github.cukedoctor.util;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.renderer.BaseRenderer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.function.Function;

public final class ServiceLoaderUtil<R extends BaseRenderer> {
    private final Function<Class<R>, Iterator<R>> loader;

    public ServiceLoaderUtil() {
        this(c -> ServiceLoader.load(c).iterator());
    }

    public ServiceLoaderUtil(Iterable<R> services) {
        this(x -> services.iterator());
    }

    public ServiceLoaderUtil(Function<Class<R>, Iterator<R>> loader) {
        this.loader = loader;
    }

    public R load(Class<R> service, Class<? extends R> defaultImplementation, CukedoctorConfig cukedoctorConfig, Class<? extends R>... except) {
        HashSet<Class<?>> exceptions = new HashSet<>(Arrays.asList(except));

        Iterator<R> services = loader.apply(service);
        while (services.hasNext()) {
            R candidate = services.next();
            if (!exceptions.contains(candidate.getClass())) {
                candidate.setCukedoctorConfig(cukedoctorConfig);
                return candidate;
            }
        }

        try {
            R defaultImpl = defaultImplementation.getDeclaredConstructor().newInstance();
            defaultImpl.setCukedoctorConfig(cukedoctorConfig);
            return defaultImplementation.getDeclaredConstructor().newInstance();
        } catch (Throwable t) {
            throw new DefaultImplementationInstantiationException(defaultImplementation, t);
        }
    }

    public R initialise(Class<R> service, Class<? extends R> defaultImplementation, I18nLoader i18n, DocumentAttributes attributes,  CukedoctorConfig cukedoctorConfig, Class<? extends R>... except) {
        R renderer = load(service, defaultImplementation, cukedoctorConfig, except);
        renderer.setDocumentAttributes(attributes);
        renderer.setI18n(i18n);
        renderer.setCukedoctorConfig(cukedoctorConfig);
        return renderer;
    }
}