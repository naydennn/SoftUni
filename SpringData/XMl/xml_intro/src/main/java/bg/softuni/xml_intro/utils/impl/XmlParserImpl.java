package bg.softuni.xml_intro.utils.impl;

import bg.softuni.xml_intro.utils.XmlParser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class XmlParserImpl implements XmlParser {

    private JAXBContext jaxbContext;

    @Override
    @SuppressWarnings("unchecked")
    public <T> T fromFile(String path,Class<T> tClass) throws JAXBException, FileNotFoundException {

        return (T) JAXBContext.newInstance(tClass)
                .createUnmarshaller()
                .unmarshal(new FileReader(path));

    }

    @Override
    public <T> void toFile(String path, T entity) throws FileNotFoundException, JAXBException {
        Marshaller marshaller = JAXBContext.newInstance(entity.getClass())
                .createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(entity, new File(path));
    }
}
