<?xml version="1.0"?>
<xsl:stylesheet version="l.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html lang="en">
<head>
<meta charset="UTF-8"/>
</head>
<body>
<h2>
VEHÍCULO: <xsl:value-of select="vehiculo/marca"/>
</h2>
<p>
Web: <xsl:value-of select="vehiculo/web"/>
</p>
<p>
Modelo: <xsl:value-of select="vehiculo/modelo"/>
</p>
<p>
Precio: <xsl:value-of select="vehiculo/precio"/>
</p>
</body>
</html>
</xsl:template>
</xsl:stylesheet>