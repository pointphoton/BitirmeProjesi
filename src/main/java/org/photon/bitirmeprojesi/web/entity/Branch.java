package org.photon.bitirmeprojesi.web.entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branchSeq")
    @SequenceGenerator(name = "branchSeq", sequenceName = "BRANCH_SEQ",initialValue = 1, allocationSize = 1)
    @Column(name = "branch_id", unique = true, nullable = false)
    private Long branchId;
    @Column(name = "name", length = 45)
    private String name;
    @Temporal(TemporalType.TIME)
    @Column(name = "open_hour", length = 4)
    private Date openHour;
    @Temporal(TemporalType.TIME)
    @Column(name = "close_hour", length = 4)
    private Date closeHour;
    @Column(name = "manager_name", length = 45)
    private String managerName;

    public Branch() {
    }

    public Branch(Long branchId, String name, Date openHour, Date closeHour, String managerName) {
        this.branchId = branchId;
        this.name = name;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.managerName = managerName;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Date openHour) {
        this.openHour = openHour;
    }

    public Date getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(Date closeHour) {
        this.closeHour = closeHour;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
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
        Branch other = (Branch) obj;
        if (branchId == null) {
            if (other.branchId != null) {
                return false;
            }
        } else if (!branchId.equals(other.branchId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Branch{" + "branchId=" + branchId + '}';
    }

}
