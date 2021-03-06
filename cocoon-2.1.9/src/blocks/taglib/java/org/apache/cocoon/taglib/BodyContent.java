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
package org.apache.cocoon.taglib;

import org.apache.cocoon.xml.XMLConsumer;
import org.apache.cocoon.xml.SaxBuffer;

/**
 * @version CVS $Id: BodyContent.java 158423 2005-03-21 09:15:22Z cziegeler $
 */
public class BodyContent {

    private SaxBuffer content;


    public BodyContent(SaxBuffer content, XMLConsumer consumer) {
        this.content = content;
    }

    public void clearBody() {
        this.content.recycle();
    }

    public SaxBuffer getContent() {
        return this.content;
    }

    public String getString() {
        return this.content.toString();
    }
}
