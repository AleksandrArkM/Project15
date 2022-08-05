data class Post(
    val id: Int,
    val ownerId: Int,
    var text: String,
    val date: Int,
    var friendsOnly: Boolean,
    var isFavorite: Boolean,
    var comments: Comment,
    var isPinned: Boolean,
    val document: Document?,
    val note: Note?,
    val link: Link?,
    val attachment: Attachments?
) {
}

class Comment(
    val id: Int,
    val ownerId: Int,
    val text: String,
    var likes: Int = 0
) {
}

class Document (
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val type: Int
) {
}

class Note (
    val id: Int,
    val ownerId: Int,
    val title: String,
    val text: String,
    val date: Int,
    val comments: Comment?,
    val readComments: Int,
    val viewUrl: String
) {
}
class Link (
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
    val date: Int,
    val comments: Comment?,
    val readComments: Int,
    val viewUrl: String
) {
}