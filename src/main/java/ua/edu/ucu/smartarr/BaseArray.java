package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] arrElements;

    public BaseArray(Object[] arrElements) {
        this.arrElements = Arrays.copyOf(arrElements,
                arrElements.length);
    }

    public Object[] toArray() {
        Object[] newArr = Arrays.copyOf(this.arrElements,
                this.arrElements.length);
        return newArr;
    }

    public String operationDescription() {
        return "This is basic array, no operations applied.";
    }

    public int size() {
        return this.arrElements.length;
    }

    public Object[] applyDecoratorAction(SmartArray smartArray) {
        return this.arrElements;
    }
}
