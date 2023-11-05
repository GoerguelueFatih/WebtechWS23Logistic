package de.htwberlin.webtech.Logistic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Item {
    @Id
    String id;
    String name;

}
