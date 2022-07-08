package com.practice.order.domain.partner;

public interface PartnerService {

    // Command(cud), Criteria(r) --- Info(response)
    PartnerInfo registerPartner(PartnerCommand command);

    PartnerInfo getPartnerInfo(String partnerToken);

    PartnerInfo enablePartner(String partnerToken);

    PartnerInfo disablePartner(String partnerToken);

}
