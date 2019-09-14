package com.coffeeshop.repository;

import com.coffeeshop.model.customer.web.productList.*;
import org.springframework.stereotype.Repository;

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
        String query = createQuery();
        TypedQuery<Object[]> jpaQuery = entityManager.createQuery(query, Object[].class);
        Map<String, Object> parameters = setParameters(productListDTORequest);
        for (Map.Entry<String, Object> map : parameters.entrySet()) {
            jpaQuery.setParameter(map.getKey(), map.getValue());
        }
        List<Object[]> responsesFromDB = jpaQuery.getResultList();
        if (responsesFromDB.isEmpty()) {
            return new ProductListDTOResponse();
        }
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

    public Map<String, Object> setParameters(ProductListDTORequest productListDTORequest) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("search", productListDTORequest.getSearch()+"%");
        parameters.put("priceMin",productListDTORequest.getPriceMin());
        parameters.put("priceMax",productListDTORequest.getPriceMax());
        parameters.put("bitterFrom",productListDTORequest.getCharacteristics().getBitterFrom());
        parameters.put("bitterTo",productListDTORequest.getCharacteristics().getBitterTo());
        parameters.put("sourFrom",productListDTORequest.getCharacteristics().getSourFrom());
        parameters.put("sourTo",productListDTORequest.getCharacteristics().getSourTo());
        parameters.put("strongFrom",productListDTORequest.getCharacteristics().getStrongFrom());
        parameters.put("strongTo",productListDTORequest.getCharacteristics().getStrongTo());
        parameters.put("decaf",productListDTORequest.getCharacteristics().getDecaf());
        parameters.put("ground",productListDTORequest.getCharacteristics().getGround());
        return parameters;
    }

    public String createQuery() {
        StringBuilder query = new StringBuilder();
        query.append("select p.id, p.productName, p.shortDescription, p.productCategoryId, p.previewImage, p.unitPrice, ");
        query.append("pc.bitter, pc.sour, pc.strong, pc.decaf, ");
        query.append("pq.quantity ");
        query.append("from Product p ");
        query.append("join ProductCoffee pc on p.id=pc.product.id ");
        query.append("join ProductQuantity pq on p.id=pq.product.id ");
        query.append("where p.productName like :search ");
        query.append("and p.unitPrice between :priceMin and :priceMax ");
        query.append("and p.available = true ");
        query.append("and pc.bitter between :bitterFrom and :bitterTo ");
        query.append("and pc.sour between :sourFrom and :sourTo ");
        query.append("and pc.strong between :strongFrom and :strongTo ");
        query.append("and pc.decaf = :decaf ");
        query.append("and pc.ground = :ground");
        return query.toString();
    }
}
