package bg.softuni.xml_intro.services.impl;

import bg.softuni.xml_intro.models.dtos.seed.ProductSeedRootDto;
import bg.softuni.xml_intro.models.dtos.view.ProductViewRootDto;
import bg.softuni.xml_intro.models.dtos.view.ProductWithRangeViewDto;
import bg.softuni.xml_intro.models.entities.Product;
import bg.softuni.xml_intro.repositories.ProductRepository;
import bg.softuni.xml_intro.services.CategoryService;
import bg.softuni.xml_intro.services.ProductService;
import bg.softuni.xml_intro.services.UserService;
import bg.softuni.xml_intro.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, ProductRepository productRepository, UserService userService, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedData(ProductSeedRootDto productSeedRootDto) {

        if (productRepository.count() == 0) {
            productSeedRootDto.getProducts()
                    .stream()
                    .filter(validationUtil::isValid)
                    .map(productSeedDto -> {
                        Product product = modelMapper.map(productSeedDto, Product.class);

                        product.setSeller(userService.getRandomUser());
                        if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {
                            product.setBuyer(userService.getRandomUser());
                        }

                        product.setCategories(categoryService.getRandomCategories());
                        return product;
                    })
                    .forEach(productRepository::save);
        }
    }

    @Override
    public ProductViewRootDto getAllProductsInRange() {
        ProductViewRootDto productViewRootDto = new ProductViewRootDto();

        productViewRootDto.setProducts(productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(BigDecimal.valueOf(500L),
                        BigDecimal.valueOf(1000L))
                .stream()
                .map(product -> {
                    ProductWithRangeViewDto viewDto = modelMapper.map(product, ProductWithRangeViewDto.class);

                    viewDto.setSeller(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());

                    return viewDto;
                })
                .collect(Collectors.toList()));

        return productViewRootDto;
    }
}


