package org.photon.bitirmeprojesi.web.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.photon.bitirmeprojesi.web.entity.util.PaymentStatus;
import org.photon.bitirmeprojesi.web.entity.util.PaymentType;

@Entity
@Table(name = "orders", schema = "bproje")
@XmlRootElement
public class Order implements Serializable  {

 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSeq")
    @SequenceGenerator(schema = "bproje",name = "orderSeq", sequenceName = "ORDER_SEQ", initialValue = 1,allocationSize = 1)
    @Column(name = "order_id", unique = true, nullable = false)
    private Long orderId;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    @JoinTable(name = "customer_orders", joinColumns = {
        @JoinColumn(name = "order_id",  nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "customer_id",  nullable = false, updatable = false)})
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Address.class)
    @JoinColumn(name = "address_id")
    private Address address;
     @Column(name = "status",length = 1)
    private String status;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;
    @Column(name = "promo_code_id", length = 45)
    private String promoCodeId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time", length = 19)
    private Date startTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time", length = 19)
    private Date endTime;
    //@DecimalMin("0")
    @Column(name = "cost", precision = 10, scale = 2)
    private BigDecimal cost;
    @OneToMany(mappedBy = "order", targetEntity = OrderDetail.class)
    private Set<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(Long orderId, Customer customer, Address address, String status, PaymentType paymentType, PaymentStatus paymentStatus, String promoCodeId, Date startTime, Date endTime, BigDecimal cost, Set<OrderDetail> orderDetails) {
        this.orderId = orderId;
        this.customer = customer;
        this.address = address;
        this.status = status;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.promoCodeId = promoCodeId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cost = cost;
        this.orderDetails = orderDetails;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPromoCodeId() {
        return promoCodeId;
    }

    public void setPromoCodeId(String promoCodeId) {
        this.promoCodeId = promoCodeId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }


    @XmlTransient
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
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
        Order other = (Order) obj;
        if (orderId == null) {
            if (other.orderId != null) {
                return false;
            }
        } else if (!orderId.equals(other.orderId)) {
            return false;
        }
        return true;
    }

    /*
     public String findOrderSummary(){
     StringBuilder sb = new StringBuilder();
     for(OrderDetails od : this.getOrderDetails()){
     if(od.getProduct() != null)
     sb.append(od.getUnitCount()).append( " x ").append(od.getProduct().getName());
     else if(od.getBucket() != null )
     sb.append(od.getUnitCount()).append( " x ").append(od.getBucket().getName());
			
     sb.append("   ");
     }
     return sb.toString();
     }
	
     */

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + '}';
    }
}
