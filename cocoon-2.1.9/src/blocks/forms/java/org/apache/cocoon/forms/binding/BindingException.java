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
package org.apache.cocoon.forms.binding;

import org.apache.cocoon.util.location.LocatedException;
import org.apache.cocoon.util.location.Location;

/**
 * This exception is thrown when something goes wrong with the binding.
 *
 * @version $Id: BindingException.java 290473 2005-09-20 15:30:48Z sylvain $
 */
public class BindingException extends LocatedException {

    public BindingException(String message, Location location) {
        super(message, location);
        // TODO Auto-generated constructor stub
    }

    public BindingException(String message, Throwable cause, Location location) {
        super(message, cause, location);
        // TODO Auto-generated constructor stub
    }

    public BindingException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public BindingException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

}
