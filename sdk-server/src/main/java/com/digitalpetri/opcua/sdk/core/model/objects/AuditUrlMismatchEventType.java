package com.digitalpetri.opcua.sdk.core.model.objects;

public interface AuditUrlMismatchEventType extends AuditCreateSessionEventType {

    String getEndpointUrl();

    void setEndpointUrl(String endpointUrl);

}
