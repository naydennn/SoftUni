package com.example.football.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T fromXml(String path, Class<T> tClass) throws JAXBException, FileNotFoundException;
}
