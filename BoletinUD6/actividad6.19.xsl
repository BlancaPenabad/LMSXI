<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <html>
    <head>
    </head>
    <body>
        <h1>
            <xsl:value-of select="root/movie/@title"/>
        </h1>
        <p>Estreno: <xsl:value-of select="root/movie/@year"/></p>
        <p>Director: <xsl:value-of select="root/movie/@director"/></p>
        <p>Género: <xsl:value-of select="root/movie/@genre"/></p>
    </body>