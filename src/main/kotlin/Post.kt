data class Post(
    val id: Int,
    val ownerId: Int,
    var text: String,
    val date: Int,
    var friendsOnly: Boolean,
    var isFavorite: Boolean,
    var comments: Comment,
    var isPinned: Boolean
) {
}

class Comment(
    val id: Int,
    val ownerId: Int,
    val text: String,
    var likes: Int = 0
) {
}