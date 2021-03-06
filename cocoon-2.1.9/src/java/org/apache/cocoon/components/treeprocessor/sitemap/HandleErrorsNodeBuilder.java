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
package org.apache.cocoon.components.treeprocessor.sitemap;

import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.thread.ThreadSafe;

import org.apache.cocoon.components.treeprocessor.AbstractParentProcessingNodeBuilder;
import org.apache.cocoon.components.treeprocessor.ProcessingNode;

/**
 * Builds a &lt;map:handle-errors&gt;
 *
 * @author <a href="mailto:sylvain@apache.org">Sylvain Wallez</a>
 * @version $Id: HandleErrorsNodeBuilder.java 157541 2005-03-15 14:26:31Z vgritsenko $
 */
public class HandleErrorsNodeBuilder extends AbstractParentProcessingNodeBuilder
                                     implements ThreadSafe {

    /** This builder has no parameters -- return <code>false</code> */
    protected boolean hasParameters() {
        return false;
    }

    public ProcessingNode buildNode(Configuration config) throws Exception {

        HandleErrorsNode node = new HandleErrorsNode(config.getAttributeAsInteger("type", -1),
                                                     config.getAttribute("when", "external"));
        this.treeBuilder.setupNode(node, config);

        // Set a flag that will prevent redirects
        ((SitemapLanguage) this.treeBuilder).setBuildingErrorHandler(true);
        try {
            // Get all children
            node.setChildren(buildChildNodes(config));
        } finally {
            // And clear the flag
            ((SitemapLanguage) this.treeBuilder).setBuildingErrorHandler(false);
        }

        return node;
    }
}
