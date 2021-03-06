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
package org.apache.cocoon.forms.binding.library;



/**
 * The work interface for the LibraryManager, the class that
 * manages all used library definitions so they can be shared between
 * forms.
 * 
 * @version $Id: LibraryManager.java 289538 2005-09-16 13:46:22Z sylvain $
 *
 */
public interface LibraryManager {

	String ROLE = LibraryManager.class.getName();
	
	Library getLibrary(String librarysource) throws Exception;
	Library getLibrary(String librarysource, String relative) throws Exception;
	Library getNewLibrary();
	
	boolean libraryInCache(String librarysource) throws Exception;
	boolean libraryInCache(String librarysource, String relative) throws Exception;
	
	void debug(String msg);
}
