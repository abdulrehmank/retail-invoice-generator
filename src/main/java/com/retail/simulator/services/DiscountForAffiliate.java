package com.retail.simulator.services;

import com.retail.simulator.models.User;

public class DiscountForAffiliate extends DiscountService {

    private static final int DISCOUNT_PERCENTAGE = 10;
    private User.UserType discountToUserType = User.UserType.AFFILIATE;
    private User.UserType inputUserType;
    private int inputCategory;
    private double totalAmount;

    public DiscountForAffiliate(User.UserType userType, Object[] params) {
        this.inputUserType = userType;
        if( params.length > 0 && (params[0] instanceof Integer)) {
            this.inputCategory = (Integer) params[0];

        }
        if( params.length > 1 && (params[1] instanceof Double)) {
            this.totalAmount = (Double) params[1];

        }
    }

    public boolean checkCondition() {

        return this.discountToUserType == this.inputUserType;
    }

    public boolean checkRestriction() {

        return RestrictedToDiscount.getInstance().getRestrictedCategories().contains(this.inputCategory);
    }

    public double calculateDiscountAmount() {
        if(checkCondition() && !checkRestriction()) {
            return totalAmount * DISCOUNT_PERCENTAGE / 100;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountForAffiliate)) return false;

        DiscountForAffiliate that = (DiscountForAffiliate) o;

        if (inputCategory != that.inputCategory) return false;
        if (Double.compare(that.totalAmount, totalAmount) != 0) return false;
        if (discountToUserType != that.discountToUserType) return false;
        return inputUserType == that.inputUserType;
    }
}
