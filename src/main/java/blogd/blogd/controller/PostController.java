package blogd.blogd.controller;

import blogd.blogd.payload.PostDto;
import blogd.blogd.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mani")
public class PostController {
    private PostService  postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<PostDto>createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);


    }
    @GetMapping("/particular")
    public ResponseEntity<PostDto>getPostById(@RequestParam long id){
        PostDto dto=postService.getPostByid(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping()
    public List<PostDto>getAllPost(){
        List<PostDto>postDtos=postService.getAllPost();
        return postDtos;
    }
}
