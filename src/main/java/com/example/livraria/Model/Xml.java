package com.example.livraria.Model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class Xml {

    private Document doc;

    public Xml(String caminho) {
        try {
            File docXML = new File(caminho);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(docXML); //Retorna um Object da leitura do XML
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String retornarDoc(Node docXML) {
        String xml = null;
        try {
            TransformerFactory tfFactory = TransformerFactory.newInstance();
            Transformer transformer = tfFactory.newTransformer();
            DOMSource docOrigem = new DOMSource(docXML);

            ByteArrayOutputStream fluxoSaida = new ByteArrayOutputStream();

            StreamResult saida = new StreamResult(fluxoSaida);
            transformer.transform(docOrigem, saida);
            xml = fluxoSaida.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }

    public String listarTodos() {
        //NodeList nodeList = doc.getElementsByTagName("titulo");
        return retornarDoc(doc);
    }//todos

    public String pesquisaTitulo(String titulo) {
        NodeList nodeList = doc.getElementsByTagName("titulo");

        for (int i = (nodeList.getLength() - 1); i >= 0; i--) {
            if (!nodeList.item(i).getFirstChild().getNodeValue().equals(titulo)) {
                nodeList.item(i).getParentNode().getParentNode().removeChild(nodeList.item(i).getParentNode());
            }
        }//for

        return retornarDoc(doc);
    }//pesTitulo

    public String pesquisaCateoria(String texto) {
        NodeList nodeList = doc.getElementsByTagName("livro");

        for (int i = (nodeList.getLength() - 1); i >= 0; i--) {
            String textoPesquisado = nodeList.item(i).getAttributes().getNamedItem("categoria").getNodeValue();

            if (!textoPesquisado.equals(texto)) {
                nodeList.item(i).getParentNode().removeChild(nodeList.item(i));

            }
        }//for

        return retornarDoc(doc);
    }//pesCategoria

    public String pesquisaAutor(String textoPesquisado) {
        NodeList nodeList = doc.getElementsByTagName("livro");

        for (int i = (nodeList.getLength() - 1); i >= 0; i--) {
            int qt =0;
            Element listaAutor = (Element) nodeList.item(i);
            NodeList autores = listaAutor.getElementsByTagName("autor");
            for (int x = 0; x < autores.getLength(); x++) {
                if (autores.item(x).getFirstChild().getNodeValue().equals(textoPesquisado)){
                    qt++;
                }
            }

            if (qt==0) {
                nodeList.item(i).getParentNode().removeChild(nodeList.item(i));
            }
        }//for

        return retornarDoc(doc);
    }//pesAutor

    public String pesquisaAno(String operador, int ano) {
        NodeList nodeList = doc.getElementsByTagName("ano");

        for (int i = (nodeList.getLength() - 1); i >= 0; i--) {
            int intNodeValue = Integer.parseInt(nodeList.item(i).getFirstChild().getNodeValue());

            switch (operador) {
                case "igual":
                    if (intNodeValue != ano) {
                        nodeList.item(i).getParentNode().getParentNode().removeChild(nodeList.item(i).getParentNode());
                    }
                    break;
                case "menor":
                    if (intNodeValue >= ano) {
                        nodeList.item(i).getParentNode().getParentNode().removeChild(nodeList.item(i).getParentNode());
                    }
                    break;
                case "maior":
                    if (intNodeValue <= ano) {
                        nodeList.item(i).getParentNode().getParentNode().removeChild(nodeList.item(i).getParentNode());
                    }
                    break;
                default:
                    nodeList.item(i).getParentNode().getParentNode().removeChild(nodeList.item(i).getParentNode());
                    break;
            }
        }
        return retornarDoc(doc);
    }


  /*  public static void main(String[] args) {
        ManipulaXML teste = new ManipulaXML("src/main/webapp/livros.xml");

        System.out.println(teste.pesquisaAutor("Erik T. Ray"));

    }//main
   */


}
