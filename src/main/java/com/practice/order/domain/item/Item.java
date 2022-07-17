package com.practice.order.domain.item;

import com.google.common.collect.Lists;
import com.practice.order.common.exception.InvalidParamException;
import com.practice.order.common.util.TokenGenerator;
import com.practice.order.domain.AbstractEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "items")
public class Item extends AbstractEntity {

    private static final String PREFIX_ITEM = "itm_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "item_token", unique = true)
    @NotNull
    private String itemToken;

    @Column(name = "partner_id", unique = true)
    @NotNull
    private Long partnerId;

    @Column(name = "item_name")
    @NotNull
    private String itemName;

    @Column(name = "item_price")
    @NotNull
    private Long itemPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NotNull
    private Status status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.PERSIST)
    private List<ItemOptionGroup> itemOptionGroupList = Lists.newArrayList();

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        PREPARE("판매준비중"),
        ON_SALES("판매중"),
        END_OF_SALES("판매종료");

        private final String description;
    }

    @Builder
    public Item(Long partnerId, String itemName, Long itemPrice) {
        if (partnerId == null) throw new InvalidParamException();
        if (StringUtils.isBlank(itemName)) throw new InvalidParamException();
        if (itemPrice == null) throw new InvalidParamException();

        this.itemToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_ITEM);
        this.partnerId = partnerId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.status = Status.PREPARE;
    }

    public void changePrepare() {
        this.status = Status.PREPARE;
    }

    public void changeOnSales() {
        this.status = Status.ON_SALES;
    }

    public void changeEndOfSales() {
        this.status = Status.END_OF_SALES;
    }

}
