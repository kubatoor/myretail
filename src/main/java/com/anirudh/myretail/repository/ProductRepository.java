package com.anirudh.myretail.repository;

import java.math.BigDecimal;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.anirudh.myretail.dto.ProductDTO;

@Repository
public interface ProductRepository extends CassandraRepository<ProductDTO>{
	
	@Query("select * from product where productid=?0")
	public ProductDTO findByProductId(Long productId);
	@Query("update product set price=?0, currency=?1 where productID=?2" )
	public ProductDTO update(BigDecimal price, String currency, Long productID );
	
}
