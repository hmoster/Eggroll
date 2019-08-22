/*
 * Copyright 2019 The Eggroll Authors. All Rights Reserved.
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

package com.webank.ai.eggroll.rollsite.util;


import com.webank.ai.eggroll.api.networking.proxy.Proxy;
import com.webank.ai.eggroll.rollsite.infra.Pipe;
import com.webank.ai.eggroll.rollsite.infra.impl.PacketQueueSingleResultPipe;
import com.webank.ai.eggroll.rollsite.infra.Pipe;
import com.webank.ai.eggroll.rollsite.infra.impl.PacketQueueSingleResultPipe;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PipeUtils {
    public Proxy.Metadata getResultFromPipe(Pipe pipe) {
        if (pipe instanceof PacketQueueSingleResultPipe) {
            PacketQueueSingleResultPipe convertedPipe = (PacketQueueSingleResultPipe) pipe;
            if (convertedPipe.hasResult()) {
                return convertedPipe.getResult();
            }
        }

        return null;
    }
}