package com.Assignment.AssignmentFour.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The type Item.
 */
@Entity
public class Item {
  @Id
  private String id;
  private String name;
  private int quantity;
  private int price;
  private String type;
  private double salesTax;
  private double finalPrice;


  /**
   * Gets quantity.
   *
   * @return the quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Gets price.
   *
   * @return the price
   */
  public int getPrice() {
    return price;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets sales tax.
   *
   * @return the sales tax
   */
  public double getSalesTax() {
    return salesTax;
  }

  /**
   * Gets final price.
   *
   * @return the final price
   */
  public double getFinalPrice() {
    return finalPrice;
  }


  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(final String id) {
    this.id = id;
  }

  /**
   * Sets price.
   *
   * @param price the price
   */
  public void setPrice(final int price) {
    this.price = price;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  public void setType(final String type) {
    this.type = type;
  }

  /**
   * Sets sales tax.
   *
   * @param salesTax the sales tax
   */
  public void setSalesTax(final double salesTax) {
    this.salesTax = salesTax;
  }

  /**
   * Sets final price.
   *
   * @param finalPrice the final price
   */
  public void setFinalPrice(final double finalPrice) {
    this.finalPrice = finalPrice;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(final String name) {
    this.name = name;
  }


  /**
   * Sets quantity.
   *
   * @param quantity the quantity
   */
  public void setQuantity(final int quantity) {
    this.quantity = quantity;
  }
}
