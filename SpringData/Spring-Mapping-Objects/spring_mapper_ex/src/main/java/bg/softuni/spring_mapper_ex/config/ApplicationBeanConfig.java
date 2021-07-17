package bg.softuni.spring_mapper_ex.config;

import bg.softuni.spring_mapper_ex.models.dtos.AddGameDto;
import bg.softuni.spring_mapper_ex.models.entities.Game;
import org.modelmapper.*;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(AddGameDto.class, Game.class)
                .addMappings(mapper -> mapper.map(AddGameDto::getThumbnailUrl, Game::setImageThumbnail));

        return modelMapper;
    }

    @Bean
    public BufferedReader reader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
