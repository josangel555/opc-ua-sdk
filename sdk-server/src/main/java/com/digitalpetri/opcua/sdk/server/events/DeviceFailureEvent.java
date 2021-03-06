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

package com.digitalpetri.opcua.sdk.server.events;

import java.util.Optional;

import com.digitalpetri.opcua.sdk.core.events.DeviceFailureEventType;
import com.digitalpetri.opcua.stack.core.types.builtin.ByteString;
import com.digitalpetri.opcua.stack.core.types.builtin.DateTime;
import com.digitalpetri.opcua.stack.core.types.builtin.LocalizedText;
import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;
import com.digitalpetri.opcua.stack.core.types.builtin.unsigned.UShort;
import com.digitalpetri.opcua.stack.core.types.structured.TimeZoneDataType;

/**
 * A {@link DeviceFailureEvent} is an Event of {@link DeviceFailureEventType} that indicates a failure in a device of
 * the underlying system.
 */
public class DeviceFailureEvent extends SystemEvent {

    public DeviceFailureEvent(ByteString eventId,
                              NodeId eventType,
                              NodeId sourceNode,
                              String sourceName,
                              DateTime time,
                              DateTime receiveTime,
                              Optional<TimeZoneDataType> localTime,
                              LocalizedText message,
                              UShort severity) {

        super(eventId, eventType, sourceNode, sourceName, time, receiveTime, localTime, message, severity);
    }

}
