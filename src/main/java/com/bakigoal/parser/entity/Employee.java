package com.bakigoal.parser.entity;

/**
 * Created by ilmir on 27.09.16.
 */
public class Employee {
  public String id;
  public String firstName;
  public String lastName;
  public String location;

  @Override
  public String toString() {
    return firstName + " " + lastName + "(" + id + ") " + location;
  }

}
