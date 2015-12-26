/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.web.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.photon.bitirmeprojesi.ejb.CategoryFacadeLocal;
import org.photon.bitirmeprojesi.ejb.ProductFacadeLocal;
import org.photon.bitirmeprojesi.web.entity.Category;
import org.photon.bitirmeprojesi.web.entity.Product;

@Named("proCont")
@ViewScoped
public class ProductController implements Serializable {

    @EJB(beanName = "ProductEJB")
    private ProductFacadeLocal productEJB;

    @EJB(beanName = "CategoryEJB")
    private CategoryFacadeLocal categoryEJB;
    private Product product;
    private Category proCategory;
    private List<Category> categoryList;
    private String isActive;

    @PostConstruct
    public void init() {
        product = new Product();
        proCategory = new Category();

        categoryList = categoryEJB.findAll();
        Category c = categoryEJB.find(12L);
        System.out.println(c.getCategoryId() + " " + c.getCategoryName());
        System.out.println(categoryList.size() + " ");
        categoryList.stream().forEach((cate) -> {
            System.out.println(cate.getCategoryName());
        });

    }

    public void addProduct() {
        System.out.println("procat " + proCategory);
        product.setCategory(proCategory);
        System.out.println(product + "  " + product.getName());
        try {
            productEJB.create(product);
        } catch (Exception e) {

        }

    }

    public void add25Products() {
        Product p;
        for (int i = 1001; i < 1026; i++) {
            p = new Product();
            p.setName("Product " + i);
            p.setProDescription("Product Desc. " + i);
            p.setCurrentPrice(new BigDecimal((i * 5)));
            p.setIsActive("Y");
            for (Category c : categoryList) {
                if (c.getCategoryId() == (i - 1000)) {
                    p.setCategory(c);
                }

            }
            try {
                productEJB.create(p);
            } catch (Exception e) {
                //Logging
            }

        }

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Category getProCategory() {
        return proCategory;
    }

    public void setProCategory(Category proCategory) {
        this.proCategory = proCategory;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

}
