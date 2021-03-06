/*
 * Copyright 1999-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.cocoon.woody.formmodel;

import java.util.ArrayList;
import java.util.List;

import org.apache.cocoon.woody.event.ProcessingPhaseEvent;
import org.apache.cocoon.woody.event.ProcessingPhaseListener;
import org.apache.cocoon.woody.event.WidgetEventMulticaster;

/**
 * The {@link WidgetDefinition} part of a Form widget, see {@link Form} for more information.
 * 
 * @version $Id: FormDefinition.java 30932 2004-07-29 17:35:38Z vgritsenko $
 */
public class FormDefinition extends AbstractContainerDefinition {
    private ProcessingPhaseListener listener;

    public FormDefinition() {
        super();
    }

    public void resolve() throws Exception {
        List parents = new ArrayList();
        parents.add(this);
        resolve(parents, this);
    }

    public Widget createInstance() {
        Form form = new Form(this);
        createWidgets(form);
        return form;
    }
    
    public void addProcessingPhaseListener(ProcessingPhaseListener listener) {
        this.listener = WidgetEventMulticaster.add(this.listener, listener);
    }
    
    public boolean hasProcessingPhaseListeners() {
        return this.listener != null;
    }
    
    public void fireEvent(ProcessingPhaseEvent event) {
        if (this.listener != null) {
            this.listener.phaseEnded(event);
        }
    }
}
