package trinity.core.rest.layer

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import trinity.core.soap.client.command.CommandInvoker
import trinity.core.soap.client.soap.SoapClient
import trinity.core.soap.client.soap.SoapConnection
import trinity.core.soap.client.soap.SoapCredentials
import java.net.URL
import javax.xml.soap.SOAPConnectionFactory

@Factory
internal class BeanFactory {
    @Bean
    fun createTrinityCoreSoapClient(): CommandInvoker {
        val connection = SoapConnection(SOAPConnectionFactory.newInstance()::createConnection, URL("http://127.0.0.1:7878"))
        val credentials = SoapCredentials("", "")
        val soapClient = SoapClient(connection, credentials)

        return CommandInvoker(soapClient)
    }
}
