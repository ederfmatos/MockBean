package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueEnum;

final class MockBeanTypesUtils {

    protected static <O> Object getValueFromClass(Class<O> refClass) {
        for (MockBeanRandomValueEnum valueEnum : MockBeanRandomValueEnum.values()) {
            if (valueEnum.getRefClass().getSimpleName().equals(refClass.getSimpleName())) {
                return valueEnum.getGenerator().getRandomValue(null);
            }
        }

        return null;
    }

}
