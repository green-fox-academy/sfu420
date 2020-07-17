package com.greenfox.reddit.services;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.repositories.PostRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public Optional<Post> getById(Long id) {
    return postRepository.findById(id);
  }

  public List<Post> getAllInitialPost() {
    return postRepository.findAllByInitialPostIsTrue();
  }

  public Post newThread(Post newPost) {
    return postRepository.save(newPost);
  }

  public Post upVote(Post post) {
    post.upVote();
    return postRepository.save(post);
  }

  public Post downVote(Post post) {
    post.downVote();
    return postRepository.save(post);
  }
}