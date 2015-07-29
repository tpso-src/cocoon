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
package org.apache.cocoon.components.treeprocessor;

/**
 * A <code>ProcessingNode</code> builder that links its node to
 * other nodes in the hierarchy. This allows to turn the node tree
 * into a directed graph.
 *
 * @author <a href="mailto:sylvain@apache.org">Sylvain Wallez</a>
 * @version CVS $Id: LinkedProcessingNodeBuilder.java 30932 2004-07-29 17:35:38Z vgritsenko $
 */

public interface LinkedProcessingNodeBuilder extends ProcessingNodeBuilder {

    /**
     * Resolve the links needed by the node built by this builder.
     */
    void linkNode() throws Exception;
}
