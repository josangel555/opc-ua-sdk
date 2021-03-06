package com.digitalpetri.opcua.sdk.core.model.variables;

import com.digitalpetri.opcua.sdk.core.model.UaMandatory;
import com.digitalpetri.opcua.sdk.core.model.UaOptional;
import com.digitalpetri.opcua.stack.core.types.structured.EUInformation;
import com.digitalpetri.opcua.stack.core.types.structured.Range;

public interface AnalogItemType extends DataItemType {

    @UaOptional("InstrumentRange")
    Range getInstrumentRange();

    @UaMandatory("EURange")
    Range getEURange();

    @UaOptional("EngineeringUnits")
    EUInformation getEngineeringUnits();

    void setInstrumentRange(Range instrumentRange);

    void setEURange(Range eURange);

    void setEngineeringUnits(EUInformation engineeringUnits);

}
