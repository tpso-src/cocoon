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

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	
  <xsl:param name="header"/>

  <xsl:template match="/">
    <html>
      <head>
        <title>
          <xsl:value-of select="/site/document/title"/>
        </title>
	<link rel="shortcut icon" href="favicon.ico"/>
        <style type="text/css">
a.menu {
	color: #FFFFFF;
    text-align:left;
    font-size:12px;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    font-weight:plain;
    text-decoration:none;
    padding-left: 14px
}

a.menu:hover {
	color: #FFCC00
}

.menutitle {
	color: #000000;
    text-align:left;
    font-size:10px;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    font-weight:bold;
    padding-left: 8px
}
.menuselected {
	color: #FFCC00;
    text-align:left;
    font-size:12px;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    font-weight:bold;
    padding-left: 14px
}
        </style>
      </head>

      <body text="#000000" link="#039acc" vlink="#0086b2" alink="#cc0000" topmargin="4" leftmargin="4" marginwidth="4" marginheight="4" bgcolor="#ffffff">
        <!-- THE TOP BAR (HEADER) -->
        <table width="100%" cellspacing="0" cellpadding="0" border="0">
          <tr>
            <td width="135" height="60" rowspan="3" valign="top" align="left">
              <img width="135" height="60" src="images/logo.gif" hspace="0" vspace="0" border="0"/>
            </td>
            <td width="100%" height="0" valign="top" align="left" colSpan="2" rowspan="1" background="images/line.gif"></td>
            <td width="29" height="60" rowspan="3" valign="top" align="left">
              <img width="29" height="60" src="images/right.gif" hspace="0" vspace="0" border="0"/>
            </td>
          </tr>
          <tr>
            <td width="100%" height="35" valign="top" align="right" colspan="2" bgcolor="#0086b2">
              <font size="5" face="Verdana, Arial, Helvetica, sans-serif" color="#ffffff">
                <xsl:value-of select="/site/document/title"/>
              </font>
            </td>
          </tr>
          <tr>
            <td align="right" bgcolor="#0086b2" height="20" valign="top" width="100%" colspan="2" background="images/bottom.gif">
              <table border="0" cellpadding="0" cellspacing="0" width="288">
                <tr>
                  <td width="96" height="20" valign="top" align="left">
                    <a href="http://xml.apache.org/" target="new">
                      <img alt="http://xml.apache.org/" width="96" height="20" src="images/button-xml-lo.gif" name="xml" hspace="0" vspace="0" border="0"/>
                    </a>
                  </td>
                  <td width="96" height="20" valign="top" align="left">
                    <a href="http://www.apache.org/" target="new">
                      <img alt="http://www.apache.org/" width="96" height="20" src="images/button-asf-lo.gif" name="asf" hspace="0" vspace="0" border="0"/>
                    </a>
                  </td>
                  <td width="96" height="20" valign="top" align="left">
                    <a href="http://www.w3.org/" target="new">
                      <img alt="http://www.w3.org/" width="96" height="20" src="images/button-w3c-lo.gif" name="w3c" hspace="0" vspace="0" border="0"/>
                    </a>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
        </table>

        <table border="0" cellpadding="0" cellspacing="0" width="100%">
          <tr width="100%">
	        <!-- THE SIDE BAR -->
            <td width="120" valign="top" align="left">
              <table bgcolor="#a0a0a0" border="0" cellpadding="0" cellspacing="0" width="120">
                <tr>
                  <td align="left" valign="top">
                    <img border="0" height="14" hspace="0" src="images/join.gif" vspace="0" width="120"/>
                    <br/>
                  </td>
                </tr>
                <xsl:copy-of select="/site/menu/node()"/>
                <tr>
                  <td valign="top" align="left">
                    <img border="0" height="14" hspace="0" src="images/close.gif" vspace="0" width="120"/>
                    <br/>
                  </td>
                </tr>
              </table>
            </td>
            <!-- THE CONTENTS -->
            <td>
              <table border="0" cellpadding="0" cellspacing="15">
                <tr>
                  <td>
                    <xsl:copy-of select="/site/document/body/node()"/>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
        </table>

        <table border="0" cellpadding="0" cellspacing="0" width="100%">
          <tr>
            <td bgcolor="#0086b2">
              <img height="1" src="images/dot.gif" width="1"/>
            </td>
          </tr>
          <tr>
            <td align="center">
              <font color="#0086b2" face="arial,helvetica,sanserif" size="-1">
                <i>Copyright &#169; @year@ The Apache Software Foundation. All Rights Reserved.</i>
              </font>
            </td>
          </tr>
        </table>

      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
