package org.photon.bitirmeprojesi.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class OrderDetail implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderDetailSeq")
    @SequenceGenerator(name = "orderDetailSeq", sequenceName = "ORDER_DETAIL_SEQ",initialValue = 1, allocationSize = 1)
    @Column(name = "order_detail_id", unique = true, nullable = false)
    private Long orderDetailId;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Order.class)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Bucket.class)
    @JoinColumn(name = "bucket_id", referencedColumnName = "bucket_id")
    private Bucket bucket;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = EmployeeDelivery.class)
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id")
    private EmployeeDelivery employeeDelivery;
    @Column(name = "unit_count")
    private Integer unitCount;
    //@DecimalMin("0")
    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    public OrderDetail() {
    }

    public OrderDetail(Long orderDetailId, Order order, Product product, Bucket bucket, EmployeeDelivery employeeDelivery, Integer unitCount, BigDecimal unitPrice) {
        this.orderDetailId = orderDetailId;
        this.order = order;
        this.product = product;
        this.bucket = bucket;
        this.employeeDelivery = employeeDelivery;
        this.unitCount = unitCount;
        this.unitPrice = unitPrice;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public EmployeeDelivery getEmployeeDelivery() {
        return employeeDelivery;
    }

    public void setEmployeeDelivery(EmployeeDelivery employeeDelivery) {
        this.employeeDelivery = employeeDelivery;
    }

    public Integer getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Integer unitCount) {
        this.unitCount = unitCount;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
 
   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderDetailId == null) ? 0 : orderDetailId.hashCode());
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
        OrderDetail other = (OrderDetail) obj;
        if (orderDetailId == null) {
            if (other.orderDetailId != null) {
                return false;
            }
        } else if (!orderDetailId.equals(other.orderDetailId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "orderDetailId=" + orderDetailId + '}';
    }

}
