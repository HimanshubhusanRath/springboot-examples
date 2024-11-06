package com.hr.springboot.basics.customannotation.service;

import com.hr.springboot.basics.customannotation.context.TenantContext;
import com.hr.springboot.basics.customannotation.custom.UseSlave;
import org.springframework.stereotype.Component;

@UseSlave(version = "2.0")
@Component
public class AService {
    public String getData() {
        return TenantContext.getCurrentDataSource()+"- Data";
    }
}
