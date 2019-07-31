package com.coffeeshop.model.customer.entity.order.orderDetails;

import com.coffeeshop.model.customer.entity.base.BaseDate;
import com.coffeeshop.model.customer.entity.order.order.OrderEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails extends BaseDate {

    @OneToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID", nullable = false)
    private OrderEntity order;

    @Column(name = "CUSTOMER_ENTITY_NAME", nullable = false)
    private String customerEntityName;

    @Column(name = "CUSTOMER_ENTITY_PHONE_NUMBER", nullable = false)
    private String customerEntityPhoneNumber;

    @Column(name = "ORDER_EMAIL")
    private String orderEmail;

    @Column(name = "CONTACT_FIRST_NAME")
    private String contactFirstName;

    @Column(name = "CONTACT_LAST_NAME")
    private String contactLastName;

    @Column(name = "CONTACT_PHONE_NUMBER")
    private String contactPhoneNumber;

    @Column(name = "IS_SELF_PICKUP")
    private Boolean isSelfPickup = false;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "HOUSE_NUMBER", nullable = false)
    private String houseNumber;

    @Column(name = "APARTMENT", nullable = false)
    private String apartment;

    @Column(name = "FLOOR", nullable = false)
    private String floor;

    @Column(name = "DELIVERY_COMMENT", nullable = false)
    private String deliveryComment;
}