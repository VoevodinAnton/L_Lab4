package com.example.L_Lab4;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.Serializable;

@Named
@SessionScoped
@XmlRootElement(name = "concatenation")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class SumOperationBean implements Serializable {
    private double a;
    private double b;
    private double result;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getResult() {
        result = a + b;
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String writeToXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(SumOperationBean.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Store XML to File
            File file = new File("C:\\Users\\Антон\\IdeaProjects\\L_Lab4\\src\\main\\resources\\sumOperationResult.xml");

            //Writes XML file to file-system
            jaxbMarshaller.marshal(this, file);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return "result";
    }
}
