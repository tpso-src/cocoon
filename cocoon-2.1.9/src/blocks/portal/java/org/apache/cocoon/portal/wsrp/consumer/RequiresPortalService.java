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

import org.apache.cocoon.portal.PortalService;

/**
 * This interface marks a component if the component needs a reference to the
 * portal service.
 *
 * @version $Id: RequiresPortalService.java 264755 2005-08-30 10:29:21Z cziegeler $
 **/
public interface RequiresPortalService {

    void setPortalService(PortalService service);
}