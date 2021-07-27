package softuni.exam.util.impl;

import org.springframework.stereotype.Component;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class XmlParserImpl implements XmlParser {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T fromXml(String path, Class<T> tClass) throws JAXBException, IOException {
        return (T) JAXBContext.newInstance(tClass)
                .createUnmarshaller().unmarshal(new FileReader(path));
    }
}
