<?xml version="1.0"?>
<xsl:stylesheet version="l.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
    <html lang="en">
        <head>
            <meta charset="UTF-8"/>
        </head>
        <body>
            <h2>
                Receta: <xsl:value-of select="receta/@nombre"/>
            </h2>
            <p>
                Ingredientes: <xsl:value-of select="receta/ingrediente[1]/@nombre"/>
            </p>
            <p>
                Ingredientes: <xsl:value-of select="receta/ingrediente[2]/@nombre"/>
            </p>
            <p>
                Ingredientes: <xsl:value-of select="receta/ingrediente[3]/@nombre"/>
            </p>
            <p>
                Ingredientes: <xsl:value-of select="receta/ingrediente[4]/@nombre"/>
            </p>
            <p>
                Ingredientes: <xsl:value-of select="receta/ingrediente[5]/@nombre"/>
            </p>
            <p>
                Ingredientes: <xsl:value-of select="receta/ingrediente[6]/@nombre"/>
            </p>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>