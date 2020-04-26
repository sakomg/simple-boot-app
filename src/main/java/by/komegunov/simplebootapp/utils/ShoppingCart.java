package by.komegunov.simplebootapp.utils;

import by.komegunov.simplebootapp.entities.Product;
import by.komegunov.simplebootapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode =  ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
    private List<Product> productList;

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProductList() {
        return productList;
    }

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
    }

    public void addProductById(Long id) {
        Product product = productService.getProductById(id);
        productList.add(product);
    }
}
