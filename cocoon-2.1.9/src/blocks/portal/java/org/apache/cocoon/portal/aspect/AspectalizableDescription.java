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
package org.apache.cocoon.portal.aspect;

import java.util.List;



/**
 * This is a description of an {@link Aspectalizable} object.
 * An aspectalizable object can have a number of aspects. 
 * 
 * @author <a href="mailto:cziegeler@s-und-n.de">Carsten Ziegeler</a>
 * 
 * @version CVS $Id: AspectalizableDescription.java 30932 2004-07-29 17:35:38Z vgritsenko $
 */
public interface AspectalizableDescription  {

    /**
     * @return All {@link AspectDescription}s
     */
    List getAspectDescriptions();

    /**
     * Return the description for an aspect
     */
    AspectDescription getAspectDescription(String name);
    
}
