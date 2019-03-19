package com.retail.simulator.services;

import com.retail.simulator.models.User;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountPercentageFacadeTest {

    DiscountPercentageFacade discountPercentageFacade;

    @BeforeEach
    void setUp() {

        discountPercentageFacade = new DiscountPercentageFacade();
    }

    @Test
    void calculateDiscount() {


    }

    @Test
    void process() {

        Object[] params = new Object[3];
        params[0] = 1;
        params[1] = 2400D;
        Assert.assertEquals(1680D, discountPercentageFacade.process(User.UserType.EMPLOYEE, params));

        params[0] = 2;
        params[1] = 2400D;
        Assert.assertEquals(2400D, discountPercentageFacade.process(User.UserType.EMPLOYEE, params));

        params[0] = 1;
        params[1] = 0D;
        Assert.assertEquals(0D, discountPercentageFacade.process(User.UserType.EMPLOYEE, params));
    }
}