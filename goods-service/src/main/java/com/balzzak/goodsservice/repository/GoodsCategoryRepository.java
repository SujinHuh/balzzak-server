package com.balzzak.goodsservice.repository;

import com.balzzak.data.goods.models.domain.GoodsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsCategoryRepository extends JpaRepository<GoodsCategory, Long> {
}
