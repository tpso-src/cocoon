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

import java.io.OutputStream;

import de.tivano.flash.swf.publisher.SWFWriter;

/**
 * uses the project http://developer.berlios.de/projects/spark-xml/
 *
 * @author <a href="mailto:tcurdt@apache.org">Torsten Curdt</a>
 * @version CVS $Id: SWFSerializer.java 105790 2004-11-19 07:37:46Z antonio $
 */
public class SWFSerializer extends AbstractSerializer  {
    
    private final static String mimeType = "application/x-shockwave-flash";

    private SWFWriter handler;

    public String getMimeType() {
        return mimeType;
    }

    public void setOutputStream(OutputStream out) {
        handler = new SWFWriter(out);
        this.contentHandler = handler;
    }
}
