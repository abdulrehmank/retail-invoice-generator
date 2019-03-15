package com.retail.simulator;

import com.retail.simulator.models.*;
import com.retail.simulator.services.Chain;
import com.retail.simulator.services.DiscountByValue;
import com.retail.simulator.services.DiscountPercentageFacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
         *  create chain to process
         */
        Chain chain1 = new DiscountPercentageFacade();
        Chain chain2 = new DiscountByValue();
        chain1.setNext(chain2);


        /*
         *  Create different type of Users
         */
        User user1 = new User(1, "Abdul Rehman K.", "abcd@email.com", "987654321",
                User.UserType.EMPLOYEE, 1552297483100L);
        User user2 = new User(2, "Affiiate.", "aabcd@email.com", "987654321",
                User.UserType.AFFILIATE, 1552297483100L);
        User user3 = new User(3, "Affefefe.", "aabcd@email.com", "987654321",
                User.UserType.CUSTOMER, 1552297483100L);

        /*
         *  Create Product parent categories
         */
        Category category1 = new Category(1, "Fashion");
        Category category2 = new Category(2, "Groceries");

        /*
         *  Create Products
         */
        Product product1 = new Product(1, "T-Shirts", 1200, 1);
        Product product2 = new Product(2, "Pants", 2000, 1);
        Product product3 = new Product(3, "Jeans", 2500, 1);
        Product product4 = new Product(1, "Aata", 200, 2);
        Product product5 = new Product(1, "Oil", 100, 2);


        OrderItem orderItem1 = new OrderItem(1, product1, 2, 1200, 2400);
        OrderItem orderItem2 = new OrderItem(2, product2, 1, 2000, 2000);
        OrderItem orderItem3 = new OrderItem(3, product3, 1, 2500, 2500);
        OrderItem orderItem4 = new OrderItem(4, product4, 1, 200, 200);
        List<OrderItem> orderItems = new ArrayList<OrderItem>(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));

        double totalValue = 0;
        double grossValue = 0;
        for (OrderItem item:orderItems) {
            grossValue += item.getSubTotal();
            totalValue += chain1.process(user3.getUserType(), item.getProduct().getCategoryId(), item.getSubTotal(),
                    user2.getRegistrationDate());
        }
        totalValue -= chain2.process(user1.getUserType(), totalValue);

        Order order1 = new Order(1, user3, totalValue, (grossValue - totalValue), orderItems);
        System.out.println("Order : " + order1);
        System.out.println("Gross Payable Amount : " + grossValue);
        System.out.println("Discount : " + (grossValue - totalValue));
        System.out.println("Net Payable Amount : " + totalValue);

    }
}
