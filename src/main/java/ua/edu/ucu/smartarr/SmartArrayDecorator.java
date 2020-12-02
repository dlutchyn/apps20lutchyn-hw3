package ua.edu.ucu.smartarr;

import java.util.Arrays;

abstract class SmartArrayDecorator implements SmartArray {

    public Object[] arrElements;

    public int size() {
        return this.arrElements.length;
    }

    public Object[] toArray() {
        return Arrays.copyOf(this.arrElements,
                this.arrElements.length);
    }

    public Object[] applyDecoratorAction(SmartArray smartArray) {
        return smartArray.toArray();
        // no action here
    }
}
