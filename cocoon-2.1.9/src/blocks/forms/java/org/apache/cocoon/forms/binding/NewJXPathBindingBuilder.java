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

import org.apache.cocoon.forms.util.DomHelper;
import org.w3c.dom.Element;

/**
 * NewJXPathBindingBuilder provides a helper class for the Factory
 * implemented in {@link JXPathBindingManager} that helps construct the
 * actual {@link NewJXPathBinding} out of the configuration in the
 * provided configElement which looks like:
 * <pre><code>
 * &lt;fb:new id="<i>widget-id</i>"&gt;
 *   &lt;fb:field id="<i>sub-widget-id</i>" path="<i>relative-xpath</i>"
 *       direction="<i>load|save</i>" lenient="<i>true/false</i>"/&gt;
 * &lt;/fb:new&gt;
 * </code></pre>
 *
 * @version $Id: NewJXPathBindingBuilder.java 289538 2005-09-16 13:46:22Z sylvain $
 */
public class NewJXPathBindingBuilder
    extends JXPathBindingBuilderBase {

    public JXPathBindingBase buildBinding(Element bindingElm, JXPathBindingManager.Assistant assistant)
            throws BindingException {
        try {
            String widgetId = DomHelper.getAttribute(bindingElm, "id", null);
            CommonAttributes commonAtts = JXPathBindingBuilderBase.getCommonAttributes(bindingElm);

            JXPathBindingBase[] childBindings = new JXPathBindingBase[0];

//          do inheritance
            NewJXPathBinding otherBinding = (NewJXPathBinding)assistant.getContext().getSuperBinding();
            if(otherBinding!=null) {
            	childBindings = otherBinding.getChildBindings();
            	commonAtts = JXPathBindingBuilderBase.mergeCommonAttributes(otherBinding.getCommonAtts(),commonAtts);
            	
            	if(widgetId==null)
            		widgetId = otherBinding.getId();
            }
            
            childBindings = assistant.makeChildBindings(bindingElm,childBindings);
            
            NewJXPathBinding newBinding = new NewJXPathBinding(commonAtts, widgetId, childBindings);
            return newBinding;
        } catch (BindingException e) {
            throw e;
        } catch (Exception e) {
            throw new BindingException("Error building new binding defined at " + DomHelper.getLocation(bindingElm), e);
        }
    }
}
