package com.retail.simulator;

public class DiscountByValue extends DiscountService implements Chain{

    public static final int DISCOUNT_PER_VALUE = 100;
    public static final int DISCOUNT_VALUE = 5;
    private double totalAmount;

    /**
     * The code will take and set next chain as a chain of responsibility
     * @param c Chain
     */
    public void setNext(Chain c) {
        throw new UnsupportedOperationException();
    }

    public double process(User.UserType userType, Object[] params) {
        if( params.length > 0 && (params[0] instanceof Double)) {
            this.totalAmount = (Double) params[0];

        }
        return calculateDiscountAmount();
    }

    @Override
    public boolean checkCondition() {
        return true;
    }

    public boolean checkRestriction() {

        return false;
    }

    @Override
    public double calculateDiscountAmount() {
        if(totalAmount > DISCOUNT_PER_VALUE && checkCondition() && !checkRestriction()) {
            int discAmount = (int) (Math.floor(this.totalAmount / DISCOUNT_PER_VALUE) );

            return (discAmount * DISCOUNT_VALUE);
        }
        return 0;
    }

}
