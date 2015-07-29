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
<!-- $Id: authenticate.xsl 30932 2004-07-29 17:35:38Z vgritsenko $ 

-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:param name="password"/>
<xsl:param name="name"/>

<xsl:template match="authentication">
	<authentication>
		<xsl:apply-templates select="users"/>
	</authentication>
</xsl:template>

<xsl:template match="users">
	<xsl:apply-templates select="user"/>
</xsl:template>

<xsl:template match="user">
	<xsl:if test="normalize-space(name) = $name and normalize-space(password) = $password">
		<ID><xsl:value-of select="name"/></ID>
		<role><xsl:value-of select="role"/></role>
		<data>
			<user><xsl:value-of select="name"/></user>
		</data>
	</xsl:if>
</xsl:template>

</xsl:stylesheet>
