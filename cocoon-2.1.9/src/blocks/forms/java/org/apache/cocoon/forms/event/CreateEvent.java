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
package org.apache.cocoon.forms.event;

import org.apache.cocoon.forms.formmodel.Widget;

/**
 * An event raised when a widget is created, once it has been fully set up. For
 * container widgets, this occurs after child widgets, if any, have been created.
 * 
 * @version $Id: CreateEvent.java 155211 2005-02-24 17:05:51Z sylvain $
 */
public class CreateEvent extends WidgetEvent {
    
    public CreateEvent(Widget source) {
        super(source);
    }
}
