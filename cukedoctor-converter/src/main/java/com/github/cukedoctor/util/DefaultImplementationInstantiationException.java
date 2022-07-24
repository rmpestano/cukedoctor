package com.github.cukedoctor.util;

public class DefaultImplementationInstantiationException extends RuntimeException {
  public DefaultImplementationInstantiationException(Class<?> clazz, Throwable t) {
    super(String.format("Failed to instantiate '%s'", clazz.getName()), t);
  }
}
