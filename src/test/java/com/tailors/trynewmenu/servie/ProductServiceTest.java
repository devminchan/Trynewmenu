package com.tailors.trynewmenu.servie;

import com.tailors.trynewmenu.domain.product.Product;
import com.tailors.trynewmenu.domain.product.ProductRepository;
import com.tailors.trynewmenu.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void productCrud() {

    }
}