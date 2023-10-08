package dev.dev01766.beans.controller;

import dev.dev01766.beans.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final RestTemplate restTemplate;

    // @Autowired isn't necessary here because in newer
    // versions @Autowired is implicit because of the
    // @Component annotation in the "postService".
    // This is because there is only a single constructor.
    public PostController(PostService postService, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.postService = postService;
    }

    @GetMapping
    public String findAll() {
        return postService.findAll();
    }

    @GetMapping("/load")
    public String loadPosts() {
        return "load-posts";
    }

}
