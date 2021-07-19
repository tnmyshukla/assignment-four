package com.Assignment.AssignmentFour;

import com.Assignment.AssignmentFour.entity.Item;
import com.Assignment.AssignmentFour.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * The type App runner.
 */
@Component
public class AppRunner implements CommandLineRunner {
  /**
   * The Item service.
   */
  ItemService itemService;
  /**
   * The Logger.
   */
  Logger logger = LoggerFactory.getLogger(AppRunner.class);

  /**
   * Instantiates a new App runner.
   *
   * @param itemService the item service
   */
  public AppRunner(ItemService itemService) {
    this.itemService = itemService;
  }

  @Async
  @Override
  public void run(String... args) throws Exception {
    itemService.getMethod();
    itemService.addMethod();
    //    for (int i = 0; i < 1000; i++) {
    //      itemService.getItems();
    //      logger.info("running" + i);
    //      Item item2 = new Item("54", "Cotton", "raw", 314, 3);
    //      //      itemService.addItem(item2);
    //    }
    //    for (int i = 0; i < 1000; i++) {
    //
    //    }
  }
}

