class WallService {
    var posts = emptyArray<Post>()

    private var lastId = 0

    fun getNextId() = lastId++

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, item) in posts.withIndex()) {
            if (item.id == post.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }
}