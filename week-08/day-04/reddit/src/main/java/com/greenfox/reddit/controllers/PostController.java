package com.greenfox.reddit.controllers;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.services.PostService;
import com.greenfox.reddit.services.RedditUserDetailsService;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/r")
public class PostController {

  private PostService postService;
  private RedditUserDetailsService userService;

  @Autowired
  public PostController(PostService postService, RedditUserDetailsService userService) {
    this.postService = postService;
    this.userService = userService;
  }

  @GetMapping("/")
  public String redirect() {
    return "redirect:/r/greenfox";
  }

  @GetMapping({"/greenfox", "/greenfox/{newThread}"})
  public String listThreads(@RequestParam(required = false) boolean newThread,
                            @RequestParam(required = false) boolean edit,
                            @RequestParam(required = false) boolean reply,
                            @RequestParam(required = false) Long id,
                            Model model) {
    model.addAttribute("threads", postService.getAllInitialPost());
    model.addAttribute("currentUser", userService.getCurrentUser());
    model.addAttribute("newPost", new Post());

    if (newThread)
      model.addAttribute("newThread", true);

    if (id != null && postService.getById(id).isPresent())
      model.addAttribute("currentPost", postService.getById(id).get());

    if (edit)
      model.addAttribute("editPost", true);

    if (reply)
      model.addAttribute("replyPost", true);

    return "index";
  }

  @GetMapping("/greenfox/{threadId}/upvote")
  public String upVote(@PathVariable Long threadId) {
    Optional<Post> currentPost = postService.getById(threadId);
    currentPost.ifPresent(post -> postService.upVote(post));
    return "redirect:/r/greenfox";
  }

  @GetMapping("/greenfox/{threadId}/downvote")
  public String downVote(@PathVariable Long threadId) {
    Optional<Post> currentPost = postService.getById(threadId);
    currentPost.ifPresent(post -> postService.downVote(post));
    return "redirect:/r/greenfox";
  }

  @PostMapping("/greenfox/newThread")
  public String newThread(@ModelAttribute Post newPost) {
    newPost.setUser(userService.getCurrentUser());
    newPost.setCreationDate(new Date());
    newPost.setInitialPost(true);
    postService.addNewPost(newPost);
    return "redirect:/r/greenfox";
  }

  @GetMapping("/greenfox/{id}/delete")    //TODO: Delete child posts as well (cascade???)
  public String deletePost(@PathVariable Long id) {
    Optional<Post> currentPost = postService.getById(id);
    currentPost.ifPresent(post -> {
      if (post.getUser().equals(userService.getCurrentUser())) {
        postService.deleteById(id);
      }
    });
    return "redirect:/r/greenfox";
  }

  @PostMapping("/greenfox/update")
  public String updatePost(@ModelAttribute Post currentPost) {
    Optional<Post> oldPost = postService.getById(currentPost.getId());
    oldPost.ifPresent(post -> {
      if (post.getUser().equals(userService.getCurrentUser())) {
        post.setTitle(currentPost.getTitle());
        post.setContent(currentPost.getContent());
        post.setUpdateDate(new Date());
        postService.updatePost(post);
      }
    });
    return "redirect:/r/greenfox";
  }

  @PostMapping("/greenfox/reply")
  public String replyPost(@ModelAttribute Post newPost,
                          @RequestParam Long parentId) {
    Optional<Post> parentPost = postService.getById(parentId);
    if (parentPost.isPresent()) {
      newPost.setUser(userService.getCurrentUser());
      newPost.setCreationDate(new Date());
      newPost.setParentPost(parentPost.get());
      postService.addNewPost(newPost);
    }
    return "redirect:/r/greenfox";
  }

  @GetMapping("/greenfox/threadView")
  public String threadView(@RequestParam Long id,
                           @RequestParam(required = false) boolean edit,
                           @RequestParam(required = false) boolean reply,
                           Model model) {
    Optional<Post> post = postService.getById(id);
    if (post.isPresent()) {
      model.addAttribute("thread", post.get());
      model.addAttribute("currentUser", userService.getCurrentUser());
      model.addAttribute("newPost", new Post());
    }
    return "thread";
  }
}
