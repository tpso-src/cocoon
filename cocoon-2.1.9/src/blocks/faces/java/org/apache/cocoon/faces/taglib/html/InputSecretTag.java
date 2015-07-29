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
package org.apache.cocoon.faces.taglib.html;

import javax.faces.component.UIComponent;

/**
 * @version CVS $Id: InputSecretTag.java 46253 2004-09-17 14:36:29Z vgritsenko $
 */
public class InputSecretTag extends InputTextTag {

    private String redisplay;


    public void setRedisplay(String redisplay) {
        this.redisplay = redisplay;
    }


    public String getRendererType() {
        return "javax.faces.Secret";
    }

    public String getComponentType() {
        return "javax.faces.HtmlInputSecret";
    }


    protected void setProperties(UIComponent component) {
        super.setProperties(component);

        setBooleanProperty(component, "redisplay", redisplay);
    }

    public void recycle() {
        super.recycle();
        redisplay = null;
    }
}
