package com.digitalpetri.opcua.sdk.server.model.objects;

import java.util.Optional;

import com.digitalpetri.opcua.sdk.core.model.objects.SessionDiagnosticsObjectType;
import com.digitalpetri.opcua.sdk.core.model.objects.SessionsDiagnosticsSummaryType;
import com.digitalpetri.opcua.sdk.core.model.variables.SessionDiagnosticsArrayType;
import com.digitalpetri.opcua.sdk.core.model.variables.SessionSecurityDiagnosticsArrayType;
import com.digitalpetri.opcua.sdk.core.nodes.ObjectNode;
import com.digitalpetri.opcua.sdk.core.nodes.VariableNode;
import com.digitalpetri.opcua.sdk.server.api.UaNamespace;
import com.digitalpetri.opcua.sdk.server.util.UaObjectType;
import com.digitalpetri.opcua.stack.core.types.builtin.DataValue;
import com.digitalpetri.opcua.stack.core.types.builtin.LocalizedText;
import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;
import com.digitalpetri.opcua.stack.core.types.builtin.QualifiedName;
import com.digitalpetri.opcua.stack.core.types.builtin.Variant;
import com.digitalpetri.opcua.stack.core.types.builtin.unsigned.UByte;
import com.digitalpetri.opcua.stack.core.types.builtin.unsigned.UInteger;


@UaObjectType(name = "SessionsDiagnosticsSummaryType")
public class SessionsDiagnosticsSummaryNode extends BaseObjectNode implements SessionsDiagnosticsSummaryType {

    public SessionsDiagnosticsSummaryNode(
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

    public SessionDiagnosticsArrayType getSessionDiagnosticsArray() {
        Optional<VariableNode> sessionDiagnosticsArray = getVariableComponent("SessionDiagnosticsArray");

        return sessionDiagnosticsArray.map(node -> (SessionDiagnosticsArrayType) node).orElse(null);
    }

    public SessionSecurityDiagnosticsArrayType getSessionSecurityDiagnosticsArray() {
        Optional<VariableNode> sessionSecurityDiagnosticsArray = getVariableComponent("SessionSecurityDiagnosticsArray");

        return sessionSecurityDiagnosticsArray.map(node -> (SessionSecurityDiagnosticsArrayType) node).orElse(null);
    }

    public SessionDiagnosticsObjectType getSessionPlaceholder() {
        Optional<ObjectNode> sessionPlaceholder = getObjectComponent("SessionPlaceholder");

        return sessionPlaceholder.map(node -> (SessionDiagnosticsObjectType) node).orElse(null);
    }

    public synchronized void setSessionDiagnosticsArray(SessionDiagnosticsArrayType sessionDiagnosticsArray) {
        getVariableComponent("SessionDiagnosticsArray").ifPresent(n -> {
            n.setValue(new DataValue(new Variant(sessionDiagnosticsArray)));
        });
    }

    public synchronized void setSessionSecurityDiagnosticsArray(SessionSecurityDiagnosticsArrayType sessionSecurityDiagnosticsArray) {
        getVariableComponent("SessionSecurityDiagnosticsArray").ifPresent(n -> {
            n.setValue(new DataValue(new Variant(sessionSecurityDiagnosticsArray)));
        });
    }
}
