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

import java.util.Iterator;

import org.apache.cocoon.components.expression.ExpressionContext;
import org.apache.cocoon.template.environment.ErrorHolder;
import org.apache.cocoon.template.environment.ExecutionContext;
import org.apache.cocoon.template.environment.ParsingContext;
import org.apache.cocoon.template.expression.JXTExpression;
import org.apache.cocoon.template.expression.Literal;
import org.apache.cocoon.template.expression.Subst;
import org.apache.cocoon.template.instruction.MacroContext;
import org.apache.cocoon.template.script.Invoker;
import org.apache.cocoon.xml.XMLConsumer;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @version SVN $Id: Characters.java 279084 2005-09-06 20:10:53Z lgawron $
 */
public class Characters extends TextEvent {
    public Characters(ParsingContext parsingContext, Locator location, char[] chars, int start, int length)
            throws SAXException {
        super(parsingContext, location, chars, start, length);
    }

    public Event execute(XMLConsumer consumer,
            ExpressionContext expressionContext,
            ExecutionContext executionContext, MacroContext macroContext,
            Event startEvent, Event endEvent) throws SAXException {
        Iterator iter = getSubstitutions().iterator();
        while (iter.hasNext()) {
            Subst subst = (Subst) iter.next();
            char[] chars;
            if (subst instanceof Literal) {
                chars = ((Literal) subst).getCharArray();
                consumer.characters(chars, 0, chars.length);
            } else {
                JXTExpression expr = (JXTExpression) subst;
                try {
                    Object val = expr.getNode(expressionContext);
                    Invoker.executeNode(consumer, val);
                } catch (Exception e) {
                    throw new SAXParseException(e.getMessage(), getLocation(), e);
                } catch (Error err) {
                    throw new SAXParseException(err.getMessage(), getLocation(), new ErrorHolder(err));
                }
            }
        }
        return getNext();
    }
}