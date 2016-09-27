package com.bakigoal.ocjp.io;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple class to illustrate object streams: fill a data structure, write it to a
 * temporary file and read it back and print the read data structure
 * <p>
 * Created by ilmir on 16.04.16.
 */
public class ObjectStream {
  private static Map<String, String> presidentsOfUS = new HashMap<>();

  static {
    presidentsOfUS.put("Barack Obama", "2009 to ----, Democratic Party, 56th term");
    presidentsOfUS.put("George W. Bush", "2001 to 2009, Republican Party, 54th and 55th terms");
    presidentsOfUS.put("Bill Clinton", "1993 to 2001, Democratic Party, 52nd and 53rd terms");
  }

  public static void main(String[] args) {
    String fileName = "object.data";
    ObjectSerializeUtils.serialize(presidentsOfUS, fileName);

    Object obj = ObjectSerializeUtils.deserialize(fileName);
    if (obj != null && obj instanceof Map) {
      Map<String, String> presidents = (Map<String, String>) obj;
      System.out.println("President name \t Description \n");
      for (Map.Entry<String, String> president : presidents.entrySet()) {
        System.out.printf("%s \t %s %n", president.getKey(), president.getValue());
      }
    }
  }
}
