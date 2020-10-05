package org.kubinity.worldserver.companion.endpoint

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import org.kubinity.soap.client.command.Command
import org.kubinity.soap.client.command.CommandInvoker
import org.kubinity.worldserver.companion.account.ChangeLockStatus
import org.kubinity.worldserver.companion.account.ChangePassword
import org.kubinity.worldserver.companion.account.CreateUser
import javax.inject.Inject

@Controller("/account")
class AccountEndpoint (@Inject private val commandInvoker: CommandInvoker) {
    @Post("/create")
    fun register(@Body user: CreateUser): HttpResponse<Any> {
        val command = Command("account create ${user.username} ${user.password}")

        commandInvoker.invoke(command)

        return HttpResponse.ok(user)
    }

    @Put("/{username}/password")
    fun changeAccountPassword(@PathVariable username: String, @Body changePassword: ChangePassword): HttpResponse<Any> {
        val command = Command("account set password $username ${changePassword.password} ${changePassword.password}")

        commandInvoker.invoke(command)

        return HttpResponse.ok()
    }

    @Put("/{username}/lock/status")
    fun lockAccount(@PathVariable username: String, @Body changeLockStatus: ChangeLockStatus): HttpResponse<Any> {
        val command = Command("account set lock $username ${changeLockStatus.lockStatus}")

        commandInvoker.invoke(command)

        return HttpResponse.ok()
    }
}