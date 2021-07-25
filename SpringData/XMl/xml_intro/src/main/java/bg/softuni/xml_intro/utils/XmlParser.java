package bg.softuni.xml_intro.utils;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T fromFile(String path, Class<T> tClass) throws JAXBException, FileNotFoundException;

    <T> void toFile(String path, T entity) throws FileNotFoundException, JAXBException;
}
