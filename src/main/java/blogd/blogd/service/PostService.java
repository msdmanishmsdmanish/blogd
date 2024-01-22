package blogd.blogd.service;

import blogd.blogd.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostDto getPostByid(long id);


    List<PostDto> getAllPost();
}
