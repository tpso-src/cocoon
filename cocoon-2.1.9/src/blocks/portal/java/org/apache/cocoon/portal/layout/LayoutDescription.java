/*
 * Copyright 1999-2002,2004 The Apache Software Foundation.
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
package org.apache.cocoon.portal.layout;

import java.util.Iterator;

import org.apache.cocoon.portal.factory.ProducibleDescription;

/**
 * A configured layout
 * 
 * @author <a href="mailto:cziegeler@s-und-n.de">Carsten Ziegeler</a>
 * 
 * @version CVS $Id: LayoutDescription.java 55961 2004-10-29 10:09:02Z cziegeler $
 */
public interface LayoutDescription
    extends ProducibleDescription  {

    /**
     * @return the default renderer name
     */
    String getDefaultRendererName();
    
    /**
     * @return the names of all allowed renderers
     */
    Iterator getRendererNames();
    
    /**
     * @return The class name of the item
     */
    String getItemClassName();
}
