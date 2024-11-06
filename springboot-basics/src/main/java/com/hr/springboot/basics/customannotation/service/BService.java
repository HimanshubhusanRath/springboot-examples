package com.hr.springboot.basics.customannotation.service;

import com.hr.springboot.basics.customannotation.context.TenantContext;
import org.springframework.stereotype.Component;

@Component
public class BService {
    public String getData() {
        return TenantContext.getCurrentDataSource()+"- Data";
    }
}
