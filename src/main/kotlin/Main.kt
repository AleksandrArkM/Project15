fun main() {
    val service = WallService<Post>()
    val post1 = Post(0, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true, null,null,null, VideoAttachment(1,1,1,"https://...","name"));
    val post2 = Post(1, 239, "Hello", 25, true, true, Comment(1, 111, "nice comment22", 0), true, null,null,null,null);
    service.add(post1)
    service.add(post2)
    service.getByID(2)
    service.createComment(Comment(1,1,"Nice text", 0))
}