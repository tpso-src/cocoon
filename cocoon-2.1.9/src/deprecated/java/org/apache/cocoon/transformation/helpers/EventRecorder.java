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
package org.apache.cocoon.transformation.helpers;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 * Can send recorded events and be cloned.
 *
 * @deprecated The only user of this class (I18nTransformer) now uses ParamSaxBuffer
 * @author <a href="mailto:mattam@netcourrier.com">Matthieu Sozeau</a>
 * @version $Id: EventRecorder.java 159723 2005-04-01 20:00:55Z vgritsenko $
 */
public interface EventRecorder {
    public void send(ContentHandler handler)
	throws SAXException;

    public Object clone();
}
