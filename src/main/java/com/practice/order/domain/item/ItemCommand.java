package com.practice.order.domain.item;

import com.practice.order.domain.item.option.ItemOption;
import com.practice.order.domain.item.optiongroup.ItemOptionGroup;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class ItemCommand {

    @Getter
    @Builder
    public static class RegisterItemRequest {
        private final String itemName;
        private final Long itemPrice;
        private final List<RegisterItemOptionGroupRequest> itemOptionGroupRequestList;

        public Item toEntity(Long partnerId) {
            return Item.builder()
                    .partnerId(partnerId)
                    .itemName(itemName)
                    .itemPrice(itemPrice)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class RegisterItemOptionGroupRequest {  // ex) 색상
        private final Integer ordering;
        private final String itemOptionGroupName;
        private final List<RegisterItemOptionRequest> itemOptionRequestList;  // ex) R, B, W

        public ItemOptionGroup toEntity(Item item) {
            return ItemOptionGroup.builder()
                    .item(item)
                    .ordering(ordering)
                    .itemOptionGroupName(itemOptionGroupName)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class RegisterItemOptionRequest {
        private final Integer ordering;
        private final String itemOptionName;
        private final Long itemOptionPrice;

        public ItemOption toEntity(ItemOptionGroup itemOptionGroup) {
            return ItemOption.builder()
                    .itemOptionGroup(itemOptionGroup)
                    .ordering(ordering)
                    .itemOptionName(itemOptionName)
                    .itemOptionPrice(itemOptionPrice)
                    .build();
        }
    }

}
