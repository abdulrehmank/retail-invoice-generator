package com.retail.simulator;

public abstract class DiscountService {

    public abstract boolean checkCondition();

    public abstract boolean checkRestriction();

    public abstract double calculateDiscountAmount();



}
