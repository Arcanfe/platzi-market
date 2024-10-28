package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Product controller")   // Anotacion para swagger, documentacion del documento
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Get service to obtain all products") // Anotacion para documentacion de swagger
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId) {
        // return ResponseEntity.of(productService.getProduct(productId)); // Alternativa de respuesta
        return productService.getProduct(productId)
                .map(prod -> new ResponseEntity<>(prod, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId)
                .map(prod -> new ResponseEntity<>(prod, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Post service to create products") // Anotacion para documentacion de swagger
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
        //return new ResponseEntity(this.productService.delete(productId)
        //        ? HttpStatus.OK
        //        : HttpStatus.NOT_FOUND); // Alternativa de respuesta
        if(productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}
