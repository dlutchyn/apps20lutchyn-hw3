package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        this.predicate = predicate;
        this.arrElements = new BaseArray(this.applyDecoratorAction(smartArray)).toArray();
    }

    @Override
    public Object[] applyDecoratorAction(SmartArray smartArray) {
        Object[] givenArr = smartArray.toArray();
        Object[] newArray = Arrays.stream(givenArr).
                filter(this.predicate::test).toArray();
        return newArray;
    }

    @Override
    public String operationDescription() {
        return "Removes elements that do not satisfy the predicate";
    }
}
