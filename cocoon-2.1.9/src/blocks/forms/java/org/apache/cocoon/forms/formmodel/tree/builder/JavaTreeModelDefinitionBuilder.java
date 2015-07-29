/*
 * Copyright 1999-2005 The Apache Software Foundation.
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
package org.apache.cocoon.forms.formmodel.tree.builder;

import org.apache.avalon.framework.CascadingException;
import org.apache.avalon.framework.context.Context;
import org.apache.avalon.framework.context.ContextException;
import org.apache.avalon.framework.context.Contextualizable;
import org.apache.avalon.framework.logger.AbstractLogEnabled;
import org.apache.avalon.framework.service.ServiceException;
import org.apache.avalon.framework.service.ServiceManager;
import org.apache.avalon.framework.service.Serviceable;
import org.apache.cocoon.components.LifecycleHelper;
import org.apache.cocoon.forms.formmodel.tree.JavaTreeModelDefinition;
import org.apache.cocoon.forms.formmodel.tree.TreeModel;
import org.apache.cocoon.forms.formmodel.tree.TreeModelDefinition;
import org.apache.cocoon.forms.util.DomHelper;
import org.w3c.dom.Element;

/**
 * Builds a {@link TreeModelDefinition} based on an arbitrary Java class.
 * Avalon lifecycle will be run on the target class when instanciated.
 * 
 * @version $Id: JavaTreeModelDefinitionBuilder.java 190962 2005-06-16 17:17:00Z sylvain $
 */
public class JavaTreeModelDefinitionBuilder extends AbstractLogEnabled
    implements TreeModelDefinitionBuilder, Contextualizable, Serviceable {

    Context ctx;
    ServiceManager manager;
    
    public void contextualize(Context context) throws ContextException {
        this.ctx = context;
    }

    public void service(ServiceManager manager) throws ServiceException {
        this.manager = manager;
    }

    public TreeModelDefinition build(Element treeModelElement) throws Exception {
        String className = DomHelper.getAttribute(treeModelElement, "class");
        
        Class modelClass;
        try {
            modelClass = Thread.currentThread().getContextClassLoader().loadClass(className);
        } catch(Exception e) {
            throw new CascadingException("Cannot load class '" + className + "', at " +
                    DomHelper.getLocation(treeModelElement), e);
        }
        
        if (!TreeModel.class.isAssignableFrom(modelClass)) {
            throw new Exception("Class '" + className + "' doesn't implement TreeModel, at " +
                    DomHelper.getLocation(treeModelElement));
        }
        
        JavaTreeModelDefinition definition = new JavaTreeModelDefinition();
        
        LifecycleHelper.setupComponent(definition, getLogger(), ctx, manager, null);
        
        definition.setModelClass(modelClass);
        
        return definition;
    }

}
