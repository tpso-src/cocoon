/*
 * Copyright 1999-2005 The Apache Software Foundation.
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
package org.apache.cocoon.portal.tools.userManagement;

/**
 * Capsule a key and its value of an user context 
 * 
 * @version CVS $Id: ContextItem.java 149055 2005-01-29 18:21:34Z cziegeler $
 */
public class ContextItem {
	
	private final String key;
	private final String value;
	
	public ContextItem(String key, String value){
		this.key = key;
		this.value = value;
	}
	
	
	public String getKey() {
		return key;
	}
    
	public String getValue() {
		return value;
	}
}
