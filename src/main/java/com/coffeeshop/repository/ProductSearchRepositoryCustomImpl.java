package com.coffeeshop.repository;

import com.coffeeshop.exception.ProductNotFoundException;
import com.coffeeshop.model.customer.web.productList.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class ProductSearchRepositoryCustomImpl implements ProductSearchRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductListDTOResponse searchProductByName(ProductListDTORequest productListDTORequest) {
        TypedQuery<Object[]> typedQuery = createQuery(productListDTORequest);
        List<Object[]> responsesFromDB = typedQuery.getResultList();
        List<ProductDTOResponse> productDTOResponses = new ArrayList<>();

        for (Object[] list : responsesFromDB) {
            productDTOResponses.add(ProductDTOResponse.builder()
                    .productId((Long) list[0])
                    .title((String) list[1])
                    .shortDescription((String) list[2])
                    .type(String.valueOf(list[3]))
                    .previewImage((String) list[4])
                    .price((Double) list[5])
                    .productParameters(ProductsParametersDTOResponse.builder()
                            .bitter((Integer) list[6])
                            .sour((Integer) list[7])
                            .strong((Integer) list[8])
                            .decaf((Boolean) list[9])
                            .coffeeType("arabica")
                            .build())
                    .availableAmount((Integer) list[10])
                    .build());
        }
        return ProductListDTOResponse.builder()
                .popular(productDTOResponses.get(0))
                .products(productDTOResponses)
                .build();
    }

    public TypedQuery<Object[]> createQuery(ProductListDTORequest productListDTORequest) {
        StringBuilder query = new StringBuilder();
        Map<String, Object> parameters = new HashMap<>();

        query.append("select p.id, p.productName, p.shortDescription, p.productCategoryId, p.previewImage, p.unitPrice, ");
        query.append("pc.bitter, pc.sour, pc.strong, pc.decaf, ");
        query.append("pq.quantity ");
        query.append("from Product p");
        query.append(" join ProductCoffee pc on p.id=pc.product.id");
        query.append(" join ProductQuantity pq on p.id=pq.product.id");


        if (!productListDTORequest.getSearch().equals(null) || !productListDTORequest.getPriceMax().equals(null) && !productListDTORequest.getPriceMax().equals(null)) {
            if (!productListDTORequest.getSearch().equals(null)) {
                query.append(" where p.productName like :search");
                parameters.put("search", productListDTORequest.getSearch()+"%");
                if (!productListDTORequest.getPriceMin().equals(null) && !productListDTORequest.getPriceMax().equals(null)) {
                    query.append(" and p.unitPrice between :priceMin and :priceMax");
                    parameters.put("priceMin",productListDTORequest.getPriceMin());
                    parameters.put("priceMax",productListDTORequest.getPriceMax());
                }
            }
            else query.append(" where p.unitPrice between :priceMin and :priceMax");
            parameters.put("priceMin",productListDTORequest.getPriceMin());
            parameters.put("priceMax",productListDTORequest.getPriceMax());
        }
        if (!productListDTORequest.getCharacteristics().getBitterFrom().equals(null) && !productListDTORequest.getCharacteristics().getBitterTo().equals(null)
                || !productListDTORequest.getCharacteristics().getSourFrom().equals(null) && !productListDTORequest.getCharacteristics().getSourTo().equals(null)
                || !productListDTORequest.getCharacteristics().getStrongFrom().equals(null) && !productListDTORequest.getCharacteristics().getStrongTo().equals(null)
                || !productListDTORequest.getCharacteristics().getDecaf().equals(null) || !productListDTORequest.getCharacteristics().getGround().equals(null)) {

            if (!productListDTORequest.getCharacteristics().getBitterFrom().equals(null) && !productListDTORequest.getCharacteristics().getBitterTo().equals(null)) {
                query.append(" and pc.bitter between :bitterFrom and :bitterTo");
                parameters.put("bitterFrom",productListDTORequest.getCharacteristics().getBitterFrom());
                parameters.put("bitterTo",productListDTORequest.getCharacteristics().getBitterTo());
                if (!productListDTORequest.getCharacteristics().getSourFrom().equals(null) && !productListDTORequest.getCharacteristics().getSourTo().equals(null)) {
                    query.append(" and pc.sour between :sourFrom and :sourTo");
                    parameters.put("sourFrom",productListDTORequest.getCharacteristics().getSourFrom());
                    parameters.put("sourTo",productListDTORequest.getCharacteristics().getSourTo());
                    if (!productListDTORequest.getCharacteristics().getStrongFrom().equals(null) && !productListDTORequest.getCharacteristics().getStrongTo().equals(null)) {
                        query.append(" and pc.strong between :strongFrom and :strongTo");
                        parameters.put("strongFrom",productListDTORequest.getCharacteristics().getStrongFrom());
                        parameters.put("strongTo",productListDTORequest.getCharacteristics().getStrongTo());
                        if (!productListDTORequest.getCharacteristics().getDecaf().equals(null)) {
                            query.append(" and pc.decaf = :decaf");
                            parameters.put("decaf",productListDTORequest.getCharacteristics().getDecaf());
                            if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                                query.append(" and pc.ground = :ground");
                                parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
                            }
                        }
                    }
                }
                else if (!productListDTORequest.getCharacteristics().getStrongFrom().equals(null) && !productListDTORequest.getCharacteristics().getStrongTo().equals(null)) {
                    query.append(" and pc.strong between :strongFrom and :strongTo");
                    parameters.put("strongFrom",productListDTORequest.getCharacteristics().getStrongFrom());
                    parameters.put("strongTo",productListDTORequest.getCharacteristics().getStrongTo());
                    if (!productListDTORequest.getCharacteristics().getDecaf().equals(null)) {
                        query.append(" and pc.decaf = :decaf");
                        if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                            query.append(" and pc.ground = :ground");
                            parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
                        }
                    }
                }
                else if (!productListDTORequest.getCharacteristics().getDecaf().equals(null)) {
                    query.append(" pc.decaf = :decaf");
                    parameters.put("decaf",productListDTORequest.getCharacteristics().getDecaf());
                    if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                        query.append(" and pc.ground = :ground");
                    }
                }
                else if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                    query.append(" and pc.ground = :ground");
                    parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
                }
            }
            else if (!productListDTORequest.getCharacteristics().getSourFrom().equals(null) && !productListDTORequest.getCharacteristics().getSourTo().equals(null)) {
                query.append(" pc.sour between :sourFrom and :sourTo");
                parameters.put("sourFrom",productListDTORequest.getCharacteristics().getSourFrom());
                parameters.put("sourTo",productListDTORequest.getCharacteristics().getSourTo());
                if (!productListDTORequest.getCharacteristics().getStrongFrom().equals(null) && !productListDTORequest.getCharacteristics().getStrongTo().equals(null)) {
                    query.append(" and pc.strong between :strongFrom and :strongTo");
                    parameters.put("strongFrom",productListDTORequest.getCharacteristics().getStrongFrom());
                    parameters.put("strongTo",productListDTORequest.getCharacteristics().getStrongTo());
                    if (!productListDTORequest.getCharacteristics().getDecaf().equals(null)) {
                        query.append(" and pc.decaf = :decaf");
                        parameters.put("decaf",productListDTORequest.getCharacteristics().getDecaf());
                        if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                            query.append(" and pc.ground = :ground");
                            parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
                        }
                    }
                }
                else if (!productListDTORequest.getCharacteristics().getDecaf().equals(null)) {
                    query.append(" and pc.decaf = :decaf");
                    parameters.put("decaf",productListDTORequest.getCharacteristics().getDecaf());
                    if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                        query.append(" and pc.ground = :ground");
                        parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
                    }
                }
                else if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                    query.append(" and pc.ground = :ground");
                    parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
                }
            }
            else if (!productListDTORequest.getCharacteristics().getStrongFrom().equals(null) && !productListDTORequest.getCharacteristics().getStrongTo().equals(null)) {
                query.append(" and pc.strong between :strongFrom and :strongTo");
                parameters.put("strongFrom",productListDTORequest.getCharacteristics().getStrongFrom());
                parameters.put("strongTo",productListDTORequest.getCharacteristics().getStrongTo());
                if (!productListDTORequest.getCharacteristics().getDecaf().equals(null)) {
                    query.append(" and pc.decaf = :decaf");
                    if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                        query.append(" and pc.ground = :ground");
                        parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
                    }
                }
                else if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                    query.append(" and pc.ground = :ground");
                    parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
                }
            }
            else if (!productListDTORequest.getCharacteristics().getDecaf().equals(null)) {
                query.append(" pc.decaf = :decaf");
                parameters.put("decaf",productListDTORequest.getCharacteristics().getDecaf());
                if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                    query.append(" and pc.ground = :ground");
                    parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
                }
            }
            else if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                query.append(" pc.ground = :ground");
                parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
            }
        }
        else {
            query.append(" where 1==1");
        }

        TypedQuery<Object[]> jpaQuery = entityManager.createQuery(query.toString(), Object[].class);
        for (Map.Entry<String, Object> map : parameters.entrySet()) {
            jpaQuery.setParameter(map.getKey(), map.getValue());
        }
        return jpaQuery;
    }
}
