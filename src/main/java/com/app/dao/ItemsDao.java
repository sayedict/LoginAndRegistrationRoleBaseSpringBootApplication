package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Items;

public interface ItemsDao extends JpaRepository<Items, Long>{

}
