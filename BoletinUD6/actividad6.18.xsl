<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>My CD Collection</h2>
  <table border="1">
    <tr bgcolor="#33E3FF">
      <th style="text-align:left">FECHA</th>
      <th style="text-align:left">Temperatura mínima</th>
    </tr>
    <xsl:for-each select="//root/prediccion/dia">
    <tr>
      <td><xsl:value-of select="@fecha"/></td>
      <td><xsl:value-of select="temperatura/minima"/></td>
    </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
