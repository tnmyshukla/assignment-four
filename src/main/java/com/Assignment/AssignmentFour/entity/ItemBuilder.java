package com.Assignment.AssignmentFour.entity;

/**
 * The type Item builder.
 */
public class ItemBuilder {
  private Item item;

  /**
   * Instantiates a new Item builder.
   *
   * @param id       the id
   * @param name     the name
   * @param type     the type
   * @param price    the price
   * @param quantity the quantity
   */
  public ItemBuilder(final String id, final String name, final String type, final int price, final int quantity) {
    this.item = new Item();
    item.setId(id);
    item.setName(name);
    item.setType(type);
    item.setPrice(price);
    item.setQuantity(quantity);
    double salesTax = 0.0;
    double finalPrice;
    switch (type) {
      case "raw":
        salesTax = 12.5 * price * 0.01;
        break;
      case "manufactured":
        salesTax = 12.5 * price * 0.01;
        salesTax += 0.02 * (price + salesTax);
        break;
      case "imported":
        final double importDuty = 0.1 * price;
        double surcharge;
        if (price + importDuty <= 100) {
          surcharge = 5.0;
        } else if (price + importDuty <= 200) {
          surcharge = 10.0;
        } else {
          surcharge = 0.05 * (price + importDuty);
        }
        salesTax = importDuty + surcharge;
        break;
      default:
        break;
    }
    finalPrice = (salesTax + price) * quantity;
    item.setSalesTax(salesTax);
    item.setFinalPrice(finalPrice);
  }

  /**
   * Gets item.
   *
   * @return the item
   */
  public Item getItem() {
    return item;
  }
}
