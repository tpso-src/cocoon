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
package org.apache.cocoon.samples.parentcm;

import org.apache.avalon.framework.component.Component;
import org.apache.avalon.framework.thread.ThreadSafe;

import java.util.Date;

/**
 * Implementing class for the parent component manager sample's
 * <code>org.apache.cocoon.samples.parentcm.Time</code> component.
 * @author ?
 * @version CVS $Id: TimeComponent.java 30932 2004-07-29 17:35:38Z vgritsenko $
 */
public class TimeComponent implements Component, Time, ThreadSafe {
    public Date getTime () {
        return new Date();
    }
}

