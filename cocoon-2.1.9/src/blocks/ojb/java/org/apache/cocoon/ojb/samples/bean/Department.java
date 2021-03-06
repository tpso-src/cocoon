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
package org.apache.cocoon.ojb.samples.bean;

import java.io.Serializable;

/**
 *  Department's Bean
 *
 * @author <a href="mailto:antonio@apache.org">Antonio Gallardo</a>
 * @version CVS $Id: Department.java 30932 2004-07-29 17:35:38Z vgritsenko $
*/
public class Department implements Serializable {

    private int id;
    protected String name;

    public Department(){
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int newId) {
        id = newId;
    }

    public void setName(String newName) {
        name = newName;
    }
}
