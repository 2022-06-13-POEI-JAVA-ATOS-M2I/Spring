package fr.m2i.spring.lesson.mvc.controller;

import fr.m2i.spring.lesson.mvc.exception.BalanceInsufficientException;
import fr.m2i.spring.lesson.mvc.exception.NotEnoughStockException;
import fr.m2i.spring.lesson.mvc.form.BuyForm;
import fr.m2i.spring.lesson.mvc.form.UserForm;
import fr.m2i.spring.lesson.mvc.model.Product;
import fr.m2i.spring.lesson.mvc.service.IProductService;
import fr.m2i.spring.lesson.mvc.service.IUserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DistributeurController {

    private final IUserService userService;
    private final IProductService productService;

    @Autowired
    public DistributeurController(IUserService userService, IProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/distributeur")
    //@RequestMapping(value = "/distributeur", method = RequestMethod.GET)
    public String showDistributorPage(ModelMap model) {
        //model.addAttribute("userForm", new UserForm());

        return "distributeur";
    }

    @RequestMapping(value = "/addBalance", method = RequestMethod.POST)
    public String addBalance(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "distributeur";
        }

        userService.addBalance(userForm.getBalance());

        return "redirect:distributeur";
    }

    @RequestMapping(value = "/buyProduct", method = RequestMethod.POST)
    public String buyProduct(@ModelAttribute("buyForm") @Valid BuyForm buyForm, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "distributeur";
        }

        Product product = productService.findById(buyForm.getId());

        if (product == null) {
            result.rejectValue("id", null, "Le produit n'existe pas");
            return "distributeur";
        }
//
//        
//        if (product.getQuantity() <= 0) {
//            result.rejectValue("id", null, "Stock insuffisant");
//        }
//
//        if (userService.getBalance() < product.getPrice()) {
//            result.rejectValue("id", null, "Pas assez de crédit");
//        }
//
//        product.setQuantity(product.getQuantity() - 1);
//        userService.decreaseBalance(product.getPrice());
//        productService.save(product);
        
        
        
        try {
            productService.buyProduct(product);
        } catch (NotEnoughStockException | BalanceInsufficientException e) {
            result.rejectValue("id", null, e.getMessage());
            return "distributeur";
        }


        return "redirect:distributeur";
    }

    // Equivalent de model.addAttribute("userForm", new UserForm());
    @ModelAttribute("userForm")
    public UserForm addUserForm() {
        return new UserForm();
    }

    // Equivalent de model.addAttribute("buyForm", new BuyForm());
    @ModelAttribute("buyForm")
    public BuyForm addBuyForm() {
        return new BuyForm();
    }

    @ModelAttribute("credit")
    public Double addCredit() {
        return userService.getBalance();
    }

    // Equivalent de model.addAttribute("stock", productService.findAll());
    @ModelAttribute("stock")
    public List<Product> addStock() {
        return productService.findAll();
    }
}
