package org.photon.bitirmeprojesi.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;

@Entity
public class Bucket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bucketSeq")
    @SequenceGenerator(name = "bucketSeq", sequenceName = "BUCKET_SEQ",initialValue = 1, allocationSize = 1)
    @Column(name = "bucket_id", unique = true, nullable = false)
    private Long bucketId;
    @Column(name = "name", length = 45)
    private String name;
   // @DecimalMin("0")
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;
    @Column(name = "current_version")
    private Integer currentVersion;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = OrderDetail.class)
    private Set<OrderDetail> orderDetails;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bucket", targetEntity = Product.class)
    private Set<Product> products;

    public Bucket() {
    }

    public Bucket(Long bucketId, String name, BigDecimal price, Integer currentVersion, Set<OrderDetail> orderDetails, Set<Product> products) {
        this.bucketId = bucketId;
        this.name = name;
        this.price = price;
        this.currentVersion = currentVersion;
        this.orderDetails = orderDetails;
        this.products = products;
    }

    public Long getBucketId() {
        return bucketId;
    }

    public void setBucketId(Long bucketId) {
        this.bucketId = bucketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(Integer currentVersion) {
        this.currentVersion = currentVersion;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bucketId == null) ? 0 : bucketId.hashCode());
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
        Bucket other = (Bucket) obj;
        if (bucketId == null) {
            if (other.bucketId != null) {
                return false;
            }
        } else if (!bucketId.equals(other.bucketId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bucket{" + "bucketId=" + bucketId + '}';
    }

}
