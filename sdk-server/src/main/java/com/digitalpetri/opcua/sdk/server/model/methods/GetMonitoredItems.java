/*
 * Copyright 2014
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.digitalpetri.opcua.sdk.server.model.methods;

import java.util.List;

import com.digitalpetri.opcua.sdk.server.items.BaseMonitoredItem;
import com.digitalpetri.opcua.sdk.server.subscriptions.Subscription;
import com.digitalpetri.opcua.sdk.server.util.UaInputArgument;
import com.digitalpetri.opcua.sdk.server.util.UaOutputArgument;
import com.google.common.collect.Lists;
import com.digitalpetri.opcua.sdk.server.OpcUaServer;
import com.digitalpetri.opcua.sdk.server.util.AnnotationBasedInvocationHandler.InvocationContext;
import com.digitalpetri.opcua.sdk.server.util.AnnotationBasedInvocationHandler.Out;
import com.digitalpetri.opcua.sdk.server.util.UaMethod;
import com.digitalpetri.opcua.stack.core.StatusCodes;
import com.digitalpetri.opcua.stack.core.UaException;
import com.digitalpetri.opcua.stack.core.types.builtin.StatusCode;
import com.digitalpetri.opcua.stack.core.types.builtin.unsigned.UInteger;

import static com.digitalpetri.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

public class GetMonitoredItems {

    private final OpcUaServer server;

    public GetMonitoredItems(OpcUaServer server) {
        this.server = server;
    }

    @UaMethod
    public void invoke(
            InvocationContext context,

            @UaInputArgument(name = "subscriptionId")
            UInteger subscriptionId,

            @UaOutputArgument(name = "serverHandles")
            Out<UInteger[]> serverHandles,

            @UaOutputArgument(name = "clientHandles")
            Out<UInteger[]> clientHandles) throws UaException {

        Subscription subscription = server.getSubscriptions().get(subscriptionId);

        if (subscription == null) {
            throw new UaException(new StatusCode(StatusCodes.Bad_SubscriptionIdInvalid));
        }

        List<UInteger> serverHandleList = Lists.newArrayList();
        List<UInteger> clientHandleList = Lists.newArrayList();

        for (BaseMonitoredItem<?> item : subscription.getMonitoredItems().values()) {
            serverHandleList.add(item.getId());
            clientHandleList.add(uint(item.getClientHandle()));
        }

        serverHandles.set(serverHandleList.toArray(new UInteger[serverHandleList.size()]));
        clientHandles.set(clientHandleList.toArray(new UInteger[clientHandleList.size()]));
    }

}
