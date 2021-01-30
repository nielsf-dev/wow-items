package org.nelis.wowitems

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import java.lang.Exception
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.web.client.RestTemplate
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.concurrent.CompletableFuture

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebControllerTest{

    @LocalServerPort
    var port: Int = 0

    @Test
    fun test() {
        val client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build()

        val request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:$port/test"))
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        assert(response.body() == "tismewat")
    }
}