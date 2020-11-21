package com.github.cukedoctor.util;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.config.GlobalConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.renderer.BaseRenderer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@RunWith(JUnit4.class)
public class ServiceLoaderUtilTest {

    CukedoctorConfig cukedoctorConfig = new CukedoctorConfig();

    @Test
    public void shouldReturnFirstServiceLoaderResultIfAvailable() {
        final MyService1 expectedService = new MyService1();
        ServiceLoaderUtil<BaseRenderer> loader = new ServiceLoaderUtil<>(c -> {
            ArrayList<BaseRenderer> services = new ArrayList<>(1);
            services.add(expectedService);
            return services.iterator();
        });

        BaseRenderer service = loader.load(BaseRenderer.class, MyService2.class, cukedoctorConfig);

        assertEquals(expectedService, service);
    }

    @Test
    public void shouldReturnInstanceOfDefaultServiceImplementationIfServiceLoaderHasNoResult() {
        ServiceLoaderUtil<BaseRenderer> loader = new ServiceLoaderUtil<>(c -> Collections.emptyIterator());

        BaseRenderer service = loader.load(BaseRenderer.class, MyService2.class, cukedoctorConfig);

        assertEquals(MyService2.class, service.getClass());
    }

    @Test(expected = DefaultImplementationInstantiationException.class)
    public void shouldThrowIfDefaultConstructorHasNoDefaultConstructor() {
        ServiceLoaderUtil<BaseRenderer> loader = new ServiceLoaderUtil<>(c -> Collections.emptyIterator());

        loader.load(BaseRenderer.class, MyService3.class, cukedoctorConfig);
    }

    @Test
    public void shouldSkipSpecifiedImplementations() {
        BaseRenderer expectedService = new MyService3(42);
        ServiceLoaderUtil<BaseRenderer> loader = new ServiceLoaderUtil<>(c -> {
            ArrayList<BaseRenderer> services = new ArrayList<>(3);
            services.add(new MyService1());
            services.add(new MyService2());
            services.add(expectedService);
            return services.iterator();
        });

        BaseRenderer service = loader.load(BaseRenderer.class, MyService2.class, cukedoctorConfig, MyService1.class, MyService2.class);

        assertEquals(expectedService, service);
    }

    @Test
    public void shouldInitialise() {
        I18nLoader i18n = I18nLoader.newInstance(null);
        DocumentAttributes attributes = new DocumentAttributes();

        ServiceLoaderUtil<BaseRenderer> loader = new ServiceLoaderUtil<>(x -> {
            ArrayList<BaseRenderer> services = new ArrayList<>(1);
            services.add(new MyService1());
            services.add(new MyService2());
            services.add(new MyService3(42));
            return services.iterator();
        });

        MyService3 renderer = (MyService3) loader.initialise(BaseRenderer.class, MyService1.class, i18n, attributes, new CukedoctorConfig(), MyService1.class, MyService2.class);

        assertSame(i18n, renderer.getI18nProvider());
        assertSame(attributes, renderer.getDocumentAttributes());
    }
}
