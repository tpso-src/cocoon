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
package org.apache.cocoon.forms.formmodel;

import org.apache.cocoon.forms.validation.WidgetValidator;

/**
 * The {@link WidgetDefinition} part of a {@link Output} widget.
 *
 * @version $Id: OutputDefinition.java 165679 2005-05-02 20:34:49Z vgritsenko $
 */
public class OutputDefinition extends AbstractDatatypeWidgetDefinition {
    public Widget createInstance() {
        return new Output(this);
    }

    public void addValidator(WidgetValidator validator) {
        throw new UnsupportedOperationException("Output widget does not support validators");
    }
}
