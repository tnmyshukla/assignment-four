package com.Assignment.AssignmentFour;

import com.Assignment.AssignmentFour.entity.Item;
import com.Assignment.AssignmentFour.entity.ItemBuilder;
import com.Assignment.AssignmentFour.service.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * The type Assignment four application tests.
 */
@SpringBootTest
public class AssignmentFourApplicationTests {
  @Autowired
  private ItemService itemService;

  /**
   * Test create.
   *
   * @throws ExecutionException   the execution exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCreate() throws ExecutionException, InterruptedException {
    Item item = new ItemBuilder("20", "coke", "manufactured", 20, 1).getItem();
    itemService.addItem(item);
    Assertions.assertNotNull(itemService.getItem("20"));
  }

  /**
   * Test read all.
   *
   * @throws ExecutionException   the execution exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testReadAll() throws ExecutionException, InterruptedException {
    CompletableFuture<List<Item>> list = itemService.getItems();
    Assertions.assertTrue(list.get().size() > 0);
  }

  /**
   * Test read.
   */
  @Test
  public void testRead() {
    Item item = new ItemBuilder("24", "candy", "manufactured", 200, 12).getItem();
    itemService.addItem(item);
    Assertions.assertNotNull(itemService.getItem("24"));
  }

  /**
   * Test update.
   *
   * @throws ExecutionException   the execution exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUpdate() throws ExecutionException, InterruptedException {
    Item item = new ItemBuilder("24", "candyman", "manufactured", 200, 12).getItem();
    Item updatedItem = itemService.updateItem(item, "24").get();
    Assertions.assertEquals(item.getName(), updatedItem.getName());
  }

  /**
   * Test delete.
   *
   * @throws ExecutionException   the execution exception
   * @throws InterruptedException the interrupted exception
   */
  @Test()
  public void testDelete() throws ExecutionException, InterruptedException {
    itemService.deleteItem("24");
    Assertions.assertThrows(Exception.class, () -> {
      itemService.getItem("214").get();
    });
  }
}