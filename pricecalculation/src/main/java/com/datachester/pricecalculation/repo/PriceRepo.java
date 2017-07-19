package com.datachester.pricecalculation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.datachester.pricecalculation.entity.PriceEntity;

@Repository
public interface PriceRepo extends JpaRepository<PriceEntity,Integer>{

}
