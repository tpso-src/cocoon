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
package org.apache.cocoon.components.accessor;

import org.apache.cocoon.environment.ObjectModelHelper;

/**
 * @version SVN $Id: ContextAccessor.java 169483 2005-05-10 14:57:03Z lgawron $
 */
public class ContextAccessor extends ObjectModelAccessor {

    public Object getObject() {
        return ObjectModelHelper.getContext(getObjectModel());
    }
}
