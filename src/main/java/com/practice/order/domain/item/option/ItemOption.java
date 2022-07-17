package com.practice.order.domain.item.option;

import com.practice.order.common.exception.InvalidParamException;
import com.practice.order.domain.AbstractEntity;
import com.practice.order.domain.item.optiongroup.ItemOptionGroup;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Slf4j
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "item_options")
public class  ItemOption extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_option_group_id")
    @NotNull
    private ItemOptionGroup itemOptionGroup;

    @Column(name = "ordering")
    @NotNull
    private Integer ordering;

    @Column(name = "item_option_name")
    @NotNull
    private String itemOptionName;

    @Column(name = "item_option_price")
    @NotNull
    private Long itemOptionPrice;

    @Builder
    public ItemOption(
            ItemOptionGroup itemOptionGroup,
            Integer ordering,
            String itemOptionName,
            Long itemOptionPrice
    ) {
        if (itemOptionGroup == null) throw new InvalidParamException("itemOption.itemOptionGroup");
        if (ordering == null) throw new InvalidParamException("itemOption.ordering");
        if (StringUtils.isBlank(itemOptionName)) throw new InvalidParamException("itemOption.itemOptionName");
        if (itemOptionPrice == null) throw new InvalidParamException("itemOption.itemOptionPrice");

        this.itemOptionGroup = itemOptionGroup;
        this.ordering = ordering;
        this.itemOptionName = itemOptionName;
        this.itemOptionPrice = itemOptionPrice;
    }

}
