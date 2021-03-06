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

import org.apache.cocoon.forms.datatype.Datatype;
import org.apache.cocoon.forms.datatype.DatatypeManager;
import org.w3c.dom.Element;

/**
 * Builds {@link IntegerType}s.
 * 
 * @version $Id: IntegerTypeBuilder.java 359084 2005-12-26 18:21:33Z cziegeler $
 */
public class IntegerTypeBuilder extends AbstractDatatypeBuilder {
	public Datatype build(Element datatypeElement, boolean arrayType, DatatypeManager datatypeManager) throws Exception {
		IntegerType type = new IntegerType();
		type.setArrayType(arrayType);
		type.setBuilder(this);

		buildValidationRules(datatypeElement, type, datatypeManager);
		buildConvertor(datatypeElement, type);

		return type;
	}
}
