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
package org.apache.cocoon.portal.wsrp.consumer;

import org.apache.wsrp4j.consumer.driver.GenericUserRegistryImpl;

/**
 * User registry storing all users in a {@link java.util.Hashtable}
 * in memory. The user registry is filled by the wsrp adapter.
 *
 * @author <a href="mailto:cziegeler@s-und-n.de">Carsten Ziegeler</a>
 * @author <a href="mailto:malessandrini@s-und-n.de">Michel Alessandrini</a>
 *
 * @version $Id: UserRegistryImpl.java 264755 2005-08-30 10:29:21Z cziegeler $
 */
public class UserRegistryImpl extends GenericUserRegistryImpl {

    /**
     * Default constructor
     */
    public UserRegistryImpl() {
        super();
    }
}
