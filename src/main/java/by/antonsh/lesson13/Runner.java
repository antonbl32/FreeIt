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

public class Runner {
    public static void main(String[] args) {
    checkXML();
      //  saveObjectToXML();
    }
    public static void saveObjectToXML(){
        Computer comp1 = new Computer("1","First", new MotherBoard("Foxconn", 95.5,true),
                new HDD("Hitachi", 55,false),
                new VCard("Nvideo", 255.5,true), 0);
        comp1.setPrice(comp1.getMotherBoard().getPrice() + comp1.getHdd().getPrice() + comp1.getVCard().getPrice());
        JAXBContext jaxbContext = null;
        Marshaller jaxbMarshaller = null;
        try {
            jaxbContext = JAXBContext.newInstance(Computer.class, MotherBoard.class, HDD.class, VCard.class);
            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(comp1, new File("computer.xml"));
            jaxbMarshaller.marshal(comp1,System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public static boolean checkXML(){
        String lang= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String file="computer.xml";
        String schema="computer.xsd";
        SchemaFactory schemaFactory=SchemaFactory.newInstance(lang);
        File schemaLocation=new File(schema);
        try {
            Schema schemaValid=schemaFactory.newSchema(schemaLocation);
            Validator validator=schemaValid.newValidator();
            Source source=new StreamSource(file);
            validator.validate(source);
            System.out.println("Schema valid.");
            return true;
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
