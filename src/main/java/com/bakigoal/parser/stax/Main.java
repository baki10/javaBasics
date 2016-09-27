package com.bakigoal.parser.stax;

import com.bakigoal.parser.entity.Employee;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ilmir on 27.09.16.
 */
public class Main {
  public static void main(String[] args) throws XMLStreamException {

    List<Employee> employees = parseEmployees("employee.xml");

    //Printing the Employee list populated.
    for (Employee emp : employees) {
      System.out.println(emp);
    }
  }

  private static List<Employee> parseEmployees(String path) throws XMLStreamException {
    List<Employee> employees = new ArrayList<>();
    Employee currEmployee = new Employee();
    String tagContent = null;
    //factory
    XMLInputFactory factory = XMLInputFactory.newInstance();
    //reader
    XMLStreamReader reader;
    try {
      reader = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream(path));
    } catch (XMLStreamException e) {
      System.err.println(e.getLocalizedMessage());
      return Collections.emptyList();
    }

    while (reader.hasNext()) {
      int event = reader.next();

      switch (event) {
        case XMLStreamConstants.START_ELEMENT:
          if ("employees".equals(reader.getLocalName())) {
            employees = new ArrayList<>();
          } else if ("employee".equals(reader.getLocalName())) {
            currEmployee = new Employee();
            currEmployee.id = reader.getAttributeValue(0);
          }
          break;

        case XMLStreamConstants.CHARACTERS:
          tagContent = reader.getText().trim();
          break;

        case XMLStreamConstants.END_ELEMENT:
          switch (reader.getLocalName()) {
            case "employee":
              employees.add(currEmployee);
              break;
            case "firstName":
              currEmployee.firstName = tagContent;
              break;
            case "lastName":
              currEmployee.lastName = tagContent;
              break;
            case "location":
              currEmployee.location = tagContent;
              break;
          }
          break;

        case XMLStreamConstants.START_DOCUMENT:
          employees = new ArrayList<>();
          break;
      }

    }
    return employees;
  }
}
