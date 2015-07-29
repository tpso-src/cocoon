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
package org.apache.cocoon.faces.context;

import org.apache.cocoon.environment.Context;

/**
 * Init parameters map
 *
 * @author <a href="mailto:vgritsenko@apache.org">Vadim Gritsenko</a>
 * @version CVS $Id: InitParameterMap.java 55441 2004-10-24 16:14:10Z cziegeler $
 */
class InitParameterMap extends BaseMap {

    private Context context;


    InitParameterMap(Context context) {
        this.context = context;
    }

    public Object get(Object key) {
        return context.getInitParameter(key.toString());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof InitParameterMap)) {
            return false;
        }

        return super.equals(obj);
    }
}