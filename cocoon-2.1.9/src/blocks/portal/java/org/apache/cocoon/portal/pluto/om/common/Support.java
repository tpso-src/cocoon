/*
 * Copyright 2004,2004 The Apache Software Foundation.
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
package org.apache.cocoon.portal.pluto.om.common;

/**
 * 
 *
 * @author <a href="mailto:cziegeler@apache.org">Carsten Ziegeler</a>
 * 
 * @version CVS $Id: Support.java 123407 2004-12-27 13:51:59Z cziegeler $
 */
public interface Support {

    int POST_LOAD  = 2;
    int PRE_BUILD  = 3;
    int POST_BUILD = 4;
    int PRE_STORE  = 5;
    int POST_STORE = 6;

    void postLoad(Object parameter) throws Exception;

    void preBuild(Object parameter) throws Exception;
    void postBuild(Object parameter) throws Exception;

    void preStore(Object parameter) throws Exception;
    void postStore(Object parameter) throws Exception;
}