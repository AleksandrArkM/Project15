interface Attachments

data class VideoAttachment(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    override val url: String,
    override val title: String
) : Attachments, Video (url, title)

data class AudioAttachment(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    override val url: String,
    override val title: String
) : Attachments, Audio (url, title)

open class Video (
    open val url: String,
    open val title: String
){
}

open class Audio (
    open val url: String,
    open val title: String
){
}