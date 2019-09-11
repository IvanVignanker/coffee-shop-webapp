package com.coffeeshop.repository;

import com.coffeeshop.model.customer.entity.product.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductSearchRepository extends JpaRepository<Product, Long>, ProductSearchRepositoryCustom {

    @Query("select p from Product p")
    List<Product> getAllProducts();

    @Query("select p.productName from Product p")
    List<Product> getAllProductNames(@Param("productName") String productName);

    @Query("select p from Product p where p.unitPrice between :priceMin and :priceMax")
    List<Product> getAllProductByRangePrices(@Param("priceMin") Integer priceMin, @Param("priceMax") Integer priceMax);

    @Query("select p from Product p join ProductCoffee pc where pc.bitter between :bitterFrom and :bitterTo")
    List<Product> getAllProductByRangeBitter(@Param("bitterFrom") Integer bitterFrom, @Param("bitterTo") Integer bitterTo);

    @Query("select p from Product p join ProductCoffee pc where pc.strong between :strongFrom and :strongTo")
    List<Product> getAllProductByRangeStrong(@Param("strongFrom") Integer strongFrom, @Param("strongTo") Integer strongTo);

    @Query("select p from Product p join ProductCoffee pc where pc.sour between :sourFrom and :sourTo")
    List<Product> getAllProductByRangeSour(@Param("sourFrom") Integer sourFromm, @Param("sourTo") Integer sourTo);

    @Query("select p from Product p join ProductCoffee pc where pc.decaf = :decaf")
    List<Product> getAllProductByDecaf(@Param("decaf") boolean decaf);

    @Query("select p from Product p join ProductCoffee pc where pc.ground = :ground")
    List<Product> getAllProductByGround(@Param("ground") boolean ground);
}
