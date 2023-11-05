package de.htwberlin.webtech.Logistic.repository;

import de.htwberlin.webtech.Logistic.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    List<Item> findItemsByNameContaining(String name);
}
