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
package org.apache.cocoon.template.instruction;

import org.apache.cocoon.template.script.event.EndInstruction;
import org.apache.cocoon.template.script.event.Event;
import org.apache.cocoon.template.script.event.StartElement;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * @version SVN $Id: Instruction.java 169632 2005-05-11 12:08:34Z lgawron $
 */
public abstract class Instruction extends Event {
    public Instruction(Locator locator) {
        super(locator);
        startElement = null;
    }

    public Instruction(StartElement startElement) {
        super(startElement.getLocation());
        this.startElement = startElement;
    }

    protected final StartElement startElement;
    private EndInstruction endInstruction;

    public EndInstruction getEndInstruction() {
        return endInstruction;
    }

    public void setEndInstruction(EndInstruction endInstruction) {
        this.endInstruction = endInstruction;
    }

    public void endNotify() throws SAXException {
        return;
    }

    public StartElement getStartElement() {
        return startElement;
    }
}
