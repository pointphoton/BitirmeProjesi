package org.photon.bitirmeprojesi.web.controller;



import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.photon.bitirmeprojesi.ejb.CategoryFacadeLocal;
import org.photon.bitirmeprojesi.web.entity.Category;

@Named("catCont")
@ViewScoped
public class CategoryController implements  Serializable{

    @EJB(beanName = "CategoryEJB")
    private CategoryFacadeLocal categoryEJB;
     private Category category;

    @PostConstruct
    public void init() {
        category = new Category();
    }

    public void addCategory() {
        System.out.println("added");
     //   category.setDescription(getCategory().getCategoryName()+" description");
        try {
            categoryEJB.create(category);
        } catch (Exception e) {
            //Logging
        }

    }
     public void add25Categories() {
        Category c ;
         for (int i = 101; i < 126; i++) {
             c = new Category();
             c.setCategoryName("Category "+i);
             c.setDescription("Category Desc. "+i);
                try {
            categoryEJB.create(c);
        } catch (Exception e) {
            //Logging
        }
         }
      
     

    }
    
    

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
