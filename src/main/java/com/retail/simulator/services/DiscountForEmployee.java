package com.retail.simulator.services;

import com.retail.simulator.models.User;

public class DiscountForEmployee extends DiscountService {

    private static final int DISCOUNT_PERCENTAGE = 30;
    private static final User.UserType discountTouserType = User.UserType.EMPLOYEE;
    private User.UserType inputUserType;
    private int inputCategory;
    private Double totalAmount;


    public DiscountForEmployee(User.UserType userType, Object[] params) {
        this.inputUserType = userType;
        if( params.length > 0 && (params[0] instanceof Integer)) {
            this.inputCategory = (Integer) params[0];

        }
        if( params.length > 1 && (params[1] instanceof Double)) {
            this.totalAmount = (Double) params[1];
        }
    }

    public boolean checkCondition() {

        return this.discountTouserType == this.inputUserType;
    }

    public boolean checkRestriction() {

        return RestrictedToDiscount.restrictedCategories.contains(this.inputCategory);
    }

    public double calculateDiscountAmount() {
            return totalAmount * DISCOUNT_PERCENTAGE / 100;
    }
}
