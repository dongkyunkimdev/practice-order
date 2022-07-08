package com.practice.order.domain.partner;

import com.practice.order.common.exception.InvalidParamException;
import com.practice.order.common.util.TokenGenerator;
import com.practice.order.domain.AbstractEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Slf4j
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "partners")
public class Partner extends AbstractEntity {

    private static final String PREFIX_PARTNER = "ptn_";

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // pk를 외부에 노출시키지 않게 대체 키 역할로 사용
    @Column(name = "partner_token", nullable = false, unique = true)
    private String partnerToken;

    @Column(name = "partner_name", nullable = false)
    private String partnerName;

    @Column(name = "business_no", nullable = false, unique = true)
    private String businessNo;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("활성화"),
        DISABLE("비활성화");

        private final String description;

    }

    @Builder
    public Partner(String partnerName, String businessNo, String email) {

        if (StringUtils.isEmpty(partnerName)) throw new InvalidParamException();
        if (StringUtils.isEmpty(businessNo)) throw new InvalidParamException();
        if (StringUtils.isEmpty(email)) throw new InvalidParamException();

        this.partnerToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER);
        this.partnerName = partnerName;
        this.businessNo = businessNo;
        this.email = email;
        this.status = Status.ENABLE;

    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }

}
