package org.photon.bitirmeprojesi.web.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.SQLDelete;

@Entity
@XmlRootElement
public class EmployeeDelivery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deliverySeq")
    @SequenceGenerator(name = "deliverySeq", sequenceName = "EMPLOYEE_DELIVERY_SEQ",initialValue = 1, allocationSize = 1)
    @Column(name = "delivery_id", unique = true, nullable = false)
    private Long deliveryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = OrderDetail.class)
    @JoinColumn(name = "delivery_id")
    private Set<OrderDetail> orderDetails;
     @Column(name = "status",length = 1)
    private String status;

    public EmployeeDelivery() {
    }

    public EmployeeDelivery(Long deliveryId, Employee employee, Set<OrderDetail> orderDetails, String status) {
        this.deliveryId = deliveryId;
        this.employee = employee;
        this.orderDetails = orderDetails;
        this.status = status;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @XmlTransient
    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((deliveryId == null) ? 0 : deliveryId.hashCode());
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
        EmployeeDelivery other = (EmployeeDelivery) obj;
        if (deliveryId == null) {
            if (other.deliveryId != null) {
                return false;
            }
        } else if (!deliveryId.equals(other.deliveryId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmployeeDelivery{" + "deliveryId=" + deliveryId + '}';
    }

}
