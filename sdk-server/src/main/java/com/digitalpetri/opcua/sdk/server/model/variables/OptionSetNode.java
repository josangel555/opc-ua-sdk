package com.digitalpetri.opcua.sdk.server.model.variables;

import java.util.Optional;

import com.digitalpetri.opcua.sdk.core.model.UaMandatory;
import com.digitalpetri.opcua.sdk.core.model.UaOptional;
import com.digitalpetri.opcua.sdk.core.model.variables.OptionSetType;
import com.digitalpetri.opcua.sdk.server.api.UaNamespace;
import com.digitalpetri.opcua.sdk.server.util.UaVariableType;
import com.digitalpetri.opcua.stack.core.types.builtin.DataValue;
import com.digitalpetri.opcua.stack.core.types.builtin.LocalizedText;
import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;
import com.digitalpetri.opcua.stack.core.types.builtin.QualifiedName;
import com.digitalpetri.opcua.stack.core.types.builtin.Variant;
import com.digitalpetri.opcua.stack.core.types.builtin.unsigned.UByte;
import com.digitalpetri.opcua.stack.core.types.builtin.unsigned.UInteger;

@UaVariableType(name = "OptionSetType")
public class OptionSetNode extends BaseDataVariableNode implements OptionSetType {

    public OptionSetNode(UaNamespace namespace,
                         NodeId nodeId,
                         QualifiedName browseName,
                         LocalizedText displayName,
                         Optional<LocalizedText> description,
                         Optional<UInteger> writeMask,
                         Optional<UInteger> userWriteMask,
                         DataValue value,
                         NodeId dataType,
                         Integer valueRank,
                         Optional<UInteger[]> arrayDimensions,
                         UByte accessLevel,
                         UByte userAccessLevel,
                         Optional<Double> minimumSamplingInterval,
                         boolean historizing) {

        super(namespace, nodeId, browseName, displayName, description, writeMask, userWriteMask,
                value, dataType, valueRank, arrayDimensions, accessLevel, userAccessLevel, minimumSamplingInterval, historizing);

    }

    @Override
    @UaMandatory("OptionSetValues")
    public LocalizedText[] getOptionSetValues() {
        Optional<LocalizedText[]> optionSetValues = getProperty("OptionSetValues");

        return optionSetValues.orElse(null);
    }

    @Override
    @UaOptional("BitMask")
    public Boolean[] getBitMask() {
        Optional<Boolean[]> bitMask = getProperty("BitMask");

        return bitMask.orElse(null);
    }

    @Override
    public synchronized void setOptionSetValues(LocalizedText[] optionSetValues) {
        getPropertyNode("OptionSetValues").ifPresent(n -> {
            n.setValue(new DataValue(new Variant(optionSetValues)));
        });
    }

    @Override
    public synchronized void setBitMask(Boolean[] bitMask) {
        getPropertyNode("BitMask").ifPresent(n -> {
            n.setValue(new DataValue(new Variant(bitMask)));
        });
    }

}
