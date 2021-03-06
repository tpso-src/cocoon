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

/**
 * The {@link WidgetDefinition} part of a MultiValueField widget, see {@link MultiValueField} for more information.
 * 
 * @version $Id: MultiValueFieldDefinition.java 367048 2006-01-08 16:40:26Z antonio $
 */
public class MultiValueFieldDefinition extends FieldDefinition {
    public Widget createInstance() {
        MultiValueField field =  new MultiValueField(this);
        return field;
    }

	public void setRequired(boolean required) {
		throw new UnsupportedOperationException("The property 'required' is not available on widgets of type multivalue.");
	}
}
