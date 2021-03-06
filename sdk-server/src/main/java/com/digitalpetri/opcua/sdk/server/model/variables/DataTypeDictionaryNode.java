package com.digitalpetri.opcua.sdk.server.model.variables;

import java.util.Optional;

import com.digitalpetri.opcua.sdk.core.model.UaOptional;
import com.digitalpetri.opcua.sdk.core.model.variables.DataTypeDictionaryType;
import com.digitalpetri.opcua.sdk.server.api.UaNamespace;
import com.digitalpetri.opcua.sdk.server.util.UaVariableType;
import com.digitalpetri.opcua.stack.core.types.builtin.DataValue;
import com.digitalpetri.opcua.stack.core.types.builtin.LocalizedText;
import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;
import com.digitalpetri.opcua.stack.core.types.builtin.QualifiedName;
import com.digitalpetri.opcua.stack.core.types.builtin.Variant;
import com.digitalpetri.opcua.stack.core.types.builtin.unsigned.UByte;
import com.digitalpetri.opcua.stack.core.types.builtin.unsigned.UInteger;

@UaVariableType(name = "DataTypeDictionaryType")
public class DataTypeDictionaryNode extends BaseDataVariableNode implements DataTypeDictionaryType {

    public DataTypeDictionaryNode(UaNamespace namespace,
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
    @UaOptional("DataTypeVersion")
    public String getDataTypeVersion() {
        Optional<String> dataTypeVersion = getProperty("DataTypeVersion");

        return dataTypeVersion.orElse(null);
    }

    @Override
    @UaOptional("NamespaceUri")
    public String getNamespaceUri() {
        Optional<String> namespaceUri = getProperty("NamespaceUri");

        return namespaceUri.orElse(null);
    }

    @Override
    public synchronized void setDataTypeVersion(String dataTypeVersion) {
        getPropertyNode("DataTypeVersion").ifPresent(n -> {
            n.setValue(new DataValue(new Variant(dataTypeVersion)));
        });
    }

    @Override
    public synchronized void setNamespaceUri(String namespaceUri) {
        getPropertyNode("NamespaceUri").ifPresent(n -> {
            n.setValue(new DataValue(new Variant(namespaceUri)));
        });
    }

}
