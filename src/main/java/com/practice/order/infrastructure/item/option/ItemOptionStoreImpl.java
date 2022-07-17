package com.practice.order.infrastructure.item.option;

import com.practice.order.domain.item.option.ItemOption;
import com.practice.order.domain.item.option.ItemOptionStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemOptionStoreImpl implements ItemOptionStore {

    private final ItemOptionRepository itemOptionRepository;

    @Override
    public void store(ItemOption itemOption) {
        itemOptionRepository.save(itemOption);
    }

}
