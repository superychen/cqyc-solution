package com.cqyc.solution.xxx;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

/**
 * @author cqyc
 * @create 2022-11-03-19:34
 */
public class TestXX {


    public static void main(String[] args) throws Exception {
        File inputFile = new File("/Users/yangchen/IdeaProjects/cqyc-solution/src/main/java/com/cqyc/solution/xxx/test.xml");
        DocumentBuilderFactory dbFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        System.out.print("Root element: ");
        System.out.println(doc.getDocumentElement().getNodeName());

        //根节点
        Element root = doc.getDocumentElement();
        NodeList elements = root.getElementsByTagName("cas:authenticationSuccess");
        Node item = elements.item(0);
        System.out.println(item.getNodeType());
        System.out.println(Node.ELEMENT_NODE);
        Element element = (Element) item;
        System.out.println("222: " + element.getNodeName());

        NodeList elements1 = ((Element) item).getElementsByTagName("cas:user");
        System.out.println(elements1.item(0).getTextContent());

        Element element2 = (Element) ((Element) item).getElementsByTagName("cas:attributes").item(0);
        System.out.println("cas:firstname: " + element2.getElementsByTagName("cas:firstname").item(0).getTextContent());
        System.out.println("cas:lastname: " + element2.getElementsByTagName("cas:lastname").item(0).getTextContent());
        System.out.println("cas:title: " + element2.getElementsByTagName("cas:title").item(0).getTextContent());
        System.out.println("cas:email: " + element2.getElementsByTagName("cas:email").item(0).getTextContent());
        System.out.println("cas:affiliation001: " + element2.getElementsByTagName("cas:affiliation").item(0).getTextContent());
        System.out.println("cas:affiliation002: " + element2.getElementsByTagName("cas:affiliation").item(1).getTextContent());

        System.out.println("cas:proxyGrantingTicket: " + ((Element) item).getElementsByTagName("cas:proxyGrantingTicket").item(0).getTextContent());
    }

}
