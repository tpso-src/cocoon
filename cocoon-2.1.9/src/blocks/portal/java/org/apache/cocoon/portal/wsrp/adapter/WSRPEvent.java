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
package org.apache.cocoon.portal.wsrp.adapter;

import java.util.Map;

import org.apache.cocoon.portal.coplet.CopletInstanceData;
import org.apache.cocoon.portal.event.CopletInstanceEvent;

/**
 * This event is fired for every wsrp action. <br/>
 * 
 * @author <a href="mailto:cziegeler@s-und-n.de">Carsten Ziegeler</a>
 * @author <a href="mailto:malessandrini@s-und-n.de">Michel Alessandrini</a>
 * 
 * @version $Id: WSRPEvent.java 264755 2005-08-30 10:29:21Z cziegeler $
 */
public class WSRPEvent
    implements CopletInstanceEvent {

    /** The corresponding coplet instance data. */
    protected final CopletInstanceData coplet;

    /** The parameters for the wsrp url. */
    protected final Map producerParams;

    /**
     * constructor
     * 
     * @param coplet corresponding coplet instance data
     * @param pParams producer-parameters
     */
    public WSRPEvent(CopletInstanceData coplet, Map pParams) {
        this.coplet = coplet;
        this.producerParams = pParams;
    }

    /**
     * @see org.apache.cocoon.portal.event.ActionEvent#getTarget()
     */
    public Object getTarget() {
        return this.coplet;
    }

    /**
     * @return Map all parameters for the wsrp url.
     */
    public Map getUrlParameters() {
        return this.producerParams;
    }

}
