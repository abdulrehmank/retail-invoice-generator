package com.retail.simulator.services;

public abstract class DiscountService {

    public abstract boolean checkCondition();

    public abstract boolean checkRestriction();

    public abstract double calculateDiscountAmount();



}
