package com.practice.order.interfaces.partner;

import com.practice.order.application.partner.PartnerFacade;
import com.practice.order.common.response.CommonResponse;
import com.practice.order.domain.partner.PartnerCommand;
import com.practice.order.domain.partner.PartnerInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {

    private final PartnerFacade partnerFacade;

    @PostMapping
    public CommonResponse registerPartner(@Valid @RequestBody PartnerDto.RegisterRequest request) {
        PartnerCommand command = request.toCommand();

        PartnerInfo partnerInfo = partnerFacade.registerPartner(command);

        return CommonResponse.success(new PartnerDto.RegisterResponse(partnerInfo));
    }

}
