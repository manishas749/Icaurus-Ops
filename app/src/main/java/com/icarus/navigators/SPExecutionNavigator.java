package com.icarus.navigators;

public interface SPExecutionNavigator {

    void checkIfStepValidToComplete();

    void removeQRAttributeIfNoItemToScan(int attributePosition);

}
