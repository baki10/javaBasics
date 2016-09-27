package com.bakigoal.parser.sax;

import com.bakigoal.parser.entity.Employee;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by ilmir on 27.09.16.
 */
public class Main {
  public static void main(String[] args) throws Exception {
    SAXParserFactory parserFactory = SAXParserFactory.newInstance();
    SAXParser parser = parserFactory.newSAXParser();
    SaxHandler handler = new SaxHandler();
    parser.parse(ClassLoader.getSystemResourceAsStream("employee.xml"), handler);

    //Printing the list of employees obtained from XML
    for (Employee emp : handler.employees) {
      System.out.println(emp);
    }
  }
}
