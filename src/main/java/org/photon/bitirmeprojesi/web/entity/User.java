/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.web.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import org.photon.bitirmeprojesi.web.entity.util.Role;

@Entity
public class User implements Serializable{
    
       @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    @SequenceGenerator(name = "userSeq", sequenceName = "USER_SEQ",initialValue = 1, allocationSize = 1)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long userId;
    @Column(name = "name", length = 45)
    private String name;
      @Column(name = "password", length = 45)
    private String password;
         @Column(name = "userName", length = 45)
    private String userName;
        @Column(name = "email", length = 90)
    private String email;
      @Enumerated(EnumType.STRING)
    @Column(name = "role")
      private Role role;

    public User() {
    }

    public User(String name, String password, String userName, String email, Role role) {
        this.name = name;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.role = role;
    }

 @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
        User other = (User) obj;
        if (userId == null) {
            if (other.userId != null) {
                return false;
            }
        } else if (!userId.equals(other.userId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + userId + '}';
    }

    
      
    
}
