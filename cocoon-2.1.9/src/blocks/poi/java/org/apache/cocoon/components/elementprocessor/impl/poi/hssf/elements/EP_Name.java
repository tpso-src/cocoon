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

package org.apache.cocoon.components.elementprocessor.impl.poi.hssf.elements;

/**
 * No-op implementation of ElementProcessor to handle the "name" tag
 *
 * This element is not used in HSSFSerializer 1.0
 *
 * This element has no attributes, but it does have character content
 *
 * @author Marc Johnson (marc_johnson27591@hotmail.com)
 * @version CVS $Id: EP_Name.java 30932 2004-07-29 17:35:38Z vgritsenko $
 */
public class EP_Name extends BaseElementProcessor {

    /**
     * constructor
     */
    public EP_Name() {
        super(null);
    }
}   // end public class EP_Name
