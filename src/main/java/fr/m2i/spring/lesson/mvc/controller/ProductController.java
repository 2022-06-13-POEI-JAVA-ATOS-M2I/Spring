package fr.m2i.spring.lesson.mvc.controller;

import fr.m2i.spring.lesson.mvc.form.ProductForm;
import fr.m2i.spring.lesson.mvc.model.Product;
import fr.m2i.spring.lesson.mvc.model.User;
import fr.m2i.spring.lesson.mvc.service.IProductService;
import fr.m2i.spring.lesson.mvc.service.IUserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/provider")
public class ProductController {

    private final IUserService userService;
    private final IProductService productService;

    @Autowired
    public ProductController(IUserService userService, IProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping({"/", "/products"})
    public String showProductsPage(ModelMap model) {
        model.addAttribute("productFrom", new ProductForm());
        return "provider/products";
    }

    @GetMapping("/addProduct")
    public String showAddProductPage(ModelMap model) {
        model.addAttribute("productFrom", new ProductForm());
        return "provider/save-products";
    }

    @GetMapping(value = "/updateProduct/{id}")
    public String showUpdateProduct(@PathVariable("id") Long id, ModelMap model) {

        if (id == null || id < 1) {
            model.addAttribute("error", "Veuillez entrer un id produit valide");
            return "provider/products";
        }

        Product product = productService.findById(id);

        if (product == null) {
            model.addAttribute("error", "Le produit n'existe pas");
            return "provider/products";
        }

        ProductForm productForm = new ProductForm();
        productForm.setId(id);
        productForm.setName(product.getName());
        productForm.setQuantity(product.getQuantity());
        productForm.setPrice(product.getPrice());

        model.put("productFrom", productForm);

        return "provider/save-products";
    }

    @GetMapping(value = "/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id, ModelMap model,
            @AuthenticationPrincipal User user) {

        if (id == null || id < 1) {
            model.addAttribute("error", "Veuillez entrer un id produit valide");
            return "provider/products";
        }

        Product product = productService.findById(id);

        if (product == null) {
            model.addAttribute("error", "Le produit n'existe pas");
            return "provider/products";
        }

        try {
            productService.delete(product);
        } catch (Exception e) {
            model.addAttribute("error", "Une erreur est survenue lors de la suppression du produit");
            return "provider/products";
        }

        return "redirect:/provider/products";
    }

    @PostMapping(value = "/updateProduct")
    public String updateProduct(@Valid ProductForm productForm,
            BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "provider/save-products";
        }
        
        return "redirect:/provider/products";
    }

    @PostMapping(value = "/addProduct")
    public String addProduct(@Valid ProductForm productForm,
            BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "provider/save-products";
        }
        
        return "redirect:/provider/products";
    }

    @ModelAttribute("stock")
    public List<Product> addStock() {
        return productService.findAll();
    }

}
