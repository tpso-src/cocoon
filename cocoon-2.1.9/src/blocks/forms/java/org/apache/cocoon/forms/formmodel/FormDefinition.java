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
package org.apache.cocoon.forms.formmodel;

import java.util.ArrayList;
import java.util.List;

import org.apache.cocoon.forms.event.ProcessingPhaseEvent;
import org.apache.cocoon.forms.event.ProcessingPhaseListener;
import org.apache.cocoon.forms.event.WidgetEventMulticaster;
import org.apache.cocoon.forms.formmodel.library.Library;
import org.apache.cocoon.forms.formmodel.library.LibraryManager;
import org.apache.commons.lang.StringUtils;

/**
 * The {@link WidgetDefinition} part of a Form widget, see {@link Form} for more information.
 * 
 * @version $Id: FormDefinition.java 291005 2005-09-22 19:08:29Z sylvain $
 */
public class FormDefinition extends AbstractContainerDefinition {
    private ProcessingPhaseListener listener;
    
    private Library localLibrary = null;

    public FormDefinition(LibraryManager libraryManager) {
        super();
        localLibrary = libraryManager.getNewLibrary();
    }
    
    public Library getLocalLibrary() {
    	return localLibrary;
    }

    public void resolve() throws Exception {
        List parents = new ArrayList();
        parents.add(this);
        resolve(parents, this);
        
        // TODO: test if this actually gets called!
        checkCompleteness();
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
    
    public void addWidgetDefinition(WidgetDefinition definition) throws Exception, DuplicateIdException {
        // Check that no child is named "submit" if this form has no id. This causes some weird behaviour
        // in HTML as it collides with the submit() function on the <form> element...
        if ("submit".equals(definition.getId()) && StringUtils.isEmpty(this.getId())) {
            throw new IllegalArgumentException("Top-level widgets should not be named 'submit' to avoid problems "
                    + " with HTML <form> elements, at " + definition.getLocation());
        }

        super.addWidgetDefinition(definition);
    }
}
