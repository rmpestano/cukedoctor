package com.github.cukedoctor.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/** Created by rafael-pestano on 26/06/2015. */
public class Assert implements Serializable {

  private Assert() {}

  /**
   * @param object to assert
   * @return TRUE assertion when given objects is not null, FALSE otherwise
   */
  public static boolean notNull(Object object) {

    return object != null;
  }

  /**
   * @param object to assert
   * @return TRUE assertion when given objects is null, FALSE otherwise
   */
  public static boolean isNull(Object object) {

    return object == null;
  }

  /**
   * @param assertion expression to be negated
   * @return just negates the assertion
   */
  public static boolean not(boolean assertion) {

    return !assertion;
  }

  /**
   * @param text to assert
   * @return TRUE when given text has any character, FALSE otherwise
   */
  public static boolean hasText(String text) {
    return notNull(text) && text.trim().length() > 0;
  }

  /**
   * @param textToSearch complete text
   * @param substring text to search in textToSearch param
   * @return TRUE when given text contains the given substring, FALSE otherwise
   */
  public static boolean contains(String textToSearch, String substring) {
    return notNull(textToSearch) && textToSearch.contains(substring);
  }

  /**
   * @param array list to check emptiness
   * @return TRUE when given array has elements; that is, it must not be {@code null} and must have
   *     at least one element. FALSE otherwise
   */
  public static boolean notEmpty(Object[] array) {
    if (array == null || array.length == 0) {
      return false;
    }
    for (Object element : array) {
      if (element != null) {
        return true;
      }
    }
    return false;
  }

  /**
   * @param collection collection to check emptiness
   * @return TRUE when given collection has elements; that is, it must not be {@code null} and must
   *     have at least one element. @return FALSE otherwise
   */
  public static boolean notEmpty(Collection<?> collection) {
    return notNull(collection) && !collection.isEmpty();
  }

  /**
   * @param array to check elements
   * @return TRUE when given array has at least one not null element; FALSE otherwise
   */
  public static boolean hasElements(Object[] array) {
    if (array == null || array.length > 0) {
      return false;
    }
    for (Object o : array) {
      if (o != null) {
        return true;
      }
    }
    return false;
  }

  /**
   * @param array to check elements
   * @return TRUE when given array has at least one not null element; FALSE otherwise
   */
  public static boolean hasElements(Collection array) {
    if (array == null || array.isEmpty()) {
      return false;
    }
    for (Object o : array) {
      if (o != null) {
        return true;
      }
    }
    return false;
  }

  /**
   * @param map to check emptiness
   * @return TRUE if given Map has entries; that is, it must not be {@code null} and must have at
   *     least one entry. Queue FALSE otherwise
   */
  public static boolean notEmpty(Map<?, ?> map) {
    if (map == null) {
      return false;
    }
    return hasElements(map.entrySet().toArray());
  }

  /**
   * Assert that an array has no null elements. Note: Does not complain if the array is empty!
   *
   * <pre class="code">
   * Assert.noNullElements(array, &quot;The array must have non-null elements&quot;);
   * </pre>
   *
   * @param array the array
   * @return TRUE when given array has no null elements; FALSE otherwise
   */
  public static boolean notNull(Object[] array) {
    if (array != null) {
      for (Object element : array) {
        if (element == null) {
          return false;
        }
      }
    }
    return true;
  }
}
