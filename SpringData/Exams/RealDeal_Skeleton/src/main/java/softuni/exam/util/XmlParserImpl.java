package softuni.exam.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.*;
import java.io.*;

@Component
public class XmlParserImpl implements XmlParser {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T fromXml(String path, Class<T> tClass) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(tClass);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (T) unmarshaller.unmarshal(new FileReader(path));
    }
}
