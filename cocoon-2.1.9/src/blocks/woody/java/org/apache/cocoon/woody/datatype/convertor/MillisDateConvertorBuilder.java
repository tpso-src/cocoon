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

import org.w3c.dom.Element;

/**
 * Builds {@link MillisDateConvertor}s.
 *
 * @version CVS $Id: MillisDateConvertorBuilder.java 30932 2004-07-29 17:35:38Z vgritsenko $
 */
public class MillisDateConvertorBuilder implements ConvertorBuilder {
    public Convertor build(Element configElement) {
        return new MillisDateConvertor();
    }
}