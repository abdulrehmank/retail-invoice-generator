package com.retail.simulator;

import java.util.Date;

public class DiscountForCustomer extends DiscountService {

    private static final int DISCOUNT_PERCENTAGE = 5;
    private static final long VALID_REGISTRATION_DURATION = (1000L*60*60*24*365*2);
    private User.UserType discountTouserType = User.UserType.CUSTOMER;
    private User.UserType inputUserType;
    private int inputCategory;
    private double totalAmount;
    private long userRegistrationDate;


    public DiscountForCustomer(User.UserType userType, Object[] params) {
        this.inputUserType = userType;
        if( params.length > 0 && (params[0] instanceof Integer)) {
            this.inputCategory = (Integer) params[0];

        }
        if( params.length > 1 && (params[1] instanceof Double))  {
            this.totalAmount = (Double) params[1];

        }
        if( params.length > 2 && (params[2] instanceof Long)) {

            this.userRegistrationDate= (Long) params[2];
        }
    }

    public boolean checkCondition() {

        return this.discountTouserType == this.inputUserType &&
                this.userRegistrationDate <= (new Date().getTime() - VALID_REGISTRATION_DURATION);
    }

    public boolean checkRestriction() {

        return RestrictedToDiscount.restrictedCategories.contains(this.inputCategory);
    }

    public double calculateDiscountAmount() {
        if(checkCondition() && !checkRestriction()) {
            return totalAmount * DISCOUNT_PERCENTAGE / 100;
        }
        return 0;
    }

}
