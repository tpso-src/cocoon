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
package org.apache.cocoon.caching;

import java.io.Serializable;
/**
 * This is the cache key for one sitemap component.
 * It consists of three parts:<br/>
 * a.) The component type (generator, transformer etc.)<br/>
 * b.) The component identifier - a unique handle for the sitemap
 *      component<br/>
 * c.) The cache key - a key, generated by the component, which
 *      is unique inside the components space.
 *
 * @author <a href="mailto:cziegeler@apache.org">Carsten Ziegeler</a>
 * @version CVS $Id: ComponentCacheKey.java 30932 2004-07-29 17:35:38Z vgritsenko $
 */
public final class ComponentCacheKey
    implements Serializable {

    public static final int ComponentType_Generator   = 1;
    public static final int ComponentType_Transformer = 3;
    public static final int ComponentType_Serializer  = 5;
    public static final int ComponentType_Reader      = 7;

    // Converts Generator / Transformer / Serializer / Reader constants above
    // into string.
    private static final String[] COMPONENTS = { "X", "G", "X", "T", "X", "S", "X", "R" };

    /** The component type */
    private final int type;
    /** The component identifier */
    private final String identifier;
    /** The unique key */
    private final Serializable key;
    /** the hash code */
    private final int hashCode;
    /** cachePoint */
    private final boolean cachePoint;

    /**
     * Constructor
     */
    public ComponentCacheKey(int          componentType,
                             String       componentIdentifier,
                             Serializable cacheKey) {
        this(componentType, componentIdentifier, cacheKey, false);
    }

    /**
     * alternate cachepoint Constructor
     */
    public ComponentCacheKey(int          componentType,
                             String       componentIdentifier,
                             Serializable cacheKey,
			     boolean cachePoint) {
        this.type = componentType;
        this.identifier = componentIdentifier;
        this.key = cacheKey;
        /** cachePoint */
        this.cachePoint = cachePoint;
        this.hashCode = this.type +
                (this.identifier.length() << 3) +
                this.key.hashCode();
    }

    /**
     * Compare
     */
    public boolean equals(Object object) {
        if (object instanceof ComponentCacheKey) {
            ComponentCacheKey ccp = (ComponentCacheKey)object;
            if (this.type == ccp.type
                && this.identifier.equals(ccp.identifier)
                && this.key.equals(ccp.key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * HashCode
     */
    public int hashCode() {
        return this.hashCode;
    }

    private String toString;

    /**
     * toString
     * The FilesystemStore uses toString!
     */
    public String toString() {
        if (this.toString == null) {
            toString = COMPONENTS[this.type] + '-' + this.identifier + '-' + this.key.toString();
        }
        return toString;
    }

    /**
     * Check if we are a cachepoint 
     */
    public boolean isCachePoint() {
        return cachePoint;
    }
}
