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
    public String showDistributorPage(ModelMap model) {
        return "distributeur";
    }

    @RequestMapping(value = "/addBalance", method = RequestMethod.POST)
    public String addBalance(@Valid UserForm userForm, BindingResult result, ModelMap model) {

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

        try {
            productService.buyProduct(product);
        } catch (NotEnoughStockException | BalanceInsufficientException e) {
            result.rejectValue("id", null, e.getMessage());
            return "distributeur";
        }

        return "redirect:distributeur";
    }

    @ModelAttribute("userForm")
    public UserForm addUserForm() {
        return new UserForm();
    }

    @ModelAttribute("buyForm")
    public BuyForm addBuyForm() {
        return new BuyForm();
    }

    @ModelAttribute("credit")
    public Double addCredit() {
        return userService.getBalance();
    }

    @ModelAttribute("stock")
    public List<Product> addStock() {
        return productService.findAll();
    }
}
