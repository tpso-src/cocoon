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
package org.apache.cocoon.forms.datatype.typeimpl;

/**
 * A {@link org.apache.cocoon.forms.datatype.Datatype Datatype} implementation for
 * java.lang.Boolean's.
 * @version $Id: BooleanType.java 56582 2004-11-04 10:16:22Z sylvain $
 */
public class BooleanType extends AbstractDatatype {
    public Class getTypeClass() {
        return Boolean.class;
    }

    public String getDescriptiveName() {
        return "boolean";
    }
}
