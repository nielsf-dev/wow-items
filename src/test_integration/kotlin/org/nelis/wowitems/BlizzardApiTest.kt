package org.nelis.wowitems

import org.junit.jupiter.api.Test
import java.net.URI
import java.net.http.HttpRequest
import java.net.http.HttpClient
import java.net.http.HttpResponse
import java.util.*


class BlizzardApiTest {

    @Test
    fun getAccessToken(){
        val client_id = "6349f54a43394a4ea132a5b55e33a40e"
        val client_secret = "j37knGBpXktebeVf22RRsXNR6oN6bTSx"

        val uncodedHeaderVal = "$client_id:$client_secret"
        val encodedHeaderVal = Base64.getEncoder().encodeToString(uncodedHeaderVal.encodeToByteArray());

        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://eu.battle.net/oauth/token"))
            .setHeader("Authorization", "Basic $encodedHeaderVal")
            .setHeader("Content-Type", "application/x-www-form-urlencoded")
            .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
            .build()

        val client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        println(response.body())
    }
}