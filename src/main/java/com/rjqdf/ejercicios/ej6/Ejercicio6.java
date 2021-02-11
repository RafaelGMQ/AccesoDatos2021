package com.rjqdf.ejercicios.ej6;

import com.rjqdf.ejercicios.ej6.dominio.Cliente;
import com.rjqdf.ejercicios.ej6.dominio.Pedido;
import com.rjqdf.ejercicios.ej6.dominio.Producto;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ejercicio6 {

    public static void main(String[] args) {

//        apartado1();
//        apartado2();
//        apartado3();
        apartado4();
    }

    public static void apartado1() {

        try {

            File file = new File("output\\alumnos.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList listaNodosAlumno = document.getDocumentElement().getChildNodes();

            for(int i = 0; i < listaNodosAlumno.getLength(); i++) {

                Node node = listaNodosAlumno.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element alumno = (Element) node;

                    // Se crea el elemento curso y se le asigna un valor aleatorio entre 1 y 2
                    Element curso = document.createElement("curso");
                    curso.appendChild(document.createTextNode( String.valueOf( (int) ( Math.random() * 2 + 1 ) ) ));

                    // Se inserta el elemento curso con la tabulación apropiada
                    alumno.getLastChild().setTextContent(alumno.getLastChild().getTextContent() + "\t"); // tabulación antes
                    alumno.appendChild(curso);
                    alumno.appendChild(document.createTextNode("\n\t")); // tabulación después
                }

            }

            // Se reescribe el fichero alumnos.xml con el nuevo DOM
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            Source source = new DOMSource(document);
            Result result = new StreamResult(file);
            transformer.transform(source, result);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void apartado2() {

        try {

            File file = new File("output\\alumnos.xml");

            // Parsear XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList listaNodosAlumno = document.getElementsByTagName("alumno");

            int primeroAsir=0;
            int segundoAsir=0;
            int primeroDam=0;
            int segundoDam=0;
            int primeroSmr=0;
            int segundoSmr=0;

            for(int i = 0; i < listaNodosAlumno.getLength(); i++) {

                Node node = listaNodosAlumno.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    System.out.print(element.getElementsByTagName("nombre").item(0).getTextContent() + " ");

                    String grupo = element.getElementsByTagName("grupo").item(0).getTextContent();
                    String curso = element.getElementsByTagName("curso").item(0).getTextContent();

                    if (grupo.equals("ASIR")) {

                        if (curso.equals("1")) primeroAsir++;
                        else segundoAsir++;

                    } else if (grupo.equals("DAM")) {

                        if (curso.equals("1")) primeroDam++;
                        else segundoDam++;

                    } else if (grupo.equals("SMR")) {

                        if (curso.equals("1")) primeroSmr++;
                        else segundoSmr++;
                    }
                }
            }

            System.out.println();
            System.out.println("En primero de ASIR hay " + primeroAsir + "alumnos.");
            System.out.println("En segundo de ASIR hay " + segundoAsir + "alumnos.");
            System.out.println("En primero de DAM hay " + primeroDam + "alumnos.");
            System.out.println("En segundo de DAM hay " + segundoDam + "alumnos.");
            System.out.println("En primero de SMR hay " + primeroSmr + "alumnos.");
            System.out.println("En segundo de SMR hay " + segundoSmr + "alumnos.");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void apartado3() {

        try {

            File file = new File("input\\ejercicio6\\bbdd.xml");

            // Parsear XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            // Recorrer el DOM
            NodeList items = document.getDocumentElement().getChildNodes();

            int contadorItems = 0;
            Set<String> itemNames = new HashSet<>();
            int contadorClientes = 0;
            int contadorPedidos = 0;
            int contadorProductos = 0;
            boolean mostrarEstructuraCliente = true;
            boolean mostrarEstructuraPedido = true;
            boolean mostrarEstructuraProducto = true;
            List<String> estructuraCliente = new ArrayList<>();
            List<String> estructuraPedido = new ArrayList<>();
            List<String> estructuraProducto = new ArrayList<>();

            for (int i = 0; i < items.getLength(); i++) {

                Node item = items.item(i);

                if (item.getNodeType() == Node.ELEMENT_NODE) {

                    String itemName = item.getNodeName();

                    itemNames.add(itemName);

                    contadorItems++;

                    if (itemName.equals("cliente")) {

                        contadorClientes++;

                        if (mostrarEstructuraCliente) {

                            mostrarEstructuraCliente = false;
                            NodeList hijosCliente = item.getChildNodes();
                            for (int j = 0; j < hijosCliente.getLength(); j++) {

                                Node hijo = hijosCliente.item(j);
                                if (hijo.getNodeType() == Node.ELEMENT_NODE) {

                                    estructuraCliente.add(hijo.getNodeName());
                                }
                            }
                        }

                    } else if (itemName.equals("pedido")) {

                        contadorPedidos++;

                        if (mostrarEstructuraPedido) {

                            mostrarEstructuraPedido = false;
                            NodeList hijosPedido = item.getChildNodes();
                            for (int j = 0; j < hijosPedido.getLength(); j++) {

                                Node hijo = hijosPedido.item(j);
                                if (hijo.getNodeType() == Node.ELEMENT_NODE) {

                                    estructuraPedido.add(hijo.getNodeName());
                                }
                            }
                        }

                    } else if (itemName.equals("producto")) {

                        contadorProductos++;

                        if (mostrarEstructuraProducto) {

                            mostrarEstructuraProducto = false;
                            NodeList hijosProducto = item.getChildNodes();
                            for (int j = 0; j < hijosProducto.getLength(); j++) {

                                Node hijo = hijosProducto.item(j);
                                if (hijo.getNodeType() == Node.ELEMENT_NODE) {

                                    estructuraProducto.add(hijo.getNodeName());
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("En total hay " + contadorItems + " items.");
            System.out.println("Se pueden diferenciar los siguientes items:");
            for (String itemName : itemNames) {

                int numeroItems = 0;

                if (itemName.equals("cliente")) {

                    numeroItems = contadorClientes;

                } else if (itemName.equals("pedido")) {

                    numeroItems = contadorPedidos;

                } else if (itemName.equals("producto")) {

                    numeroItems = contadorProductos;
                }

                System.out.println("\t- " + itemName + " (" + numeroItems + ")");
            }

            System.out.println("Estructura cliente:");
            for (String n : estructuraCliente) {

                System.out.println("\t- " + n);
            }
            System.out.println("Estructura pedido:");
            for (String n : estructuraPedido) {

                System.out.println("\t- " + n);
            }
            System.out.println("Estructura producto:");
            for (String n : estructuraProducto) {

                System.out.println("\t- " + n);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void apartado4() {

        try {

            File file = new File("input\\ejercicio6\\bbdd.xml");

            // Parsear XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            List<Pedido> pedidos = obtenerPedidos(document);
            System.out.println("Pedidos obtenidos: " + pedidos.size());

            List<Cliente> clientes = obtenerClientes(document);
            System.out.println("Clientes obtenidos: " + clientes.size());

            List<Producto> productos = obtenerProductos(document);
            System.out.println("Productos obtenidos: " + productos.size());

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static List<Pedido> obtenerPedidos(Document document) {

        List<Pedido> lista = new ArrayList<>();

        NodeList listaNodosPedido = document.getElementsByTagName("pedido");

        for (int i = 0; i < listaNodosPedido.getLength(); i++)
        {
            Node node = listaNodosPedido.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;

                Pedido pedido = new Pedido(
                        element.getAttribute("id"),
                        Integer.parseInt(element.getElementsByTagName("cliente").item(0).getTextContent()),
                        obtenerProductosDeUnPedido(element),
                        obtenerFechaDeUnPedido(element)
                );

                lista.add(pedido);
            }
        }

        return lista;
    }

    private static List<Integer> obtenerProductosDeUnPedido(Element element) {

        NodeList listaNodosProducto = element.getElementsByTagName("producto");

        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < listaNodosProducto.getLength(); i++) {

            lista.add(Integer.parseInt(listaNodosProducto.item(i).getTextContent()));
        }

        return lista;
    }

    private static Date obtenerFechaDeUnPedido(Element element) {

        Date date = null;

        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            simpleDateFormat.parse(element.getElementsByTagName("fecha").item(0).getTextContent());

        } catch (ParseException e) {

            e.printStackTrace();
        }

        return date;
    }

    public static List<Cliente> obtenerClientes(Document document) {

        List<Cliente> lista = new ArrayList<>();

        NodeList items = document.getElementsByTagName("items").item(0).getChildNodes();

        for (int i = 0; i < items.getLength(); i++) {

            Node node = items.item(i);

            String nombreDelNodo = node.getNodeName();

            if (node.getNodeType() == Node.ELEMENT_NODE && nombreDelNodo.equals("cliente")) {

                Element element = (Element) node;

                Cliente cliente = new Cliente(
                        Integer.parseInt(element.getAttribute("id")),
                        element.getElementsByTagName("nombre").item(0).getTextContent(),
                        element.getElementsByTagName("apellidos").item(0).getTextContent(),
                        element.getElementsByTagName("direccion").item(0).getTextContent()
                );

                lista.add(cliente);
            }
        }

        return lista;
    }

    public static List<Producto> obtenerProductos(Document document) {

        List<Producto> lista = new ArrayList<>();

        NodeList items = document.getElementsByTagName("items").item(0).getChildNodes();

        for (int i = 0; i < items.getLength(); i++) {

            Node node = items.item(i);

            String nombreDelNodo = node.getNodeName();

            if (node.getNodeType() == Node.ELEMENT_NODE && nombreDelNodo.equals("producto")) {

                Element element = (Element) node;

                Producto producto = new Producto(
                        Integer.parseInt(element.getAttribute("id")),
                        element.getElementsByTagName("nombre").item(0).getTextContent(),
                        Double.parseDouble(element.getElementsByTagName("precio").item(0).getTextContent())
                );

                lista.add(producto);
            }
        }

        return lista;
    }
}
