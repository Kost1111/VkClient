package com.feature.profile.impl.data.model

import com.google.gson.annotations.SerializedName


data class Root(
    val response: WallDTO,
)

data class WallDTO(
    val count: Long,
    val items: List<ItemDTO>,
)

data class ItemDTO(
    @SerializedName("inner_type")
    val innerType: String,
    @SerializedName("can_delete")
    val canDelete: Long,
    @SerializedName("can_pin")
    val canPin: Long,
    val comments: CommentsDTO,
    @SerializedName("marked_as_ads")
    val markedAsAds: Long,
    val hash: String,
    val type: String,
    val attachments: List<AttachmentDTO>,
    @SerializedName("can_archive")
    val canArchive: Boolean,
    val date: Long,
    @SerializedName("from_id")
    val fromId: Long,
    val id: Long,
    @SerializedName("is_archived")
    val isArchived: Boolean,
    @SerializedName("is_favorite")
    val isFavorite: Boolean,
    val likes: LikesDTO,
    @SerializedName("reaction_set_id")
    val reactionSetId: String,
    val reactions: ReactionsDTO,
    @SerializedName("owner_id")
    val ownerId: Long,
    @SerializedName("post_source")
    val postSource: PostSourceDTO,
    @SerializedName("post_type")
    val postType: String,
    val reposts: RepostsDTO,
    val text: String,
    val views: ViewsDTO,
    @SerializedName("carousel_offset")
    val carouselOffset: Long?,
)

data class CommentsDTO(
    @SerializedName("can_post")
    val canPost: Long,
    @SerializedName("can_close")
    val canClose: Long,
    @SerializedName("can_view")
    val canView: Long,
    val count: Long,
    @SerializedName("groups_can_post")
    val groupsCanPost: Boolean,
)

data class AttachmentDTO(
    val type: String,
    val photo: PhotoDTO?,
    val audio: AudioDTO?,
)

data class PhotoDTO(
    @SerializedName("album_id")
    val albumId: Long,
    val date: Long,
    val id: Long,
    @SerializedName("owner_id")
    val ownerId: Long,
    @SerializedName("post_id")
    val postId: Long,
    @SerializedName("square_crop")
    val squareCrop: String?,
    val text: String,
    @SerializedName("web_view_token")
    val webViewToken: String,
    @SerializedName("has_tags")
    val hasTags: Boolean,
    @SerializedName("access_key")
    val accessKey: String?,
)

data class AudioDTO(
    val artist: String,
    val id: Long,
    @SerializedName("owner_id")
    val ownerId: Long,
    val title: String,
    val duration: Long,
    @SerializedName("is_explicit")
    val isExplicit: Boolean,
    @SerializedName("is_focus_track")
    val isFocusTrack: Boolean,
    @SerializedName("track_code")
    val trackCode: String,
    val url: String,
    val date: Long,
    @SerializedName("no_search")
    val noSearch: Long,
    @SerializedName("content_restricted")
    val contentRestricted: Long,
    @SerializedName("short_videos_allowed")
    val shortVideosAllowed: Boolean,
    @SerializedName("stories_allowed")
    val storiesAllowed: Boolean,
    @SerializedName("stories_cover_allowed")
    val storiesCoverAllowed: Boolean,
)

data class LikesDTO(
    @SerializedName("can_like")
    val canLike: Long,
    val count: Long,
    @SerializedName("user_likes")
    val userLikes: Long,
    @SerializedName("can_publish")
    val canPublish: Long,
    @SerializedName("repost_disabled")
    val repostDisabled: Boolean,
)

data class ReactionsDTO(
    val count: Long,
    @SerializedName("user_reaction")
    val userReaction: Long,
)

data class PostSourceDTO(
    val data: String?,
    val platform: String,
    val type: String,
)

data class RepostsDTO(
    val count: Long,
    @SerializedName("wall_count")
    val wallCount: Long,
    @SerializedName("mail_count")
    val mailCount: Long,
    @SerializedName("user_reposted")
    val userReposted: Long,
)

data class ViewsDTO(
    val count: Long,
)

