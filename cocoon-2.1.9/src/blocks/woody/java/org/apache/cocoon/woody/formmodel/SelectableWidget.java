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
package org.apache.cocoon.woody.formmodel;

import org.apache.cocoon.woody.datatype.SelectionList;

/**
 * @version $Id: SelectableWidget.java 54079 2004-10-08 13:30:28Z vgritsenko $
 * 
 */
public interface SelectableWidget extends Widget {

    public void setSelectionList(SelectionList selectionList);

    public void setSelectionList(String uri);

    public void setSelectionList(Object model, String valuePath, String labelPath);
}