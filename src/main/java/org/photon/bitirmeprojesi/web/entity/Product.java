package org.photon.bitirmeprojesi.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "OurProduct")
@SQLDelete(sql = "UPDATE testfd.ourproduct SET is_active = 'N' WHERE product_id = ?")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeq")
    @SequenceGenerator(name = "productSeq", sequenceName = "PRODUCT_SEQ",initialValue = 1, allocationSize = 1)
    @Column(name = "product_id", unique = true, nullable = false)
    private Long productId;
    @Column(name = "pro_name", length = 45)
    private String name;
    @Column(name = "pro_description", length = 150)
    private String proDescription;    
  
    @ManyToOne(fetch = FetchType.LAZY,cascade =CascadeType.ALL , targetEntity = Category.class)
  @JoinColumn(name = "cat_id")
     private Category category;
    
     @Column(name = "is_active", length = 1)
    private String isActive;
  //  @DecimalMin("0")
    @Column(name = "current_price", precision = 10, scale = 2)
    private BigDecimal currentPrice;
    @Column(name = "last_version")
    private Integer lastVersion;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Bucket.class)
    @JoinTable(name = "product_buckets", joinColumns = {
    @JoinColumn(name = "product_id",  nullable = false, updatable = false)}, inverseJoinColumns = {
    @JoinColumn(name = "bucket_id",  nullable = false, updatable = false)})
    private Bucket bucket;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = ProductHistory.class)
    @JoinColumn(name = "product_id")
    private Set<ProductHistory> productHistorySet;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = OrderDetail.class)
    @JoinColumn(name = "product_id")
    private Set<OrderDetail> orderDetails;

    public Product() {
    }

    public Product(Long productId, String name, String proDescription, Category category, String isActive, BigDecimal currentPrice, Integer lastVersion, Bucket bucket, Set<ProductHistory> productHistorySet, Set<OrderDetail> orderDetails) {
        this.productId = productId;
        this.name = name;
        this.proDescription = proDescription;
        this.category = category;
        this.isActive = isActive;
        this.currentPrice = currentPrice;
        this.lastVersion = lastVersion;
        this.bucket = bucket;
        this.productHistorySet = productHistorySet;
        this.orderDetails = orderDetails;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Integer getLastVersion() {
        return lastVersion;
    }

    public void setLastVersion(Integer lastVersion) {
        this.lastVersion = lastVersion;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public Set<ProductHistory> getProductHistorySet() {
        return productHistorySet;
    }

    public void setProductHistorySet(Set<ProductHistory> productHistorySet) {
        this.productHistorySet = productHistorySet;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

  
    

  


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        if (productId == null) {
            if (other.productId != null) {
                return false;
            }
        } else if (!productId.equals(other.productId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + '}';
    }

 

}
