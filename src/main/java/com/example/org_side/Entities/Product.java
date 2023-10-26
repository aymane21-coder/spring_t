package com.example.org_side.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor @NoArgsConstructor @ToString
@Data
@Document
public class Product {
    @Id
    private String  id;
    private String  Nom;
    private Double  Prix;
    @DBRef
    private String catalogue;


}


