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
package org.apache.cocoon.components.cron;

import org.apache.avalon.framework.logger.AbstractLogEnabled;
import org.apache.avalon.framework.service.ServiceException;
import org.apache.avalon.framework.service.ServiceManager;
import org.apache.avalon.framework.service.Serviceable;


/**
 * Serviceable CronJob
 *
 * @author <a href="http://apache.org/~reinhard">Reinhard Poetz</a> 
 * @version CVS $Id: ServiceableCronJob.java 30932 2004-07-29 17:35:38Z vgritsenko $
 *
 * @since 2.1.4
 */
public abstract class ServiceableCronJob extends AbstractLogEnabled
    implements CronJob, Serviceable {
    

    /** The service manager */
    protected ServiceManager manager;


	public void service(ServiceManager manager) throws ServiceException {
		this.manager = manager;
	}

    
}
