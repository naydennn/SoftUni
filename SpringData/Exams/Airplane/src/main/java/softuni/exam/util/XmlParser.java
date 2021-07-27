package softuni.exam.util;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface XmlParser {

    <T> T fromXml(String path, Class<T> tClass) throws JAXBException, IOException;
}
