package com.retail.simulator.services;

import com.retail.simulator.models.User;

public class DiscountPercentageFacade implements Chain {

    private Chain nextInChain;

    public double calculateDiscount(User.UserType userType, Object... conditionalParams){
        DiscountService discountService = DiscountByPercentageFactory.calculateDiscounts(userType, conditionalParams);
        if(discountService.checkCondition() && !discountService.checkRestriction()) {
            double discountValue = discountService.calculateDiscountAmount();
            return discountValue;
        }
        return 0;
    }

    public void setNext(Chain c) {
        this.nextInChain = c;
    }

    public double process(User.UserType userType, Object... conditionalParams) {
        double totalAmount = 0;
        if( conditionalParams.length > 1 && (conditionalParams[1] instanceof Double)) {
            totalAmount = (Double) conditionalParams[1];

        }
        double discountValue = calculateDiscount(userType, conditionalParams);
        if(totalAmount > 0) {
            totalAmount-= discountValue;
        }

        return totalAmount;
    }
}
