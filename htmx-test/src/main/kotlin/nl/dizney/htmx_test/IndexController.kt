package nl.dizney.htmx_test

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.time.LocalDateTime

@Controller
class IndexController {
    companion object {
        val searchResults = listOf("one", "two", "three", "four", "five")
    }

    @GetMapping("/")
    fun index() = "index"

    @PostMapping("/clicked")
    fun clicked(model: Model): String {
        model.addAttribute("now", LocalDateTime.now().toString())
        return "clicked :: result"
    }

    @GetMapping("/search")
    fun search(q: String, model: Model): String {
        model.addAttribute(
            "results",
            searchResults.filter { it.startsWith(q.lowercase()) }
        )
        return "search :: results"
    }
}
