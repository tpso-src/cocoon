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
package org.apache.cocoon.template.environment;

import java.io.Serializable;

/**
 * @version SVN $Id: JXCacheKey.java 169632 2005-05-11 12:08:34Z lgawron $
 */
public final class JXCacheKey implements Serializable {
    private final String templateUri;
    private final Serializable templateKey;

    public JXCacheKey(String templateUri, Serializable templateKey) {
        this.templateUri = templateUri;
        this.templateKey = templateKey;
    }

    public int hashCode() {
        return templateUri.hashCode() + templateKey.hashCode();
    }

    public String toString() {
        return "jxtg:" + templateUri + "_" + templateKey;
    }

    public boolean equals(Object o) {
        if (o instanceof JXCacheKey) {
            JXCacheKey jxck = (JXCacheKey) o;
            return this.templateUri.equals(jxck.templateUri)
                    && this.templateKey.equals(jxck.templateKey);
        }
        return false;
    }
}