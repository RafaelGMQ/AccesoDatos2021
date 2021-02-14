package com.rjqdf.teoria.A_ficheros.A_acceso_secuencial.B_ficheros_de_caracteres.C_apis_xml.A_dom;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Escritura {

    public static void main(String[] args) {

        try {

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.newDocument();

            // Elemento raiz
            Element root = document.createElement("alumnos");
            document.appendChild(root);

            // Elemento alumno con atributo id
            Element alumno = document.createElement("alumno");
            root.appendChild(alumno);
            Attr attr = document.createAttribute("id");
            attr.setValue("1");
            alumno.setAttributeNode(attr);

            // Elementos nombre, apellidos, grupo y fecha_nacimiento
            addChildToElement(document, alumno, "nombre", "Nerea");
            addChildToElement(document, alumno, "apellidos", "Iglesias Marín");
            addChildToElement(document, alumno, "grupo", "ASIR");
            addChildToElement(document, alumno, "fecha_nacimiento", "01/12/1995");


            // Creación del fichero XML
            File file = new File("output\\alumno.xml");
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            Source source = new DOMSource(document);
            Result result = new StreamResult(file);
//            Result result = new StreamResult(System.out); // para que la salida sea la consola
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {

            e.printStackTrace();
        }
    }

    public static void addChildToElement(Document document, Element element, String childName, String childText) {

        Element child = document.createElement(childName);
        child.appendChild(document.createTextNode(childText));
        element.appendChild(child);
    }
}
