class WallService<T> {
    private var posts = mutableListOf<Post>()
    private var comments = mutableListOf<Comment>()

    private var lastId = 1
    private var nulPost = 0

    fun add(post: Post): Post {
        val newPost = post.copy(id = lastId++)
        posts.add(newPost)
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

    fun getByID(id: Int): Post {
        val listByID = mutableListOf<Post>()
        for (post in posts) {
            if (id == post.id)
                listByID.add(post)
        }
        return if (listByID.isNotEmpty()) listByID.last() else throw CommentExeption("Cant find id post")
    }

    fun createComment(comment: Comment) {
        for ((index, value) in posts.withIndex()) {
            if (value.id != comment.id && (index < comments.size - 1)) {
                continue
            } else if (value.id == comment.id) {
                comments.add(comment)
                break
            }
            throw CommentExeption("Post for this comment dont exist")
        }

    }
}