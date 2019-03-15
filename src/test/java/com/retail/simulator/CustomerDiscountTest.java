package com.retail.simulator;

import junit.framework.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerDiscountTest {

    DiscountForCustomer discountForCustomer;

    @BeforeEach
    void setUp() {
        Object[] params = new Object[3];
        params[0] = 1;
        params[1] = 2400D;
        params[2] = 1452297483100L;
        discountForCustomer = new DiscountForCustomer(User.UserType.CUSTOMER, params);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkCondition() {
        Assert.assertEquals(true, discountForCustomer.checkCondition());
    }

    @Test
    void checkRestriction() {
        Assert.assertEquals(false, discountForCustomer.checkRestriction());
    }

    @Test
    void calculateDiscountAmount() {
        Assert.assertEquals(120.0, discountForCustomer.calculateDiscountAmount());
    }
}