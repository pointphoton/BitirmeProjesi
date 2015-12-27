/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.photon.bitirmeprojesi.web.entity.util;


public enum Role {
    
       ADMIN("admin") ,MODERATOR("moderator") ,OPERATOR("operator"), DEVELOPER("developer") , TESTER("tester"),USER("user") ;

       private String value ;
       
       private Role(String value)
       {this.value = value;
       }
   
    public String getValue() {
    return this.value ;
    }
       
       
}

	