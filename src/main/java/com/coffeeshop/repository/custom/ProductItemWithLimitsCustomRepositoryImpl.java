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
public class ProductItemWithLimitsCustomRepositoryImpl implements ProductItemWithLimitsCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductItem> findAllByProductIdAndStatusOrderByLimit(Product product, ProductStatus productStatus, int limit) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductItem> query = criteriaBuilder.createQuery(ProductItem.class);
        Root<ProductItem> root = query.from(ProductItem.class);
        Predicate productPredicate = criteriaBuilder.equal(root.get("product"), product);
        Predicate productStatusPredicate = criteriaBuilder.equal(root.get("status"), productStatus);
        query.where(productPredicate, productStatusPredicate);
        TypedQuery<ProductItem> typedQuery = entityManager.createQuery(query);
        List<ProductItem> resultList = typedQuery.setMaxResults(limit).getResultList();
        entityManager.close();
        return resultList;
    }
}
