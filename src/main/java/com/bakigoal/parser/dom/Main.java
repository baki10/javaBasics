package com.bakigoal.parser.dom;

import com.bakigoal.parser.entity.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<Employee> employees = parseEmployees("employee.xml");

    //Printing the Employee list populated.
    for (Employee emp : employees) {
      System.out.println(emp);
    }
  }

  private static List<Employee> parseEmployees(String path) {

    //Get the DOM Builder Factory
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    //Get the DOM Builder
    DocumentBuilder builder;
    try {
      builder = factory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      System.err.println(e.getLocalizedMessage());
      return Collections.emptyList();
    }

    //Load and Parse the XML document
    //document contains the complete XML as a Tree.
    Document document;
    try {
      document = builder.parse(ClassLoader.getSystemResourceAsStream(path));
    } catch (SAXException | IOException e) {
      System.err.println(e.getLocalizedMessage());
      return Collections.emptyList();
    }

    List<Employee> employees = new ArrayList<>();

    //Iterating through the nodes and extracting the data.
    NodeList nodeList = document.getDocumentElement().getChildNodes();

    for (int i = 0; i < nodeList.getLength(); i++) {

      //We have encountered an <employee> tag.
      Node node = nodeList.item(i);
      if (node instanceof Element) {
        Employee emp = new Employee();
        emp.id = node.getAttributes().getNamedItem("id").getNodeValue();

        NodeList childNodes = node.getChildNodes();
        for (int j = 0; j < childNodes.getLength(); j++) {
          Node cNode = childNodes.item(j);

          //Identifying the child tag of employee encountered.
          if (cNode instanceof Element) {
            String content = cNode.getLastChild().getTextContent().trim();
            switch (cNode.getNodeName()) {
              case "firstName":
                emp.firstName = content;
                break;
              case "lastName":
                emp.lastName = content;
                break;
              case "location":
                emp.location = content;
                break;
            }
          }
        }
        employees.add(emp);
      }

    }
    return employees;
  }
}
