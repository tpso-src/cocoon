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
package org.apache.cocoon.forms.datatype.convertor;

/**
 * Builds {@link FormattingLongConvertor}s.
 *
 * @version $Id: FormattingLongConvertorBuilder.java 151179 2005-02-03 16:55:16Z tim $
 */
public class FormattingLongConvertorBuilder extends FormattingDecimalConvertorBuilder {
    protected FormattingDecimalConvertor createConvertor() {
        return new FormattingLongConvertor();
    }
}