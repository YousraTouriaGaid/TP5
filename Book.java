/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstorermi;

import java.io.Serializable;


public class Book implements Serializable{
    private static final long serialVersionUID = 12351313553L;
    private String title;
    private String code;
    private double qty;

    
    public Book(String code){
        this.code = code;
    }
    public Book(String title, String code,double qty) {
        this.title = title;
        this.code = code;
        this.qty = qty;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }
   
   

    @Override
    public String toString() {
        return "> " + this.title + " (" + this.qty +")";
    }
    
    
}
