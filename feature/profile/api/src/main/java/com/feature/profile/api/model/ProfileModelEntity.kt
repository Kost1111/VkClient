package com.feature.profile.api.model

data class RootEntity(
    val response: WallEntity,
)

data class WallEntity(
    val count: Long,
    val items: List<ItemEntity>,
)

data class ItemEntity(
    val innerType: String,
    val canDelete: Long,
    val canPin: Long,
    val comments: CommentsEntity,
    val markedAsAds: Long,
    val hash: String,
    val type: String,
    val attachments: List<AttachmentEntity>,
    val canArchive: Boolean,
    val date: Long,
    val fromId: Long,
    val id: Long,
    val isArchived: Boolean,
    val isFavorite: Boolean,
    val likes: LikesEntity,
    val reactionSetId: String,
    val reactions: ReactionsEntity,
    val ownerId: Long,
    val postSource: PostSourceEntity,
    val postType: String,
    val reposts: RepostsEntity,
    val text: String,
    val views: ViewsEntity,
    val carouselOffset: Long?,
)

data class CommentsEntity(
    val canPost: Long,
    val canClose: Long,
    val canView: Long,
    val count: Long,
    val groupsCanPost: Boolean,
)

data class AttachmentEntity(
    val type: String,
    val photo: PhotoEntity?,
    val audio: AudioEntity?,
)

data class PhotoEntity(
    val albumId: Long,
    val date: Long,
    val id: Long,
    val ownerId: Long,
    val postId: Long,
    val squareCrop: String?,
    val text: String,
    val webViewToken: String,
    val hasTags: Boolean,
    val accessKey: String?,
)

data class AudioEntity(
    val artist: String,
    val id: Long,
    val ownerId: Long,
    val title: String,
    val duration: Long,
    val isExplicit: Boolean,
    val isFocusTrack: Boolean,
    val trackCode: String,
    val url: String,
    val date: Long,
    val noSearch: Long,
    val contentRestricted: Long,
    val shortVideosAllowed: Boolean,
    val storiesAllowed: Boolean,
    val storiesCoverAllowed: Boolean,
)

data class LikesEntity(
    val canLike: Long,
    val count: Long,
    val userLikes: Long,
    val canPublish: Long,
    val repostDisabled: Boolean,
)

data class ReactionsEntity(
    val count: Long,
    val userReaction: Long,
)

data class PostSourceEntity(
    val data: String?,
    val platform: String,
    val type: String,
)

data class RepostsEntity(
    val count: Long,
    val wallCount: Long,
    val mailCount: Long,
    val userReposted: Long,
)

data class ViewsEntity(
    val count: Long,
)
