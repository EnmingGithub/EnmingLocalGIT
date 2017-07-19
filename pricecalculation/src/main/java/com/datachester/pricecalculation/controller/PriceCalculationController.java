package com.datachester.pricecalculation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.datachester.pricecalculation.entity.PriceEntity;


@RestController
public class PriceCalculationController {
	
	Map<String,Integer> map= new HashMap<>();


	Integer price = 0;
	@RequestMapping(value = "/price", method = RequestMethod.POST)
	public Integer calculate(@RequestBody ArrayList<PriceEntity> fruitentry){
		map.put("apple",3);
		map.put("orange",2);
		map.put("peach",5);

		for (PriceEntity fruit: fruitentry){
            price = price + map.get(fruit.getFruit())*fruit.getUnit();
		  };
		return price;

	}

}
