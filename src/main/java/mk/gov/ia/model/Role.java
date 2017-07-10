/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author korisnik
 */
@Entity
@Table(name = "organization_role")
public class Role extends BaseObject{

    
    private String name;
    private String roleCode;
    private Role reportsTo;
    private Unit organizationalUnit;
    private String fullRoleName;

    

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "role_code")
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @OneToOne
    public Role getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Role reportsTo) {
        this.reportsTo = reportsTo;
    }

    @OneToOne
    public Unit getOrganizationalUnit() {
        return organizationalUnit;
    }

    public void setOrganizationalUnit(Unit organizationalUnit) {
        this.organizationalUnit = organizationalUnit;
    }
    
    @Transient
    public String getFullRoleName() {
        return "("+this.roleCode+") " + this.name;
    }

}
