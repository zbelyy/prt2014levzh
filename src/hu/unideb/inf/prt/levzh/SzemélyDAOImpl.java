/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.unideb.inf.prt.levzh;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author zbocskay
 */
public class SzemélyDAOImpl implements SzemélyDAO{

    @Override
    public Személy getSzemélyById(String id) {
        File szemelyXml = new File("C:\\Users\\zbocskay.TS-EU\\Documents\\NetBeansProjects\\prt2014levzh\\people.xml");
        //List<Személy> sz = null; 
        //Személy sz = new Személy(id);
        
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Személy.class);
 
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            
            Személy személy = (Személy) jaxbUnmarshaller.unmarshal(szemelyXml);
            //sz = (Személy) jaxbUnmarshaller.unmarshal(szemelyXml);
            //sz = szemely.getId();
            
            return new Személy(személy.getId(), személy.getVezetéknév(), személy.getKeresztnév(), személy.getÉletkor(), személy.getCím(), személy.státusz.DIÁK);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Személy> getÖsszesSzemélyAdottStátusszal(String státusz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    


    
}
