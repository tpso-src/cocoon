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
package org.apache.cocoon.portal.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.apache.cocoon.portal.coplet.CopletData;
import org.apache.cocoon.portal.profile.impl.CopletDataManager;

/**
 * Field handler for CopletData instances.
 *
 * @author <a href="mailto:bluetkemeier@s-und-n.de">Bj&ouml;rn L&uuml;tkemeier</a>
 * 
 * @version CVS $Id: CopletDataFieldHandler.java 30932 2004-07-29 17:35:38Z vgritsenko $
 */
public class CopletDataFieldHandler extends AbstractFieldHandler {

    public Object getValue(Object object) {
        Map map = ((CopletDataManager) object).getCopletData();
        Vector result = new Vector(map.size());

        Iterator iterator = map.values().iterator();
        while (iterator.hasNext())
            result.addElement(iterator.next());

        return result;
    }

    public Object newInstance(Object parent) {
        return new CopletData();
    }

    public void resetValue(Object object) {
        ((CopletDataManager) object).getCopletData().clear();
    }

    public void setValue(Object object, Object value) {
        CopletData data = (CopletData) value;
        ((CopletDataManager) object).getCopletData().put(data.getId(), data);
    }
}
