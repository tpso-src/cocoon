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
package org.apache.cocoon.woody.generation;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import org.apache.avalon.framework.parameters.Parameters;
import org.apache.cocoon.ProcessingException;
import org.apache.cocoon.environment.SourceResolver;
import org.apache.cocoon.generation.AbstractGenerator;
import org.apache.cocoon.woody.Constants;
import org.apache.cocoon.woody.formmodel.Form;
import org.apache.cocoon.woody.transformation.WoodyPipelineConfig;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * A generator that streams an XML representation of a Woody {@link Form}. This will
 * recursively contain the XML for all widgets on the form. This can then be styled
 * using an XSLT.
 *
 * <p>An alternative approach that requires less (or even none) XSLT work is offered by
 * the {@link org.apache.cocoon.woody.transformation.WoodyTemplateTransformer WoodyTemplateTransformer}.
 *
 * <p>The Form whose XML should be produced should reside either 
 * <ol><li> In a request attribute, whose name should be provided to this 
 * generator as a sitemap parameter called "attribute-name".</li>
 * <li> Or else at its default-location in the flow context-object.</li>
 * </ol>
 * 
 * @version $Id: WoodyGenerator.java 30932 2004-07-29 17:35:38Z vgritsenko $
 */
public class WoodyGenerator extends AbstractGenerator {
    
    protected WoodyPipelineConfig config;
    private static final String FORM_GENERATED_EL = "form-generated";

    public void setup(SourceResolver resolver, Map objectModel, String src, Parameters par)
            throws ProcessingException, SAXException, IOException {
        super.setup(resolver, objectModel, src, par);
        
        this.config = WoodyPipelineConfig.createConfig(objectModel, parameters);            
    }

    public void recycle() {
        super.recycle();
        this.config = null;
    }

    public void generate() throws IOException, SAXException, ProcessingException {
        contentHandler.startDocument();
        contentHandler.startPrefixMapping(Constants.WI_PREFIX, Constants.WI_NS);
        Attributes formAtts = this.config.getFormAttributes();
        
        contentHandler.startElement(Constants.WI_NS, FORM_GENERATED_EL, Constants.WI_PREFIX_COLON +FORM_GENERATED_EL, formAtts);
        Form form = config.findForm(); 
        form.generateSaxFragment(contentHandler, Locale.US);
        contentHandler.endElement(Constants.WI_NS, FORM_GENERATED_EL, Constants.WI_PREFIX_COLON +FORM_GENERATED_EL);
        
        contentHandler.endPrefixMapping(Constants.WI_PREFIX);
        contentHandler.endDocument();
    }
}
