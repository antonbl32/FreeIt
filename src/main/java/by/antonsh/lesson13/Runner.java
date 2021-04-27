package by.antonsh.lesson13;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("To save object set 1");
        System.out.println(("Check validate to schema set 2"));
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                saveObjectToXML();
                break;
            case 2:
                checkXML();
                break;
        }
    }

    public static void saveObjectToXML() {
        Computer comp1 = new Computer("1", "First", new MotherBoard("Foxconn", 95.5, true),
                new HDD("Hitachi", 55, false),
                new VCard("Nvideo", 255.5, true), 0);
        comp1.setAllPrice();
        Computer comp2 = new Computer("2", "Second", new MotherBoard("Malta", 91.5, true),
                new HDD("Toshiba", 61, false),
                new VCard("ATI", 215.9, true), 0);
        comp2.setAllPrice();
        Computers allComp = new Computers();
        allComp.getList().add(comp1);
        allComp.getList().add(comp2);
        JAXBContext jaxbContext;
        Marshaller jaxbMarshaller;
        try {
            jaxbContext = JAXBContext.newInstance(Computers.class, Computer.class, MotherBoard.class, HDD.class, VCard.class);
            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "computers.xsd");
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(allComp, new File("computers.xml"));
            jaxbMarshaller.marshal(allComp, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void checkXML() {
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String file = "computers.xml";
        String schema = "computers.xsd";
        SchemaFactory schemaFactory = SchemaFactory.newInstance(lang);
        File schemaLocation = new File(schema);
        try {
            Schema schemaValid = schemaFactory.newSchema(schemaLocation);
            Validator validator = schemaValid.newValidator();
            Source source = new StreamSource(file);
            validator.validate(source);
            System.out.println("Schema valid.");
        } catch (SAXException e) {
            System.out.println("Not valid");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Not valid");
            e.printStackTrace();
        }
    }
}
