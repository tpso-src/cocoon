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
package org.apache.cocoon.forms.binding;

import org.apache.cocoon.forms.binding.JXPathBindingManager.Assistant;
import org.apache.cocoon.forms.util.DomHelper;
import org.w3c.dom.Element;

/**
 * InsertBeanJXPathBindingBuilder provides a helper class for the Factory
 * implemented in {@link JXPathBindingManager} that helps construct the
 * actual {@link InsertBeanJXPathBinding} out of the configuration in the
 * provided configElement which looks like:
 * <pre><code>
 * &lt;fb:insert-bean classname="..child-bean-class.." addmethod="..method-to-add.."/&gt;
 * </code></pre>
 * or if the add method creates the new instance itself:
 * <pre><code>
 * &lt;fb:insert-bean addmethod="..method-to-add.."/&gt;
 * </code></pre>
 *
 * @version $Id: InsertBeanJXPathBindingBuilder.java 289538 2005-09-16 13:46:22Z sylvain $
 */
public class InsertBeanJXPathBindingBuilder extends JXPathBindingBuilderBase {

    /**
     * Creates an instance of {@link InsertBeanJXPathBinding} configured
     * with the nested template of the bindingElm.
     */
    public JXPathBindingBase buildBinding(Element bindingElm, Assistant assistant) throws BindingException {

        try {
            CommonAttributes commonAtts = JXPathBindingBuilderBase.getCommonAttributes(bindingElm);

            String className =
                DomHelper.getAttribute(bindingElm, "classname", null);
            String addMethod =
                DomHelper.getAttribute(bindingElm, "addmethod",null);

//          do inheritance
            InsertBeanJXPathBinding otherBinding = (InsertBeanJXPathBinding)assistant.getContext().getSuperBinding();
            if(otherBinding!=null) {
            	commonAtts = JXPathBindingBuilderBase.mergeCommonAttributes(otherBinding.getCommonAtts(),commonAtts);
            	
            	if(className==null)
            		className = otherBinding.getClassName();
            	if(addMethod==null)
            		addMethod = otherBinding.getAddMethodName();
            }
            
            return new InsertBeanJXPathBinding(commonAtts, className, addMethod);
        } catch (BindingException e) {
            throw e;
        } catch (Exception e) {
            throw new BindingException("Error building a insert-bean binding defined at " + DomHelper.getLocation(bindingElm), e);
        }
    }
}
