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

import org.w3c.dom.Element;

/**
 * Builds {GroupDefinition}s.
 *
 * @version $Id: GroupDefinitionBuilder.java 289538 2005-09-16 13:46:22Z sylvain $
 */
public final class GroupDefinitionBuilder extends AbstractContainerDefinitionBuilder {

    public WidgetDefinition buildWidgetDefinition(Element element) throws Exception {
        GroupDefinition definition = new GroupDefinition();
        
        super.setupDefinition(element, definition);
        setDisplayData(element, definition);

        setupContainer(element,"widgets",definition);
        
        definition.makeImmutable();
        return definition;
    }
}
