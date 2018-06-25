package com.app.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "items")
public class Items {
	
	private static final long serialVersionUID = -8362030795917981354L;
	
	
	private static enum ItemType {
		GARMENTS, LEATHER, FOOTWEAR
	}
	
	private static enum ItemCatogory {
		A,B,C
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@NotEmpty(message = "Item Group Not Empty")
	private String itemGroup;
	
	@Column(nullable = false)
	@NotEmpty(message = "Item Name Not Empty")
	@Size(min = 5, max = 50  , message = "5 to 50")
	private String itemName;
	
	@Column(nullable = false)
	private String itemType;
	
	@Column(nullable = false)
	private String itemCatagory;
	
	@NotEmpty(message = "Description Not Empty")
	@Size(min = 5, max = 250  , message = "5 to 250")
	private String description;
	
	@Column(nullable = false)
	private Boolean published;
	
	private Timestamp datumUpisa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemCatagory() {
		return itemCatagory;
	}

	public void setItemCatagory(String itemCatagory) {
		this.itemCatagory = itemCatagory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public Timestamp getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Timestamp datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	

}
