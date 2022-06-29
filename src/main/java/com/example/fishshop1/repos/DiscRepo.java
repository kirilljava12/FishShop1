package com.example.fishshop1.repos;

import com.example.fishshop1.models.DiscModel;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface DiscRepo extends CrudRepository<DiscModel, Long> {

}
