package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        this.arrElements = new BaseArray(this.applyDecoratorAction(smartArray)).toArray();
    }

    @Override
    public Object[] applyDecoratorAction(SmartArray smartArray) {
        Object[] givenArr = smartArray.toArray();
        Object[] compareArr = new Object[smartArray.size()];
        int lenNewArray = 0;
        for (Object obj: givenArr) {
            for (Object newObj:compareArr) {
                if (newObj == null) {
                    compareArr[lenNewArray] = obj;
                    lenNewArray++;
                    break;
                } else if (obj.equals(newObj)) {
                    break;
                }
            }
        }
        Object[] newArray = Arrays.copyOf(compareArr, lenNewArray);
        return newArray;
    }

    @Override
    public String operationDescription() {
        return "Deletes repeated elements.";
    }
}
