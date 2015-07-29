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

import org.apache.cocoon.components.expression.ExpressionContext;
import org.apache.cocoon.template.environment.ExecutionContext;
import org.apache.cocoon.template.environment.ParsingContext;
import org.apache.cocoon.template.instruction.MacroContext;
import org.apache.cocoon.xml.XMLConsumer;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * @version SVN $Id: IgnorableWhitespace.java 279084 2005-09-06 20:10:53Z lgawron $
 */
public class IgnorableWhitespace extends TextEvent {
    public IgnorableWhitespace(ParsingContext parsingContext, Locator location, char[] chars, int start, int length)
            throws SAXException {
        super(parsingContext, location, chars, start, length);
    }

    public Event execute(final XMLConsumer consumer, ExpressionContext expressionContext,
            ExecutionContext executionContext, MacroContext macroContext, Event startEvent, Event endEvent)
            throws SAXException {
        characters(expressionContext, executionContext, this, new CharHandler() {
            public void characters(char[] ch, int offset, int len) throws SAXException {
                consumer.ignorableWhitespace(ch, offset, len);
            }
        });
        return getNext();
    }
}