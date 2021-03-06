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
package org.apache.cocoon.template.script.event;

/**
 * @version SVN $Id: CopyAttribute.java 169632 2005-05-11 12:08:34Z lgawron $
 */
public class CopyAttribute extends AttributeEvent {
    public CopyAttribute(String namespaceURI, String localName, String raw,
            String type, String value) {
        super(namespaceURI, localName, raw, type);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private final String value;
}