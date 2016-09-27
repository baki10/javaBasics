package com.bakigoal.parser.sax;

import com.bakigoal.parser.entity.Employee;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * The Handler for SAX Events.
 */
class SaxHandler extends DefaultHandler {

  List<Employee> employees = new ArrayList<>();
  Employee employee = null;
  String content = null;

  @Override
  //Triggered when the start of tag is found.
  public void startElement(String uri, String localName, String qName, Attributes attributes)
      throws SAXException {

    switch (qName) {
      //Create a new Employee object when the start tag is found
      case "employee":
        employee = new Employee();
        employee.id = attributes.getValue("id");
        break;
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    switch (qName) {
      //Add the employee to list once end tag is found
      case "employee":
        employees.add(employee);
        break;
      //For all other end tags the employee has to be updated.
      case "firstName":
        employee.firstName = content;
        break;
      case "lastName":
        employee.lastName = content;
        break;
      case "location":
        employee.location = content;
        break;
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    content = String.copyValueOf(ch, start, length).trim();
  }
}