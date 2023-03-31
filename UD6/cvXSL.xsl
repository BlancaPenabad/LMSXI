<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <html>
        <style>
            body {
                background-color: peachpuff;
            }
            h3 {
                text-transform: uppercase;
                font-size: 2em;
            }
            #datos {
                padding: 1em;
            }
            #formacion {
                padding: 1em;
            }
            #experiencia {
                padding: 1em;
            }
            h4 {
                text-transform: uppercase;
                font-size: 1em;
            }

        </style>
        <head>
            <meta charset="UTF-8"/>
        </head>
        <body>
            <h3>
                <xsl:value-of select="cv/nombre"/>
            </h3>
            <div id="datos">
                <h4>
                    <xsl:value-of select="cv/contacto/cabecera"/>
                </h4>
                <li>
                    <ul><xsl:value-of select="cv/residencia"/></ul>
                    <ul><xsl:value-of select="cv/contacto/telefono"/></ul>
                    <ul><xsl:value-of select="cv/contacto/email"/></ul>
                </li>
            </div>
            <div id="formacion">
                <h4>
                    <xsl:value-of select="cv/formación/cabecera"/>
                </h4>
                <xsl:value-of select="cv/formación/titulo/@nombre"/><br/>
                <xsl:value-of select="cv/formación/titulo/@centro"/><br/>
                <xsl:value-of select="cv/formación/titulo/@fin"/><br/>
            </div>
            <div id="experiencia">
                <h4>
                    <xsl:value-of select="cv/experiencia-profesional/cabecera"/>
                </h4>
                <p>
                    <xsl:value-of select="cv/experiencia-profesional/experiencia/puesto"/><br/>
                    <xsl:value-of select="cv/experiencia-profesional/experiencia/empresa"/><br/>
                    <xsl:value-of select="cv/experiencia-profesional/experiencia/inicio"/><br/>
                    <xsl:value-of select="cv/experiencia-profesional/experiencia/final"/><br/>
                </p>    
            </div>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>