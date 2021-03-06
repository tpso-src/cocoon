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
package org.apache.cocoon.serialization;

import org.apache.cocoon.sitemap.SitemapOutputComponent;
import org.apache.cocoon.xml.XMLConsumer;

/**
 * A serializer is the last point of a pipeline. It "serializes" XML
 * arriving as SAX events into any binary format. <br> Serializers can 
 * additionally implement the {@link org.apache.cocoon.sitemap.SitemapModelComponent} 
 * interface to gain access to the <code>resolver</code>, <code>objectModel</code>, 
 * <code>source</code> or <code>parameters</code> objects.
 *
 * @author <a href="mailto:pier@apache.org">Pierpaolo Fumagalli</a>
 *         (Apache Software Foundation)
 * @version CVS $Id: Serializer.java 349233 2005-11-27 13:46:46Z sylvain $
 */
public interface Serializer extends XMLConsumer, SitemapOutputComponent {

    String ROLE = Serializer.class.getName();
}
