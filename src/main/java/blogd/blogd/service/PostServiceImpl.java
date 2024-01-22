package blogd.blogd.service;

import blogd.blogd.entity.Post;
import blogd.blogd.exception.ResourceNotFoundException;
import blogd.blogd.payload.PostDto;
import blogd.blogd.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post= mapToEntity(postDto);
        Post savePost= postRepository.save(post);
       PostDto dto= mapToDto(savePost);
       return dto;
    }

    @Override
    public PostDto getPostByid(long id) {
        Post post=postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("post is not found with this id:"+id)
        );
PostDto dto=new PostDto();
dto.setId(post.getId());
dto.setTitle(post.getTitle());
dto.setDescription(post.getDescription());
dto.setContent(post.getContent());
        return dto;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post>posts=postRepository.findAll();
        List<PostDto>dtos=posts.stream().map(p->mapToDto(p)).collect(Collectors.toList());
        return dtos;
    }
    PostDto mapToDto(Post post){
        PostDto dto=new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }
  Post  mapToEntity(PostDto postDto){
      Post post=new Post();
      post.setTitle(postDto.getTitle());
      post.setDescription(postDto.getDescription());
      post.setContent(postDto.getContent());
      Post savePost= postRepository.save(post);
      return post;
  }
}
