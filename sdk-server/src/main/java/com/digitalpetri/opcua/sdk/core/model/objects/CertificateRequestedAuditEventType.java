package com.digitalpetri.opcua.sdk.core.model.objects;

public interface CertificateRequestedAuditEventType extends AuditUpdateMethodEventType {

    String getApplicationUri();

    void setApplicationUri(String applicationUri);

}
