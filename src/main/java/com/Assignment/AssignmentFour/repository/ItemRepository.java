package com.Assignment.AssignmentFour.repository;


import com.Assignment.AssignmentFour.entity.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Item repository.
 */
public interface ItemRepository extends CrudRepository<Item, String> {

}

