package com.bakigoal.ocjp.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by ilmir on 16.04.16.
 */
public class ObjectSerializeUtils {


  public static Object deserialize(String file) {
    //De-serialize the object
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
      return ois.readObject();
    } catch (FileNotFoundException fnfe) {
      System.err.println("cannot create a file with the given file name ");
    } catch (IOException ioe) {
      System.err.println("an I/O error occurred while processing the file");
    } catch (ClassNotFoundException cnfe) {
      System.err.println("cannot recognize the class of the object - is the file corrupted?");
    }
    return null;
  }

  public static void serialize(Object object, String file) {
    //Serialize the object
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
      oos.writeObject(object);
    } catch (FileNotFoundException fnfe) {
      System.err.println("cannot create a file with the given file name ");
    } catch (IOException ioe) {
      System.err.println("an I/O error occurred while processing the file");
    } // the ObjectOutputStream will auto-close, so don'thread have to worry about it

  }
}
