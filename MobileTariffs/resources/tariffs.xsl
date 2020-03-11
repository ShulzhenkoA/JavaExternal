<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:b="http://www.javaexternal.tariffs"
                exclude-result-prefixes="b">
    <xsl:template match="b:tariffs">
    <html>
        <body>
            <h1>Mobile Tariffs</h1>
            <table border="1">
                <tr>
                    <th>Tariff Name</th>
                    <th>Operator</th>
                    <th>Payroll UAH</th>
                    <th colspan="2">Call-prices UAH</th>
                    <th>SMS-price</th>
                    <th colspan="2">Properties</th>
                </tr>
                <xsl:for-each select="b:tariff">
                    <xsl:sort select="b:payroll" data-type="number"/>
                    <tr>
                        <td rowspan="3" align="center"><xsl:value-of select="b:name"/></td>
                        <td rowspan="3" align="center"><xsl:value-of select="b:operator_name"/></td>
                        <td rowspan="3" align="center"><xsl:value-of select="b:payroll"/></td>
                        <td>Withing network</td>
                        <td><xsl:value-of select="b:call_prices/b:withing_network"/></td>
                        <td rowspan="3" align="center"><xsl:value-of select="b:sms"/></td>
                        <td>Favourite-number</td>
                        <td><xsl:value-of select="b:parameters/b:favourite_number"/></td>
                    </tr>
                    <tr>
                        <td>Outside network</td>
                        <td><xsl:value-of select="b:call_prices/b:outside_network"/></td>
                        <td>Tariffing</td>
                        <td><xsl:value-of select="b:parameters/b:tariffing"/></td>
                    </tr>
                    <tr>
                        <td>Stationary phones</td>
                        <td><xsl:value-of select="b:call_prices/b:stationary_phones"/></td>
                        <td>Tariff connection fee</td>
                        <td><xsl:value-of select="b:parameters/b:tariff_connection_fee"/></td>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
    </html>
    </xsl:template>

</xsl:stylesheet>


