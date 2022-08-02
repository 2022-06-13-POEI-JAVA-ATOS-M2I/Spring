package fr.m2i.spring.lesson.mvc.service;

import fr.m2i.spring.lesson.mvc.exception.BalanceInsufficientException;
import fr.m2i.spring.lesson.mvc.exception.NotEnoughStockException;
import fr.m2i.spring.lesson.mvc.model.Product;
import fr.m2i.spring.lesson.mvc.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

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

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> oProduct = productRepository.findById(id);
        return oProduct.orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void buyProduct(Product product) throws NotEnoughStockException, BalanceInsufficientException {

        if (product.getQuantity() <= 0) {
            throw new NotEnoughStockException();
        }

        if (userService.getBalance() < product.getPrice()) {
            throw new BalanceInsufficientException();
        }

        product.setQuantity(product.getQuantity() - 1);
        userService.decreaseBalance(product.getPrice());
        save(product);
    }

}
