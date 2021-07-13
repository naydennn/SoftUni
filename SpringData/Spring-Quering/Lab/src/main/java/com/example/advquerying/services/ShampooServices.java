package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooServices {

    List<String> findAllBySizeOrderById(Size size);

    List<String> findAllBySizeOrLabel_IdOrderByPrice(Size size, Long price);

    List<String> findAllByPriceIsGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceIsLessThan(BigDecimal price);

}
