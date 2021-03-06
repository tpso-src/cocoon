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
package org.apache.cocoon.forms;

import java.util.Locale;

import org.apache.cocoon.environment.Request;

/**
 * @version $Id: FormContext.java 56582 2004-11-04 10:16:22Z sylvain $
 * 
 */
public class FormContext {
    
    protected Request request;
    protected Locale locale;

    public FormContext(Request request, Locale locale) {
        this.request = request;
        this.locale = locale;
    }

    public FormContext(Request request) {
        this(request, request.getLocale());
    }

    public Request getRequest() {
        return request;
    }

    public Locale getLocale() {
        return locale;
    }
}
