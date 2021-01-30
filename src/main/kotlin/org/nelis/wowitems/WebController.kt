package org.nelis.wowitems

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebController {

    @GetMapping("/test")
    fun doTest() : String {
        return "tismewat"
    }
}