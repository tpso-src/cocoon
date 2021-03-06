<?xml version="1.0"?>
<!--
  Copyright 2005 The Apache Software Foundation

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->

<!--+
    | $Id: include.xslt 157541 2005-03-15 14:26:31Z vgritsenko $
    +-->
<xsl:stylesheet version="1.0"
                xmlns:i="http://apache.org/cocoon/include/1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:param name="uri"/>

  <xsl:template match="/">
    <html>
      <i:include src="one.xml"/>
      <i:include src="cocoon:/{$uri}"/>
      <i:include src="two.xml"/>
    </html>
  </xsl:template>
</xsl:stylesheet>
