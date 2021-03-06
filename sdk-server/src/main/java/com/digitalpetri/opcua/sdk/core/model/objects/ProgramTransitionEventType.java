package com.digitalpetri.opcua.sdk.core.model.objects;

public interface ProgramTransitionEventType extends TransitionEventType {

    Object getIntermediateResult();

    void setIntermediateResult(Object intermediateResult);

}
