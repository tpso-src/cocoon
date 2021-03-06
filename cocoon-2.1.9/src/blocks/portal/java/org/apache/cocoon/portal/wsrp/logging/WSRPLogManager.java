/*
 * Copyright 2005 The Apache Software Foundation.
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
package org.apache.cocoon.portal.wsrp.logging;

import org.apache.wsrp4j.log.LogManager;
import org.apache.wsrp4j.log.Logger;

/**
 * This log manager implementation just always returns the portal logger.<br/>
 * 
 * @author <a href="mailto:cziegeler@s-und-n.de">Carsten Ziegeler</a>
 * @author <a href="mailto:malessandrini@s-und-n.de">Michel Alessandrini</a>
 *
 * @version $Id: WSRPLogManager.java 264755 2005-08-30 10:29:21Z cziegeler $
 */
public class WSRPLogManager extends LogManager {

    /** The logger-object */
    protected final WSRPLogger logger;

    /**
     * constructor<br/>
     * 
     * @param logger
     */
    public WSRPLogManager(WSRPLogger logger) {
        this.logger = logger;
    }

    /**
     * @see org.apache.wsrp4j.log.LogManager#getLogger(java.lang.Class)
     */
    public Logger getLogger(Class arg0) {
        return this.logger;
    }

}
