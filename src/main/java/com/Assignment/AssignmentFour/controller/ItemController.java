package com.Assignment.AssignmentFour.controller;

import com.Assignment.AssignmentFour.entity.Item;
import com.Assignment.AssignmentFour.service.ItemService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The type Item controller.
 */
@RestController
public class ItemController {
  @Autowired
  /**
   * Instance of service.
   */
  private ItemService itemService;

  /**
   * Gets all items.
   *
   * @return the all items
   */
  @RequestMapping("/items")
  /**
   * Method to get all items.
   */
  public CompletableFuture<List<Item>> getAllItems() {
    return itemService.getItems();
  }

  /**
   * Gets item.
   *
   * @param id the id
   * @return the item
   */
  @RequestMapping("/items/{id}")
  /**
   * Method to get item as per id.
   */
  //  public CompletableFuture<ResponseEntity<Item>> getItem(@PathVariable final String id) {
  //    return itemService.getItem(id).thenApply(ResponseEntity::ok);
  //  }
  public CompletableFuture<Item> getItem(@PathVariable final String id) {
    return itemService.getItem(id);
  }

  /**
   * Add item.
   *
   * @param item the item
   */
  @RequestMapping(method = RequestMethod.POST, value = "/items")
  /**
   * Method to add item.
   */
  public void addItem(@RequestBody final Item item) {
    itemService.addItem(item);
  }

  /**
   * Update item.
   *
   * @param item the item
   * @param id   the id
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/items/{id}")
  /**
   * Method to update item by id.
   */
  public void updateItem(@RequestBody final Item item, @PathVariable final String id) {
    itemService.updateItem(item, id);
  }

  /**
   * Delete item.
   *
   * @param id the id
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/items/{id}")
  /**
   * Method to delete item.
   */
  public void deleteItem(@PathVariable final String id) {
    itemService.deleteItem(id);
  }
}