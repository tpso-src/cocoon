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
 * The {@link WidgetDefinition} part of a Repeater widget, see {@link Repeater} for more information.
 * 
 * @version $Id: RepeaterDefinition.java 385330 2006-03-12 18:25:06Z sylvain $
 */
public class RepeaterDefinition extends AbstractContainerDefinition {
    private int initialSize = 0;
    private int minSize;
    private int maxSize;
    private boolean orderable;

    public RepeaterDefinition(int initialSize, int minSize, int maxSize, boolean selectable, boolean orderable) {
        super();
        this.initialSize = initialSize;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.orderable = orderable;
    }
    
    /**
     * initialize this definition with the other, sort of like a copy constructor
     */
    public void initializeFrom(WidgetDefinition definition) throws Exception {
        super.initializeFrom(definition);

        if(definition instanceof RepeaterDefinition) {
            RepeaterDefinition other = (RepeaterDefinition)definition;
            this.initialSize = other.initialSize;
            this.maxSize = other.maxSize;
            this.minSize = other.minSize;
        } else {
            throw new Exception("Definition to inherit from is not of the right type! (at "+getLocation()+")");
        }
    }

    public Widget createInstance() {
        return new Repeater(this);
    }
    
    public int getInitialSize() {
        return this.initialSize;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getMinSize() {
        return this.minSize;
    }
    
    public boolean getOrderable() {
        return this.orderable;
    }
}
