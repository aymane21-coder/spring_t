package com.example.org_side.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor @NoArgsConstructor
@Data
@Document
public class Product {
    @Id
    private String  id;
    private String  name;
    private Double  Prix;
    @DBRef
        private Categories catalogue;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", Prix=" + Prix +
                ", catalogue=" + catalogue +
                '}';
    }
}


