package org.photon.bitirmeprojesi.web.entity;




import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity 
public class Category implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySeq")
    @SequenceGenerator( name = "categorySeq", sequenceName = "CATEGORY_SEQ",initialValue = 1, allocationSize = 1)
    @Column(name = "category_id", unique = true, nullable = false)
    private Long categoryId;
     @Column(name = "category_name", length = 55)
    private String categoryName;
    @Column(name = "description", length = 150)
    private String description;    
    @OneToMany(fetch = FetchType.LAZY, cascade =CascadeType.ALL ,targetEntity = Product.class)
    @JoinColumn(name = "cat_id")  
    private Set<Product> products;

    public Category() {
    }

    public Category(String categoryName, String description, Set<Product> products) {
        this.categoryName = categoryName;
        this.description = description;
        this.products = products;
    }
    

    public Category(Long categoryId, String categoryName, String description, Set<Product> products) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.products = products;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return String.valueOf(categoryId);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.categoryId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (!Objects.equals(this.categoryId, other.categoryId)) {
            return false;
        }
        return true;
    }
    
    
   
}
