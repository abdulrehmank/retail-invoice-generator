package com.retail.simulator.services;

import com.retail.simulator.models.User;
import junit.framework.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPercentageFactoryTest {



    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateDiscounts() {

        Object[] params = new Object[3];
        params[0] = 1;
        params[1] = 2400D;
        Assert.assertEquals(new DiscountForEmployee(User.UserType.EMPLOYEE, params), DiscountByPercentageFactory.calculateDiscounts(User.UserType.EMPLOYEE, params));

        Assert.assertEquals(new DiscountForAffiliate(User.UserType.AFFILIATE, params), DiscountByPercentageFactory.calculateDiscounts(User.UserType.AFFILIATE, params));

        Assert.assertEquals(new DiscountForCustomer(User.UserType.CUSTOMER, params), DiscountByPercentageFactory.calculateDiscounts(User.UserType.CUSTOMER, params));
    }
}