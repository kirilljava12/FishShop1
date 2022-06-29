package com.example.fishshop1.repos;

import com.example.fishshop1.enums.TypeEnum;
import com.example.fishshop1.models.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<ItemModel, Long> {
    List<ItemModel> findAllByIfActual(boolean ifActual);
    List<ItemModel> findAllByTypeEnumAndIfActual(TypeEnum typeEnum, boolean ifActual);
}
