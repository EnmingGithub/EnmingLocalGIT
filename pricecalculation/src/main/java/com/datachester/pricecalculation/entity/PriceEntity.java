package com.datachester.pricecalculation.entity;

import javax.persistence.*;

@Entity
@Table(name="Fruit")
public class PriceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FRUIT_SEQ")
	@SequenceGenerator(sequenceName = "fruit_seq", allocationSize = 1, name = "FRUIT_SEQ")
	private Integer id;
	private String name;
    private Integer unitprice;
	public String getFruit() {
		return name;
	}
	public void setFruit(String fruit) {
		this.name = fruit;
	}
	public Integer getUnit() {
		return unitprice;
	}
	public void setUnit(Integer unit) {
		this.unitprice = unit;
	}


}
