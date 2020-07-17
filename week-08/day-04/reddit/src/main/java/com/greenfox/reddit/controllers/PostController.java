package com.greenfox.reddit.controllers;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.services.PostService;
import com.greenfox.reddit.services.RedditUserDetailsService;
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

  @GetMapping({"/greenfox", "/greenfox/{newThread})"})
  public String listThreads(@RequestParam(required = false) boolean newThread, Model model) {
    model.addAttribute("threads", postService.getAllInitialPost());
    model.addAttribute("newPost", new Post());
    if (newThread == true)
      model.addAttribute("newThread", true);
    return "index";
  }

  @GetMapping("/greenfox/{threadId}/upvote")
  public String upVote(@PathVariable Long threadId) {
    if (postService.getById(threadId).isPresent()) {
      postService.upVote(postService.getById(threadId).get());
    }
    return "redirect:/r/greenfox";
  }

  @GetMapping("/greenfox/{threadId}/downvote")
  public String downVote(@PathVariable Long threadId) {
    if (postService.getById(threadId).isPresent()) {
      postService.downVote(postService.getById(threadId).get());
    }
    return "redirect:/r/greenfox";
  }

  @PostMapping("/greenfox/newThread")
  public String newThread(@ModelAttribute Post newPost) {
    newPost.setUser(userService.getCurrentUser());
    newPost.setInitialPost(true);
    postService.newThread(newPost);
    return "redirect:/r/greenfox";
  }

}
