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
package org.apache.cocoon.forms.datatype;

import java.util.Locale;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 * Extension of {@link org.apache.cocoon.forms.datatype.SelectionList} that can be filtered. Used
 * primarily to build suggestion lists.
 * 
 * @since 2.1.9
 * @version $Id: FilterableSelectionList.java 385330 2006-03-12 18:25:06Z sylvain $
 */
public interface FilterableSelectionList extends SelectionList {
    
    /**
     * Generates the filtered selection list
     * 
     * @param contentHandler where to stream the XML
     * @param locale the locale to be used for value formatting
     * @param filter the filter string
     * @throws SAXException
     */
    void generateSaxFragment(ContentHandler contentHandler, Locale locale, String filter) throws SAXException;
}
