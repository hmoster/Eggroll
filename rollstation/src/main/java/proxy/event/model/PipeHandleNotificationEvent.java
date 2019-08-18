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

package networking.proxy.event.model;

import com.webank.ai.eggroll.networking.proxy.model.PipeHandlerInfo;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.concurrent.Immutable;

@Component
@Scope("prototype")
@Immutable
public class PipeHandleNotificationEvent extends ApplicationEvent {
    private PipeHandlerInfo pipeHandlerInfo;

    public PipeHandleNotificationEvent(Object source, PipeHandlerInfo pipeHandlerInfo) {
        super(source);
        this.pipeHandlerInfo = pipeHandlerInfo;
    }

    public PipeHandlerInfo getPipeHandlerInfo() {
        return pipeHandlerInfo;
    }

    public static enum Type {
        PUSH,
        PULL,
        UNARY_CALL;
    }
}
