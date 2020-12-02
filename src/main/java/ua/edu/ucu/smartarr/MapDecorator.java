package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        this.function = function;
        this.arrElements = new BaseArray(this.applyDecoratorAction(smartArray)).toArray();
    }

    @Override
    public Object[] applyDecoratorAction(SmartArray smartArray) {
        Object[] givenArr = smartArray.toArray();
        Object[] newArray = Arrays.stream(givenArr).
                map(this.function::apply).toArray();
        return newArray;
    }

    @Override
    public String operationDescription() {
        return "Maps a function to every element.";
    }
}
