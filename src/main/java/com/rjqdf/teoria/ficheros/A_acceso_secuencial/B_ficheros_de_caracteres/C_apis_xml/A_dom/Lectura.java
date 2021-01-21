package com.rjqdf.teoria.ficheros.A_acceso_secuencial.B_ficheros_de_caracteres.C_apis_xml.A_dom;

import org.w3c.dom.Document;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class Lectura {

    public static void main(String[] args) {

        try {

            File file = new File("output\\alumnos.xml");

            // Parsear XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            // OPCIONAL: validar el fichero con un esquema 'alumnos.xsd'
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
            Schema schema = schemaFactory.newSchema(new File("input\\alumnos.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(document));

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
