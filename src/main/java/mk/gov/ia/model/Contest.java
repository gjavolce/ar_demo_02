/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 *
 * @author Internet
 */
@Entity
@Table(name = "contest")
public class Contest extends BaseObject {
    private String name;
    private String place;
    private int time;
    
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "place")
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
    @Column(name = "time")
    public int getTime()
    {
        return time;
    }
    
    public void setTime(int time){
        this.time=time;
    }
}
