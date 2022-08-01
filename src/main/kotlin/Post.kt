data class Post(
    val id: Int,
    val ownerId: Int,
    val text: String,
    val date: Int,
    val friendsOnly: Boolean,
    val isFavorite: Boolean,
    val comments: Comment,
    val isPinned: Boolean
) {
}

class Comment(
    val id: Int,
    val ownerId: Int,
    val text: String,
    var likes: Int = 0
) {
}