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
package org.apache.cocoon.woody.datatype.convertor;

import org.apache.cocoon.woody.Constants;
import org.apache.cocoon.woody.util.DomHelper;
import org.w3c.dom.Element;

/**
 * Builds {@link EnumConvertor}s.
 * 
 * @version CVS $Id: EnumConvertorBuilder.java 30932 2004-07-29 17:35:38Z vgritsenko $
 */
public class EnumConvertorBuilder implements ConvertorBuilder {

    /* (non-Javadoc)
     * @see org.apache.cocoon.woody.datatype.convertor.ConvertorBuilder#build(org.w3c.dom.Element)
     */
    public Convertor build(Element configElement) throws Exception {
        if (configElement == null) {
            return null;
        }
        Element enumEl = DomHelper.getChildElement(configElement,
                Constants.WD_NS, "enum", true);
        String clazz = enumEl.getFirstChild().getNodeValue();
        return new EnumConvertor(clazz);
    }

}
