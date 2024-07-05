package com.example.theplebroad.libtest
import kotlinx.coroutines.runBlocking
import rust.nostr.protocol.Filter
import rust.nostr.protocol.Kind
import rust.nostr.sdk.Client

suspend fun test() {
    val relayTest = "wss://nostr.wine"
    val client = Client(null)
    client.addRelay(relayTest)
    client.connect()

    val filterTest = Filter().kind(Kind(1u)).limit(2u)
    val events = client.getEventsOf(listOf(filterTest), timeout = null)
    for (event in events) {
        println(event.author().toBech32())
    }
}
fun main() = runBlocking<Unit>{
    test()
}



//https://rust-nostr.org/nostr-sdk/02-installation.html



