/*
 * Copyright 1999-2002,2004 The Apache Software Foundation.
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
package org.apache.cocoon.portal.event;

import java.io.Serializable;

/**
 * A Filter allows subscribers to specify which events
 * they should be informed of.
 * It is Serializable to allow events to be published and received
 * in a distributed architecture.
 *
 * @author <a href="mailto:cziegeler@s-und-n.de">Carsten Ziegeler</a>
 * @author <a href="mailto:volker.schmitt@basf-it-services.com">Volker Schmitt</a>
 * @author Mauro Talevi
 * @deprecated Use the receiver instead.
 *
 * @version CVS $Id: Filter.java 219049 2005-07-14 15:11:52Z cziegeler $
 */
public interface Filter extends Serializable {

    /**
     * Filters event, discarding those not of interest to the subscriber.
     *
     * @param event the <tt>Event</tt>
     * @return boolean <code>true</code> if Event passes filter
     */
    boolean filter( Event event );

}
