package com.example.org_side.dao;

import com.example.org_side.Entities.Categories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends MongoRepository<Categories,String> {
}
