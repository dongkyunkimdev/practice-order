package com.practice.order.domain.item;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class ItemInfo {

    @Getter
    @Builder
    public static class Main {
        private final String itemToken;
        private final Long partnerId;
        private final String itemName;
        private final Long itemPrice;
        private final Item.Status status;
        private final List<ItemOptionGroup> itemOptionGroupList;

        public Main(Item item, List<ItemOptionGroup> itemOptionGroupInfoList) {
            this.itemToken = item.getItemToken();
            this.partnerId = item.getPartnerId();
            this.itemName = item.getItemName();
            this.itemPrice = item.getItemPrice();
            this.status = item.getStatus();
            this.itemOptionGroupList = itemOptionGroupInfoList;
        }
    }

    @Getter
    @Builder
    public static class ItemOptionGroup {
        private final Integer ordering;
        private final String itemOptionGroupName;
        private final List<ItemOption> itemOptionList;
    }

    @Getter
    @Builder
    public static class ItemOption {
        private final Integer ordering;
        private final String itemOptionName;
        private final Long itemOptionPrice;
    }

}
