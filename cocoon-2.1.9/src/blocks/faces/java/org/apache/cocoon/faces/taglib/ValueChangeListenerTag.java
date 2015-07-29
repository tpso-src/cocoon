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
package org.apache.cocoon.faces.taglib;

import org.apache.cocoon.taglib.TagSupport;

import org.apache.cocoon.faces.FacesUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.event.ValueChangeListener;

/**
 * @version CVS $Id: ValueChangeListenerTag.java 46253 2004-09-17 14:36:29Z vgritsenko $
 */
public class ValueChangeListenerTag extends TagSupport {

    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int doStartTag(String namespaceURI, String localName, String qName, Attributes atts)
    throws SAXException {

        UIComponentTag tag = FacesUtils.findParentUIComponentTag(this);
        if (tag == null) {
            throw new SAXException("Tag <" + getClass().getName() + "> have to be nested within a UIComponentTag");
        }

        if (!tag.getCreated()) {
            return 0;
        }

        UIComponent component = tag.getComponentInstance();
        if (component == null) {
            throw new SAXException("Parent tag <" + tag.getClass().getName() + "> has no component instance");
        }

        if (component instanceof EditableValueHolder) {
            String clazz = (String) FacesUtils.evaluate(tag.getFacesContext(), this.type);
            ValueChangeListener handler = null;
            try {
                handler = (ValueChangeListener) Class.forName(clazz).newInstance();
            } catch (Exception e) {
                throw new SAXException("Tag <" + tag.getClass().getName() + "> could not create action listener <" + clazz + ">", e);
            }
            ((EditableValueHolder)component).addValueChangeListener(handler);
        }

        return SKIP_BODY;
    }

    public void recycle() {
        super.recycle();
        this.type = null;
    }
}
