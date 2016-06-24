package com.bakigoal.algorithms;

public class SortPhoneList {

  public static void main(String[] args) {
    new SortPhoneList().test();
  }

  private void test() {
    Contact[] friends = getUnsortedContacts();
    SortingAndSearching.selectionSort(friends);
    printContacts("Selection sort", friends);

    friends = getUnsortedContacts();
    SortingAndSearching.insertionSort(friends);
    printContacts("Insertion sort", friends);

    friends = getUnsortedContacts();
    SortingAndSearching.bubbleSort(friends);
    printContacts("Bubble sort", friends);

    friends = getUnsortedContacts();
    SortingAndSearching.mergeSort(friends, 0, friends.length-1);
    printContacts("Merge sort", friends);

    friends = getUnsortedContacts();
    SortingAndSearching.quickSort(friends, 0, friends.length-1);
    printContacts("Quick sort", friends);

  }

  private void printContacts(String title, Contact[] friends) {
    System.out.println("--------" + title + "--------");
    for (Contact friend : friends) {
      System.out.println(friend);
    }
    System.out.println();
  }

  public Contact[] getUnsortedContacts() {
    Contact[] friends = new Contact[7];
    friends[0] = new Contact("John", "Smith", "610-555-7384");
    friends[1] = new Contact("Sarah", "Barnes", "215-555-3827");
    friends[2] = new Contact("Mark", "Riley", "733-555-2969");
    friends[3] = new Contact("Laura", "Getz", "663-555-3984");
    friends[4] = new Contact("Larry", "Smith", "464-555-3489");
    friends[5] = new Contact("Frank", "Phelps", "322-555-2284");
    friends[6] = new Contact("Marsha", "Grant", "243-555-2837");
    return friends;
  }
}
