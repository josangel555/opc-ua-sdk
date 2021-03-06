package com.digitalpetri.opcua.sdk.server.model.objects;

import java.util.Optional;

import com.digitalpetri.opcua.sdk.core.model.objects.ServerRedundancyType;
import com.digitalpetri.opcua.sdk.server.api.UaNamespace;
import com.digitalpetri.opcua.sdk.server.util.UaObjectType;
import com.digitalpetri.opcua.stack.core.types.builtin.DataValue;
import com.digitalpetri.opcua.stack.core.types.builtin.LocalizedText;
import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;
import com.digitalpetri.opcua.stack.core.types.builtin.QualifiedName;
import com.digitalpetri.opcua.stack.core.types.builtin.Variant;
import com.digitalpetri.opcua.stack.core.types.builtin.unsigned.UByte;
import com.digitalpetri.opcua.stack.core.types.builtin.unsigned.UInteger;
import com.digitalpetri.opcua.stack.core.types.enumerated.RedundancySupport;


@UaObjectType(name = "ServerRedundancyType")
public class ServerRedundancyNode extends BaseObjectNode implements ServerRedundancyType {

    public ServerRedundancyNode(
            UaNamespace namespace,
            NodeId nodeId,
            QualifiedName browseName,
            LocalizedText displayName,
            Optional<LocalizedText> description,
            Optional<UInteger> writeMask,
            Optional<UInteger> userWriteMask,
            UByte eventNotifier) {

        super(namespace, nodeId, browseName, displayName, description, writeMask, userWriteMask, eventNotifier);
    }

    public RedundancySupport getRedundancySupport() {
        Optional<Integer> redundancySupport = getProperty("RedundancySupport");

        return redundancySupport.map(RedundancySupport::from).orElse(null);
    }

    public synchronized void setRedundancySupport(RedundancySupport redundancySupport) {
        getPropertyNode("RedundancySupport").ifPresent(n -> {
            Integer value = redundancySupport.getValue();

            n.setValue(new DataValue(new Variant(value)));
        });
    }
}
