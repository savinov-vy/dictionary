package ru.savinov.dictionary.backend.soap.xml.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.validation.Schema;
import java.io.StringWriter;
import java.io.Writer;

public class JaxbMarshaller {
    private Marshaller marshalller;

    public JaxbMarshaller(JAXBContext ctx) throws JAXBException {
        marshalller = ctx.createMarshaller();
        marshalller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshalller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshalller.setProperty(Marshaller.JAXB_FRAGMENT, true);
    }

    public void setProperty(String prop, Object value) throws PropertyException{
        marshalller.setProperty(prop, value);
    }

    public synchronized void setSchema(Schema schema) {
        marshalller.setSchema(schema);
    }

    public String marshal(Object instance) throws JAXBException {
        StringWriter sw = new StringWriter();
        marshal(instance, sw);
        return sw.toString();
    }

    public synchronized void marshal(Object instance, Writer writer) throws JAXBException {
        marshalller.marshal(instance, writer);
    }
}
