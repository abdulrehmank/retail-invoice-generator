package com.retail.simulator;

import junit.framework.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByValueTest {
    DiscountByValue discountByValue;

    @BeforeEach
    void setUp() {
        discountByValue = new DiscountByValue();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void process() {
        Object[] params = new Object[1];
        params[0] = 2400D;
        Assert.assertEquals(120.0, discountByValue.process(User.UserType.CUSTOMER, params));
    }

    @Test
    void checkCondition() {
        Assert.assertEquals(true, discountByValue.checkCondition());
    }

    @Test
    void checkRestriction() {
        Assert.assertEquals(false, discountByValue.checkRestriction());
    }
}