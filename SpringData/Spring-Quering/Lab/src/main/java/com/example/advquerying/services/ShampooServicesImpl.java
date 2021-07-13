package com.example.advquerying.services;

import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShampooServicesImpl implements ShampooServices {

    private final ShampooRepository shampooRepository;

    public ShampooServicesImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<String> findAllBySizeOrderById(Size size) {
        return shampooRepository.findAllBySizeOrderById(size)
                .stream().map(shampoo -> String.format("%s %s %.2flv", shampoo.getBrand(),
                        shampoo.getSize().name(), shampoo.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBySizeOrLabel_IdOrderByPrice(Size size, Long price) {
        return shampooRepository.findAllBySizeOrLabel_IdOrderByPrice(size, price)
                .stream().map(shampoo -> String.format("%s %s %.2flv", shampoo.getBrand(),
                        shampoo.getSize().name(), shampoo.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllByPriceIsGreaterThanOrderByPriceDesc(BigDecimal price) {
        return shampooRepository.findAllByPriceIsGreaterThanOrderByPriceDesc(price)
                .stream().map(shampoo -> String.format("%s %s %.2flv", shampoo.getBrand(),
                        shampoo.getSize().name(), shampoo.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public int countAllByPriceIsLessThan(BigDecimal price) {
        return shampooRepository.countAllByPriceIsLessThan(price);
    }
}
