package com.bakigoal.algorithms;

/**
 * Created by admin on 22.06.2016.
 */
public class Contact implements Comparable {

  private String firstName, lastName, phone;

  public Contact(String firstName, String lastName, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
  }

  @Override
  public String toString() {
    return lastName + ", " + firstName + "\t" + phone;
  }

  @Override
  public int compareTo(Object other) {
    int result;
    if (lastName.equals(((Contact) other).lastName)) {
      result = firstName.compareTo(((Contact) other).firstName);
    } else {
      result = lastName.compareTo(((Contact) other).lastName);
    }
    return result;
  }
}
