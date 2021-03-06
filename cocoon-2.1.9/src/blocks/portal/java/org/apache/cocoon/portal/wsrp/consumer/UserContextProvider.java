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

/**
 * This component provides the {@link oasis.names.tc.wsrp.v1.types.UserContext}
 * for a portal user.
 * Cocoon uses an extension of the user context: {@link UserContextExtension}
 * to store additional information about the user.
 * 
 * @author <a href="mailto:cziegeler@s-und-n.de">Carsten Ziegeler</a>
 * @author <a href="mailto:malessandrini@s-und-n.de">Michel Alessandrini</a>
 *
 * @version $Id: UserContextProvider.java 264755 2005-08-30 10:29:21Z cziegeler $
 */
public interface UserContextProvider {

    /** The component role. */
    String ROLE = UserContextProvider.class.getName();

    /**
     * Delivers a <tt>UserContext</tt>-object for the given User-id <br />
     * the data will be read out of an individual location <br />
     * 
     * @param userId
     * @return UserContextExtension
     */
    UserContextExtension createUserContext(String userId);
}
