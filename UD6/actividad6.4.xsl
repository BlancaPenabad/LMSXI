<?xml version="1.0" encoding="utf-8"?>
<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <fo:layout-master-set> 
        <!-- Tamañp y configuración de la invitación-->
        <fo:simple-page-master master-name="A4" page-height="9cm" page-width="20cm" margin-top="1cm" margin-bottom="1cm" margin-left="2cm" margin-right="2cm" background-color="linen"> 
            <fo:region-body margin-top="1cm"/> 
            <fo:region-before extent="3cm"/> 
            <fo:region-after extent="1.5cm"/>
        </fo:simple-page-master> 
    </fo:layout-master-set> 
    <!-- Contenido invitación-->
    <fo:page-sequence master-reference="A4"> 
        <!-- Encabezado-->
        <fo:flow flow-name="xsl-region-body"> 
            <fo:block font-size="16pt" font-family="sans-serif" line-height="30pt" space-after.optimum="15pt" background-color="#FFFACD" color="gray" text-align="center" padding-top="2pt" >Blanca &amp; Ernesto</fo:block> 
            <!-- Texto-->
            <fo:block font-size="10pt" font-family="sans-serif" line-height="15pt" space-after.optimum="3pt" text-align="center" color="gray">Nos hace mucha ilusión compartir con ustedes un día tan especial.</fo:block> 
            <fo:block font-size="10pt" font-family="sans-serif" line-height="15pt" space-after.optimum="3pt" text-align="center" color="gray">El 15 de junio de 2023 a las 13:00 </fo:block> 
            <fo:block font-size="10pt" font-family="sans-serif" line-height="15pt" space-after.optimum="3pt" text-align="center" color="gray">en la iglesia de San Francisco</fo:block> 
            <fo:block font-size="10pt" font-family="sans-serif" line-height="15pt" space-after.optimum="3pt" text-align="center" color="gray">con posterior celebración en el restaurante Nito </fo:block> 
            <fo:block font-size="10pt" font-family="sans-serif" line-height="15pt" space-after.optimum="3pt" text-align="center" color="gray">981888999</fo:block> 
        </fo:flow> 
    </fo:page-sequence> 
</fo:root> 
