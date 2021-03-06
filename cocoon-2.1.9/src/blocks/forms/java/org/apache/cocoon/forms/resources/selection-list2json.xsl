<?xml version="1.0"?>
<!--
  Copyright 2006 The Apache Software Foundation

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
<!--
  Transforms a fi:selection-list into a JSON fragment.
  
  @version $Id: selection-list2json.xsl 385330 2006-03-12 18:25:06Z sylvain $
-->

<xsl:stylesheet
  version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:fi="http://apache.org/cocoon/forms/1.0#instance">

<xsl:template match="fi:selection-list">
  <dummy-root>
    <xsl:text>[&#10;</xsl:text>
    <xsl:apply-templates/>
    <xsl:text>&#10;];</xsl:text>
  </dummy-root>
</xsl:template>

<xsl:template match="fi:item">
  <xsl:text>["</xsl:text>
  <!-- displayed text -->
  <xsl:choose>
    <xsl:when test="fi:label">
      <xsl:value-of select="fi:label"/>
    </xsl:when>
    <xsl:otherwise>
      <xsl:value-of select="@value"/>
    </xsl:otherwise>
  </xsl:choose>
  <xsl:text>", "</xsl:text>
  <!-- value -->
  <xsl:value-of select="@value"/>
  <xsl:text>"]</xsl:text>
  <xsl:if test="position() != last()">
    <xsl:text>, &#10;</xsl:text>
  </xsl:if>
</xsl:template>

</xsl:stylesheet>