/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class Sach325 {
    private int id;
    private String mavach;
    private Dausach325 dausach;

    public Sach325() {
    }

    public Sach325(String mavach) {
        this.mavach = mavach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMavach() {
        return mavach;
    }

    public void setMavach(String mavach) {
        this.mavach = mavach;
    }

    public Dausach325 getDausach() {
        return dausach;
    }

    public void setDausach(Dausach325 dausach) {
        this.dausach = dausach;
    }
    
}
