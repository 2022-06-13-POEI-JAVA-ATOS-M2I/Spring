package fr.m2i.spring.lesson.mvc.service;

import fr.m2i.spring.lesson.mvc.model.Product;
import fr.m2i.spring.lesson.mvc.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserService userService;

    @Autowired
    public ProductService(ProductRepository productRepository, UserService userService) {
        this.productRepository = productRepository;
        this.userService = userService;

        save(new Product("café", 1d, 5));
        save(new Product("soda", 2d, 5));
        save(new Product("barre céréales", 3d, 5));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> oProduct = productRepository.findById(id);
        return oProduct.get();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void buyProduct(Product product) {

        if (product.getQuantity() <= 0) {
            
        }

        if (userService.getBalance() < product.getPrice()) {

        }

        product.setQuantity(product.getQuantity() - 1);
        userService.decreaseBalance(product.getPrice());
        save(product);
    }

}
