package com.retail.simulator;

public abstract class DiscountByPercentageFactory {

    public static DiscountService calculateDiscounts(User.UserType userType, Object... params) {

        switch (userType) {
            case EMPLOYEE:
                return new DiscountForEmployee(userType,params);
            case AFFILIATE:
                return new DiscountForAffiliate(userType,params);
            case CUSTOMER:
                return new DiscountForCustomer(userType,params);
        }
        return null;
    }
}
