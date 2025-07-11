package net.bousmara.bdccfsmspringmvc.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import net.bousmara.bdccfsmspringmvc.entities.Product;
import net.bousmara.bdccfsmspringmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/user/index")
    public String index(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("productList", products);
        return "products";
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("productList", products);
        return "redirect:/user/index";
    }

    @PostMapping("/admin/delete")
    public String delete(@RequestParam(name = "id") Long id){
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }

    @GetMapping("/admin/newProduct")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new-product";
    }

    @PostMapping("/admin/saveProduct")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) return "new-product";
        productRepository.save(product);
        return "redirect:/admin/newProduct";
    }

    @GetMapping("/notAuthorized")
    public String notAuthorized() {
        return "notAuthorized";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
