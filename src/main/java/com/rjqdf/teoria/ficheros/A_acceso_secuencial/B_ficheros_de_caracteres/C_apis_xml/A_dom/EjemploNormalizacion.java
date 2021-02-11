package com.rjqdf.teoria.ficheros.A_acceso_secuencial.B_ficheros_de_caracteres.C_apis_xml.A_dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class EjemploNormalizacion {

    public static void main(String[] args) {

        try {

            File file = new File("input\\fichero.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);


            // Se imprime el XML
            System.out.println("XML ORIGINAL:");
            System.out.println();

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            Source source = new DOMSource(document);
            Result result = new StreamResult(System.out); // para que la salida sea la consola
            transformer.transform(source, result);


            // Se añade más texto a un nodo
            Element element = document.getDocumentElement();
            Text text = document.createTextNode("MÁS TEXTO");
            element.appendChild(text);
            element.appendChild(document.createTextNode(""));
            int numChildren = element.getChildNodes().getLength();
            System.out.println();
            System.out.println();
            System.out.println("Número de hijos: " + numChildren); // El nodo tendrá dos hijos #Text
            System.out.println();

            transformer.transform(source, result);


            // Se normaliza y se muestra el resultado
            element.normalize();

            numChildren = element.getChildNodes().getLength();
            System.out.println();
            System.out.println();
            System.out.println("Número de hijos después de normalizar: " + numChildren);
            System.out.println();

            transformer.transform(source, result);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
