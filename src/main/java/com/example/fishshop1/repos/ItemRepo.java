package com.example.fishshop1.repos;

import com.example.fishshop1.models.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<ItemModel, Long> {
}
