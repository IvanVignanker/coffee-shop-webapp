package com.coffeeshop.repository.custom;

import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.model.customer.entity.product.productItem.status.ProductStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProductItemRepositoryCustomImpl implements ProductItemRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ProductItem> findProductItemByProductAndProductStatusLimitIs(Product product, ProductStatus status, int limit) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductItem> criteriaQuery = criteriaBuilder.createQuery(ProductItem.class);
        Root<ProductItem> itemRoot = criteriaQuery.from(ProductItem.class);
        Predicate predicate = criteriaBuilder.equal(itemRoot.get("product"), product);
        Predicate predicateStatus = criteriaBuilder.equal(itemRoot.get("status"), status);
        criteriaQuery.where(predicate, predicateStatus);

        TypedQuery<ProductItem> typedQuery = entityManager.createQuery(criteriaQuery);
        List<ProductItem> productItems = typedQuery.setMaxResults(limit).getResultList();
        entityManager.close();
        return productItems;
    }
}
