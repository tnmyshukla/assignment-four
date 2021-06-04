package com.Assignment.AssignmentFour.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Version;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
/**
 * Entity class.
 */
public class Item {
  @Id @GeneratedValue(generator="system-uuid")
  @GenericGenerator(name="system-uuid", strategy = "uuid")
  /**
   * Item id.
   */
  private String id;
  /**
   * Item name.
   */
  private String name;
  /**
   * Item quantity.
   */
  private int quantity;
  /**
   * Item price.
   */
  private int price;
  /**
   * Item type.
   */
  private String type;
  /**
   * Sales tax calculated.
   */
  private double salesTax;
  /**
   * Final price of item.
   */
  private double finalPrice;
  @Version
  /**
   * Variable to implement optimistic locking.
   */
  private int version;

  /**
   * Constructor for Item class.
   * @param name name
   * @param type type
   * @param price price
   * @param quantity quantity
   */
  public Item(final String name, final String type,final int price,final int quantity){
    this.name=name;
    this.price=price;
    this.quantity=quantity;
    this.type=type;
    setFinalPrice();
  }

  /**
   * Default constructor.
   */
  public Item(){

  }

  /**
   *Method to get quantity.
   * @return quantity
   */
  public int getQuantity() {
    return quantity;
  }
  /**
   *Method to get price.
   * @return price
   */
  public int getPrice() {
    return price;
  }
  /**
   *Method to get type.
   * @return type
   */
  public String getType() {
    return type;
  }
  /**
   *Method to get salestax.
   * @return salestax
   */
  public double getSalesTax() {
    return salesTax;
  }
  /**
   *Method to get final price.
   * @return final price
   */
  public double getFinalPrice() {
    return finalPrice;
  }

  public void setFinalPrice() {
    switch(this.type){
      case "raw":
        this.salesTax=12.5*this.price*0.01;
        break;
      case "manufactured":
        this.salesTax=12.5*this.price*0.01;
        this.salesTax+=0.02*(this.price+this.salesTax);
        break;
      case "imported":
        double importDuty=0.1*this.price;
        double surcharge;
        if(this.price+importDuty<=100) {
          surcharge=5.0;
        } else if(this.price+importDuty<=200) {
          surcharge=10.0;
        }else{
          surcharge=0.05*(this.price+importDuty);
        }
        this.salesTax=importDuty+surcharge;
        break;
    }
    this.finalPrice=(this.salesTax+this.price)*this.quantity;
  }
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


}
