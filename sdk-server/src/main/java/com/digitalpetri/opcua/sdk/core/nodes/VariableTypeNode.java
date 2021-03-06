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

package com.digitalpetri.opcua.sdk.core.nodes;

import java.util.Optional;

import com.digitalpetri.opcua.stack.core.types.builtin.DataValue;
import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;
import com.digitalpetri.opcua.stack.core.types.builtin.unsigned.UInteger;

public interface VariableTypeNode extends Node {

    Optional<DataValue> getValue();

    NodeId getDataType();

    Integer getValueRank();

    Optional<UInteger[]> getArrayDimensions();

    Boolean getIsAbstract();

    void setValue(Optional<DataValue> value);

    void setDataType(NodeId dataType);

    void setValueRank(int valueRank);

    void setArrayDimensions(Optional<UInteger[]> arrayDimensions);

    void setIsAbstract(boolean isAbstract);

}
