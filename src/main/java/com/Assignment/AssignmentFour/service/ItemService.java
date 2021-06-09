package com.Assignment.AssignmentFour.service;

import com.Assignment.AssignmentFour.entity.Item;
import com.Assignment.AssignmentFour.entity.ItemBuilder;
import com.Assignment.AssignmentFour.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * The type Item service.
 */
@Service
public class ItemService {
  /**
   * The Item repository.
   */
  @Autowired
  ItemRepository itemRepository;
  /**
   * The Logger.
   */
  Logger logger = LoggerFactory.getLogger(ItemService.class);
  /**
   * The Lock.
   */
  ReadWriteLock lock = new ReentrantReadWriteLock();
  /**
   * The Write lock.
   */
  Lock writeLock = lock.writeLock();
  /**
   * The Read lock.
   */
  Lock readLock = lock.readLock();

  /**
   * Gets items.
   *
   * @return the items
   */
  @Async("taskExecutor")
  public List<Item> getItems() {
    //    try {
    //      Thread.sleep(1000);
    //    } catch (InterruptedException e) {
    //      e.printStackTrace();
    //    }
    try {
      readLock.lock();
      logger.info("get list of user by " + Thread.currentThread().getName());
      return StreamSupport.stream(itemRepository.findAll().spliterator(), false).collect(Collectors.toList());
    } finally {
      readLock.unlock();
    }
  }

  /**
   * Get item completable future.
   *
   * @param id the id
   * @return the completable future
   */
  @Async("taskExecutor")
  public Item getItem(final String id) {
    try {
      readLock.lock();
      logger.info("get new user by id: " + id + " by " + Thread.currentThread().getName());
      return itemRepository.findById(id).get();
    } finally {
      readLock.unlock();
    }
  }

  /**
   * Add item.
   *
   * @param item the item
   */
  @Async("taskExecutor")
  public void addItem(final Item item) {
    //    try {
    //      Thread.sleep(00);
    //    } catch (InterruptedException e) {
    //      e.printStackTrace();
    //    }
    try {
      writeLock.lock();
      logger.info("add new user by " + Thread.currentThread().getName());
      itemRepository.save(
              new ItemBuilder(item.getId(), item.getName(), item.getType(), item.getPrice(), item.getQuantity())
                      .getItem());
    } finally {
      writeLock.unlock();
    }
  }

  /**
   * Update item.
   *
   * @param item the item
   * @param id   the id
   * @return the item
   */
  @Async("taskExecutor")
  public Item updateItem(final Item item,final String id) {
    //try {
    //  Thread.sleep(1000);
    //} catch (InterruptedException e) {
    //  e.printStackTrace();
    //}
    try {
      writeLock.lock();
      logger.info("update user by " + Thread.currentThread().getName());
      itemRepository.save(
              new ItemBuilder(item.getId(), item.getName(), item.getType(), item.getPrice(), item.getQuantity())
                      .getItem());
      return itemRepository.findById(id).get();
    } finally {
      writeLock.unlock();
    }
  }

  /**
   * Delete item.
   *
   * @param id the id
   */
  @Async("taskExecutor")
  public void deleteItem(final String id) {
    try {
      writeLock.lock();
      logger.info("delete user by " + Thread.currentThread().getName());
      itemRepository.deleteById(id);
    } finally {
      writeLock.unlock();
    }
  }

  /**
   * Add method.
   */
  @Async("taskExecutor")
  public void addMethod() {
    for (int i = 0; i < 1000; i++) {
      final Item item2 = new ItemBuilder("54", "Cotton", "raw", 314, 3).getItem();
      addItem(item2);
      //      logger.info("running"+i);
    }
  }

  /**
   * Gets method.
   */
  @Async("taskExecutor")
  public void getMethod() {
    for (int i = 0; i < 1000; i++) {
      getItem("54");
      //      logger.info("running"+i);
    }
  }
}
