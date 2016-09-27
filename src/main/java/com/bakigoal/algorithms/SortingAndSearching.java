package com.bakigoal.algorithms;

/**
 * Created by admin on 22.06.2016.
 */
public class SortingAndSearching {

  private static <T extends Comparable<? super T>> void swap(T[] data, int min, int i) {
    T temp;
    temp = data[min];
    data[min] = data[i];
    data[i] = temp;
  }

  /**
   * Sorts the specified array of integers using the selection
   * sort algorithm.
   *
   * @param data the array to be sorted
   */
  public static <T extends Comparable<? super T>> void selectionSort(T[] data) {
    int min;
    for (int i = 0; i < data.length - 1; i++) {
      min = i;
      for (int scan = i + 1; scan < data.length; scan++) {
        if (data[scan].compareTo(data[min]) < 0) {
          min = scan;
        }
      }
      // Swap the values
      swap(data, min, i);
    }
  }

  /**
   * Sorts the specified array of objects using an insertion
   * sort algorithm.
   *
   * @param data the array to be sorted
   */
  public static <T extends Comparable<? super T>> void insertionSort(T[] data) {
    for (int i = 1; i < data.length; i++) {
      T key = data[i];
      int position = i;
      // Shift larger values to the right
      while (position > 0 && data[position - 1].compareTo(key) > 0) {
        data[position] = data[position - 1];
        position--;
      }
      data[position] = key;
    }
  }

  /**
   * Sorts the specified array of objects using a bubble sort
   * algorithm.
   *
   * @param data the array to be sorted
   */
  public static <T extends Comparable<? super T>> void bubbleSort(T[] data) {
    for (int i = data.length - 1; i >= 0; i--) {
      for (int scan = 0; scan <= i - 1; scan++) {
        if (data[scan].compareTo(data[scan + 1]) > 0) {
          swap(data, scan, scan + 1);
        }
      }
    }
  }

  /**
   * Sorts the specified array of objects using the quick sort
   * algorithm.
   *
   * @param data the array to be sorted
   * @param min  the integer representation of the minimum value
   * @param max  the integer representation of the maximum value
   */
  public static <T extends Comparable<? super T>> void quickSort(T[] data, int min, int max) {
    if (max - min <= 0) {
      return;
    }
    // Create partitions
    int partitionIndex = findPartition(data, min, max);
    // Sort the left side
    quickSort(data, min, partitionIndex - 1);
    // Sort the right side
    quickSort(data, partitionIndex + 1, max);

  }

  private static <T extends Comparable<? super T>> int findPartition(T[] data, int min, int max) {
    int left = min;
    int right = max;
    int middle = (min + max) / 2;
    T partitionElement = data[middle];

    while (left < right) {
      // search for an element that is > the partitionElement
      while (data[left].compareTo(partitionElement) <= 0 && left < max - 1) {
        left++;
      }
      // search for an element that is < the partitionElement
      while (right > 0 && data[right].compareTo(partitionElement) >= 0) {
        right--;
      }
      // swap the elements
      if (left < right) {
        swap(data, left, right);
      }
    }
    // move partition element to partition index
    swap(data, right, min);
    return right;
  }

  /**
   * Sorts the specified array of objects using the merge sort
   * algorithm.
   *
   * @param data the array to be sorted
   * @param min  the integer representation of the minimum value
   * @param max  the integer representation of the maximum value
   */
  public static <T extends Comparable<? super T>> void mergeSort(T[] data, int min, int max) {
    T[] temp;
    int index1, left, right;
    // return on list of length one
    if (min == max) {
      return;
    }
    // find the length and the midpoint of the list
    int size = max - min + 1;
    int pivot = (min + max) / 2;
    temp = (T[]) (new Comparable[size]);
    mergeSort(data, min, pivot); // sort left half of list
    mergeSort(data, pivot + 1, max); // sort right half of list
    // copy sorted data into workspace
    for (index1 = 0; index1 < size; index1++)
      temp[index1] = data[min + index1];
    // merge the two sorted lists
    left = 0;
    right = pivot - min + 1;
    for (index1 = 0; index1 < size; index1++) {
      if (right <= max - min) {
        if (left <= pivot - min) {
          if (temp[left].compareTo(temp[right]) > 0) {
            data[index1 + min] = temp[right++];
          } else {
            data[index1 + min] = temp[left++];
          }
        } else {
          data[index1 + min] = temp[right++];
        }
      } else {
        data[index1 + min] = temp[left++];
      }
    }
  }
}
