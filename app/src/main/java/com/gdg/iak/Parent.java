package com.gdg.iak;

/**
 * Created by indrakurniawan on 12/3/16.
 */

public class Parent implements myParent{
    @Override
    public Integer calculate() {
        Integer total = 20 * 10;
        return total;
    }
    @Override
    public Integer calculate(Integer value) {
        Integer total = value * 10;
        return total;
    }

    @Override
    public void test() {

    }
}
