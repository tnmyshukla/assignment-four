package com.Assignment.AssignmentFour.service;

import com.Assignment.AssignmentFour.entity.Item;
import com.Assignment.AssignmentFour.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ItemService {
  @Autowired
  ItemRepository itemRepository;
  Logger logger= LoggerFactory.getLogger(ItemService.class);
  @Async("taskExecutor")
  public CompletableFuture<List<Item>> getItems() {
    logger.info("get list of user by "+Thread.currentThread().getName());
    List<Item>allItems=new ArrayList<>();
    itemRepository.findAll().forEach(allItems::add);
    return CompletableFuture.completedFuture(allItems);
  }
  @Async("taskExecutor")
  public CompletableFuture<Item> getItem(String id){
    return CompletableFuture.completedFuture(itemRepository.findById(id).get());

//    return Items.stream().filter(t->t.getId().equals(id)).findFirst().get();
  }
  @Async("taskExecutor")
  public void addItem(Item item){
    logger.info("add new user by "+Thread.currentThread().getName());
    itemRepository.save(new Item(item.getName(), item.getType(), item.getPrice(), item.getQuantity()));
  }
  @Async("taskExecutor")
  public void updateItem(Item item, String id) {
    itemRepository.save(new Item(item.getName(), item.getType(), item.getPrice(), item.getQuantity()));

  }
  @Async("taskExecutor")
  public void deleteItem(String id) {
    itemRepository.deleteById(id);
  }
}
