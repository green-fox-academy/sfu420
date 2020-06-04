package blog;

import blog_post.BlogPost;
import java.util.ArrayList;

public class Blog {
  ArrayList<BlogPost> blogPosts = new ArrayList<>();

  public Blog add(BlogPost blogPost) {
    this.blogPosts.add(blogPost);
    return this;
  }

  public void delete(int index) {
    this.blogPosts.remove(index);
  }

  public void update(int index, BlogPost blogPost) {
    this.blogPosts.set(index, blogPost);
  }

  public static void main(String[] args) {
    Blog myBlog = new Blog();

    BlogPost bp1 = new BlogPost(
        "John Doe",
        "Lorem Ipsum",
        "Lorem ipsum dolor sit amet.",
        "2000.05.04");

    BlogPost bp2 = new BlogPost(
        "Tim Urban",
        "Wait but why",
        "A popular long-form, stick-figure-illustrated blog about almost everything.",
        "2010.10.10.");

    BlogPost bp3 = new BlogPost(
        "William Turton",
        "One Engineer Is Trying to Get IBM to Reckon With Trump",
        "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.",
        "2017.03.28.");

    myBlog.add(bp1).add(bp2).add(bp3);
    //myBlog.add(bp2);
    //myBlog.add(bp3);

    myBlog.blogPosts.get(1).getContent();
    myBlog.update(1, new BlogPost(
        "Alexander Main",
        "How to update content",
        "This will be an easy way",
        "2020.06.04"));
    myBlog.blogPosts.get(1).getContent();
  }
}
