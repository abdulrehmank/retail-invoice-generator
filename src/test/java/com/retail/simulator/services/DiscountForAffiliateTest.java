package com.retail.simulator.services;

import com.retail.simulator.models.User;
import com.retail.simulator.services.DiscountForAffiliate;
import junit.framework.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscountForAffiliateTest {

    DiscountForAffiliate discountForAffiliate;
    DiscountForAffiliate incorrectEmployee;
    DiscountForAffiliate restricteCategoryEmployee;

    @BeforeEach
    void setUp() {
        Object[] params = new Object[2];
        params[0] = 1;
        params[1] = 2400D;
        discountForAffiliate = new DiscountForAffiliate(User.UserType.AFFILIATE, params);
        incorrectEmployee = new DiscountForAffiliate(User.UserType.CUSTOMER, params);
        params[0] = 2;
        restricteCategoryEmployee = new DiscountForAffiliate(User.UserType.AFFILIATE, params);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkCondition() {

        Assert.assertEquals(true, discountForAffiliate.checkCondition());
        Assert.assertEquals(false, incorrectEmployee.checkCondition());
    }

    @Test
    void checkRestriction() {

        Assert.assertEquals(false, discountForAffiliate.checkRestriction());
        Assert.assertEquals(true, restricteCategoryEmployee.checkRestriction());
    }

    @Test
    void calculateDiscountAmount() {
        Assert.assertEquals(240.0, discountForAffiliate.calculateDiscountAmount());
    }

}