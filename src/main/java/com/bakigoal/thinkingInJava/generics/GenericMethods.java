package com.bakigoal.thinkingInJava.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by ilmir on 22.05.16.
 */
public class GenericMethods {
  public static void main(String[] args) {
    Set<String> guys = new HashSet<>(Arrays.asList("Tom", "Dick", "Harry"));
    Set<String> stooges = new HashSet<>(Arrays.asList("Larry", "Moe", "Curly"));
    Set<String> aflCio = union(guys, stooges);
    Set<String> safeUnion = safeUnion(guys, stooges);
    System.out.println(aflCio);
    System.out.println(safeUnion);
  }

  // Uses raw types - unacceptable! (Item 23)
  public static Set union(Set s1, Set s2) {
    Set result = new HashSet(s1);
    result.addAll(s2);
    return result;
  }

  // Generic method
  public static <E> Set<E> safeUnion(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> result = new HashSet<>(s1);
    result.addAll(s2);
    return result;
  }

  // Returns the maximum value in a list - uses recursive type bound
  public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
    Iterator<? extends T> i = list.iterator();
    T result = i.next();
    while (i.hasNext()) {
      T t = i.next();
      if (t.compareTo(result) > 0)
        result = t;
    }
    return result;
  }

  public static void swap(List<?> list, int i, int j) {
    swapHelper(list, i, j);
  }

  // Private helper method for wildcard capture
  private static <E> void swapHelper(List<E> list, int i, int j) {
    list.set(i, list.set(j, list.get(i)));
  }
}
