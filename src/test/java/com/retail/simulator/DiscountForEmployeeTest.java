package com.retail.simulator;

import com.retail.simulator.models.User;
import com.retail.simulator.services.DiscountForEmployee;
import junit.framework.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscountForEmployeeTest {

    DiscountForEmployee discountForEmployee;
    DiscountForEmployee incorrectEmployee;
    DiscountForEmployee restricteCategoryEmployee;
    @BeforeEach
    void setUp() {
        Object[] params = new Object[2];
        params[0] = 1;
        params[1] = 2400D;
        discountForEmployee = new DiscountForEmployee(User.UserType.EMPLOYEE, params);
        incorrectEmployee = new DiscountForEmployee(User.UserType.CUSTOMER, params);
        params[0] = 2;
        restricteCategoryEmployee = new DiscountForEmployee(User.UserType.EMPLOYEE, params);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkCondition() {
        Assert.assertEquals(true, discountForEmployee.checkCondition());
        Assert.assertEquals(false, incorrectEmployee.checkCondition());
    }

    @Test
    void checkRestriction() {
        Assert.assertEquals(false, discountForEmployee.checkRestriction());
        Assert.assertEquals(true, restricteCategoryEmployee.checkRestriction());
    }

    @Test
    void calculateDiscountAmount() {
        Assert.assertEquals(720.0, discountForEmployee.calculateDiscountAmount());
    }
}