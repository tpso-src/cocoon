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
package org.apache.cocoon;

/**
 * This Exception is thrown every time a component detects an exception
 * due to a connection reset by peer.
 *
 * @author <a href="mailto:bloritsch@apache.org">Berin Loritsch</a>
 * @version CVS $Id: ConnectionResetException.java 226786 2005-08-01 13:10:02Z sylvain $
 */
public class ConnectionResetException extends ProcessingException {

    /**
     * Construct a new <code>ConnectionResetException</code> instance.
     *
     * @param message a <code>String</code> value
     */
    public ConnectionResetException(String message) {
        super(message);
    }

    /**
     * Construct a new <code>ConnectionResetException</code> that references
     * a parent Exception.
     *
     * @param message a <code>String</code> value
     * @param t a <code>Throwable</code> value
     */
    public ConnectionResetException(String message, Throwable t) {
        super(message, t);
    }
}
