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

import org.apache.wsrp4j.consumer.PortletWindowSession;

/**
 * Defines a portlet window session used by the cocoon portal
 * In additional to <code>SimplePortletWindowSession</code>
 * it contains information about the current window state and mode of a portlet window.<br/>
 *
 * @author <a href="mailto:cziegeler@s-und-n.de">Carsten Ziegeler</a>
 * @author <a href="mailto:malessandrini@s-und-n.de">Michel Alessandrini</a>
 *
 * @version $Id: SimplePortletWindowSession.java 264755 2005-08-30 10:29:21Z cziegeler $
 **/
public interface SimplePortletWindowSession extends PortletWindowSession {

	/**
	 * Get the window state of the portlet window 
	 * this session belongs to.<br/>
	 * 
	 * @return the window state
	 **/
	String getWindowState();

	/**
	 * Set the window state of the portlet window
	 * this session belongs to.<br/>
	 * 
	 * @param windowState The window state
	 **/
	void setWindowState(String windowState);

	/**
	 * Get the portlet mode of the portlet window.<br/>
	 * 
	 * @return The portlet mode 
	 **/
	String getMode();

	/**
	 * Set the portlet mode of the portlet window.<br/>
	 * 
	 * @param mode The portlet mode
	 **/
	void setMode(String mode);
	
	/**
	 * Get the navigational state for the portlet window the session belongs to<br/>
     * 
	 * @return the navigational state
	 **/
	String getNavigationalState();
	
	/**
	 * Set the navigational state for the portlet window the session belongs to<br/>
     * 
	 * @param navState the navigational state
	 **/
	void setNavigationalState(String navState);
}
