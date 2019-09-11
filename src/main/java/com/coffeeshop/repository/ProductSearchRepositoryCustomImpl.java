package com.coffeeshop.repository;

import com.coffeeshop.model.customer.web.productList.ProductListDTORequest;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductSearchRepositoryCustomImpl implements ProductSearchRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Query> searchProductByName(ProductListDTORequest productListDTORequest, BindingResult result) {
        return createQuery(productListDTORequest, result);
    }

    private List<Query> createQuery(ProductListDTORequest productListDTORequest, BindingResult result) {
        StringBuilder query = new StringBuilder();
        Query jpaQuery = entityManager.createQuery(query.toString());
        query.append("select p from Product p");
        Map<String, Object> parameters = new HashMap<>();

        if (!productListDTORequest.getSearch().equals(null) || !productListDTORequest.getPriceMax().equals(null) && !productListDTORequest.getPriceMax().equals(null)) {
            if (!productListDTORequest.getSearch().equals(null)) {
                query.append(" where p.productName like :search%");
                parameters.put("search", productListDTORequest.getSearch());
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
            query.append(" join ProductCoffee pc where");

            if (!productListDTORequest.getCharacteristics().getBitterFrom().equals(null) && !productListDTORequest.getCharacteristics().getBitterTo().equals(null)) {
                query.append(" pc.bitter between :bitterFrom and :bitterTo");
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
                    query.append(" pc.strong between :strongFrom and :strongTo");
                    parameters.put("strongFrom",productListDTORequest.getCharacteristics().getStrongFrom());
                    parameters.put("strongTo",productListDTORequest.getCharacteristics().getStrongTo());
                    if (!productListDTORequest.getCharacteristics().getDecaf().equals(null)) {
                        query.append(" and pc.decaf == :decaf");
                        if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                            query.append(" and pc.ground == :ground");
                            parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
                        }
                    }
                }
                else if (!productListDTORequest.getCharacteristics().getDecaf().equals(null)) {
                    query.append(" pc.decaf == :decaf");
                    parameters.put("decaf",productListDTORequest.getCharacteristics().getDecaf());
                    if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                        query.append(" and pc.ground == :ground");
                    }
                }
                else if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                    query.append(" and pc.ground == :ground");
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
                    query.append(" and pc.decaf == :decaf");
                    parameters.put("decaf",productListDTORequest.getCharacteristics().getDecaf());
                    if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                        query.append(" and pc.ground == :ground");
                        parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
                    }
                }
                else if (!productListDTORequest.getCharacteristics().getGround().equals(null)) {
                    query.append(" and pc.ground == :ground");
                    parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
                }
            }
            else if (!productListDTORequest.getCharacteristics().getStrongFrom().equals(null) && !productListDTORequest.getCharacteristics().getStrongTo().equals(null)) {
                query.append(" pc.strong between :strongFrom and :strongTo");
                parameters.put("strongFrom",productListDTORequest.getCharacteristics().getStrongFrom());
                parameters.put("strongTo",productListDTORequest.getCharacteristics().getStrongTo());
                if (!productListDTORequest.getCharacteristics().getDecaf().equals(null)) {
                    query.append(" and pc.decaf == :decaf");
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
        for (Map.Entry<String, Object> map : parameters.entrySet()) {
            jpaQuery.setParameter(map.getKey(), map.getValue());
        }
        return jpaQuery.getResultList();
    }
}
