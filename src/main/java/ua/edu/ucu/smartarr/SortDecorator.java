package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.lang.reflect.Array;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        this.comparator = comparator;
        this.arrElements = new BaseArray(this.applyDecoratorAction(smartArray)).toArray();
    }

    @Override
    public Object[] applyDecoratorAction(SmartArray smartArray) {
        Object[] newArray = Arrays.copyOf(smartArray.toArray(),
                smartArray.size());
        Arrays.sort(newArray, this.comparator);
        return newArray;
    }

    @Override
    public String operationDescription() {
        return null;
    }
}
