package database

import database.models.Account
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Database @Inject constructor(){

    private val accounts : MutableMap<String, Account> = hashMapOf()

    fun getAccount(username : String) : Account = accounts.getOrPut(username){Account(username) }
}