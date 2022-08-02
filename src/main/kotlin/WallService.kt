class WallService {
    private var posts = emptyArray<Post>()

    private var lastId = 1

    fun add(post: Post): Post {
        lastId++
        val addPost = post.copy(id = lastId)
        posts += addPost
        return posts.last()
    }

        fun update(post: Post): Boolean {
        for ((index, item) in posts.withIndex()) {
            if (item.id == post.id) {
                posts[index].text = post.text
                posts[index].friendsOnly = post.friendsOnly
                posts[index].isFavorite = post.isFavorite
                posts[index].comments = post.comments
                posts[index].isPinned = post.isPinned
                //меняются все поля, кроме ownerId и date
                return true
            }
        }
        return false
    }
}