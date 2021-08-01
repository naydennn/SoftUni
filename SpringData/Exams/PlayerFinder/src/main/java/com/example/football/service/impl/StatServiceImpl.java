package com.example.football.service.impl;

import com.example.football.models.dto.StatSeedRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StatServiceImpl implements StatService {

    private static final String STAT_FILE_PATH = "src/main/resources/files/xml/stats.xml";

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final StatRepository statRepository;
    private final ValidationUtil validationUtil;

    public StatServiceImpl(ModelMapper modelMapper, XmlParser xmlParser, StatRepository statRepository, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.statRepository = statRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STAT_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        StatSeedRootDto statSeedRootDto = xmlParser.fromXml(STAT_FILE_PATH, StatSeedRootDto.class);

        statSeedRootDto.getStats().stream()
                .filter(stat -> {
                    boolean isValid = validationUtil.isValid(stat) &&
                            statRepository.findByPassingAndEnduranceAndShooting(stat.getPassing(),
                                    stat.getEndurance(), stat.getShooting()) == null;

                    sb.append(isValid ? String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                            stat.getShooting(), stat.getPassing(), stat.getEndurance()) : "Invalid Stat")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(stat -> modelMapper.map(stat, Stat.class))
                .forEach(statRepository::save);

        return sb.toString();
    }

    @Override
    public Stat getStat(Long id) {
        return statRepository.findById(id).orElse(null);
    }
}
