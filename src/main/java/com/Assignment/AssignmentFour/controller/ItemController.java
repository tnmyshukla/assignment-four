package com.Assignment.AssignmentFour.controller;

import com.Assignment.AssignmentFour.entity.Item;
import com.Assignment.AssignmentFour.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
/**
 * RestController class.
 */
public class ItemController {
  @Autowired
  /**
   * Instance of service.
   */
  private ItemService itemService;

  @RequestMapping("/items")
  /**
   * Method to get all items.
   */
  public CompletableFuture<ResponseEntity<List<Item>>> getAllItems() {
    return itemService.getItems().thenApply(ResponseEntity::ok);
  }

  @RequestMapping("/items/{id}")
  /**
   * Method to get item as per id.
   */
  public CompletableFuture<ResponseEntity<Item>> getItem(@PathVariable final String id) {
    return itemService.getItem(id).thenApply(ResponseEntity::ok);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/items")
  /**
   * Method to add item.
   */
  public void addItem(@RequestBody final Item item) {
    itemService.addItem(item);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/items/{id}")
  /**
   * Method to update item by id.
   */
  public void updateItem(@RequestBody final Item item, @PathVariable final String id) {
    itemService.updateItem(item, id);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/items/{id}")
  /**
   * Method to delete item.
   */
  public void deleteItem(@PathVariable final String id) {
    itemService.deleteItem(id);
  }
}