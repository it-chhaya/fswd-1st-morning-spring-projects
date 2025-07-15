package kh.edu.cstad.webmvc.controller;

import kh.edu.cstad.webmvc.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/product")
public class ProductController {

    //@RequestMapping(value = "/product", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String viewProduct(@PathVariable String id,
                              @RequestParam(required = false, defaultValue = "all") String category,
                              @RequestParam(required = false, defaultValue = "0") Integer rate,
                              ModelMap modelMap) {

        Product product = new Product();
        product.setId(id);
        product.setCategory(category);
        product.setRate(rate);

        modelMap.addAttribute("product", product);

        return "product";
    }

}
