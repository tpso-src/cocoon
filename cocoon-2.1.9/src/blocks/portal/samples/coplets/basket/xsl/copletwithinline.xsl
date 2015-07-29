<?xml version="1.0"?>
<!--
  Copyright 1999-2004 The Apache Software Foundation

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
<!-- SVN $Id: copletwithinline.xsl 126209 2005-01-23 11:32:10Z cziegeler $ -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                              xmlns:coplet="http://apache.org/cocoon/portal/coplet/1.0">

  <xsl:param name="value"/>
  <xsl:param name="coplet"/>

  <xsl:template match="value">
    <xsl:choose>
      <xsl:when test="$value = ''">0</xsl:when>
      <xsl:otherwise><xsl:value-of select="$value"/></xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  
  <xsl:template match="plus">
    <xsl:variable name="definedvalue">
      <xsl:choose>
        <xsl:when test="$value = ''">0</xsl:when>
        <xsl:otherwise><xsl:value-of select="$value"/></xsl:otherwise>
      </xsl:choose>
    </xsl:variable>
    <coplet:link coplet="{$coplet}" path="attributes/value" value="{$definedvalue + 1}"/>
    <coplet:content><input type="submit" name="{.}" value="{.}"/></coplet:content>
  </xsl:template>

  <xsl:template match="@*|node()" ><xsl:copy><xsl:apply-templates select="@*|node()"/></xsl:copy></xsl:template>
</xsl:stylesheet>
