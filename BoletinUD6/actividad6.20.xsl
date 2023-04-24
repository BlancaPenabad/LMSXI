<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output encoding="UTF-8" indent="yes" method="xml"/>
<xsl:template match="hotel">
    <habitaciones> 
        <xsl:apply-templates select="//habitacion[capacidad>4]"/>
    </habitaciones>
</xsl:template>

<xsl:template match="habitacion">
    <xsl:element name="habitacion">
        <xsl:attribute name="numero">
            <xsl:value-of select="@numero"/>
        </xsl:attribute>
        <xsl:element name="capacidad">
            <xsl:value-of select="capacidad"/>
        </xsl:element>
        <xsl:element name="camas">
            <xsl:value-of select="ccamas"/>
        </xsl:element>
        <xsl:element name="aa">
            <xsl:value-of select="aa"/>
        </xsl:element>
    </xsl:element>
</xsl:template>
</xsl:stylesheet>