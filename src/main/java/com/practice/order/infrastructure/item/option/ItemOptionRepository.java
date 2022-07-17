package com.practice.order.infrastructure.item.option;

import com.practice.order.domain.item.option.ItemOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOptionRepository extends JpaRepository<ItemOption, Long> {

}
