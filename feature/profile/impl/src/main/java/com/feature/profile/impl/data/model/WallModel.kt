package com.feature.profile.impl.data.model

import com.google.gson.annotations.SerializedName


data class Root(
    val response: WallDTO? = null,
)

data class WallDTO(
    val count: Long? = null,
    val items: List<ItemDTO>? = null,
)

data class ItemDTO(
    @SerializedName("inner_type")
    val innerType: String? = null,
    @SerializedName("can_delete")
    val canDelete: Long? = null,
    @SerializedName("can_pin")
    val canPin: Long? = null,
    val comments: CommentsDTO? = null,
    @SerializedName("marked_as_ads")
    val markedAsAds: Long? = null,
    val hash: String? = null,
    val type: String? = null,
    val attachments: List<AttachmentDTO>? = null,
    @SerializedName("can_archive")
    val canArchive: Boolean? = null,
    val date: Long? = null,
    @SerializedName("from_id")
    val fromId: Long? = null,
    val id: Long? = null,
    @SerializedName("is_archived")
    val isArchived: Boolean? = null,
    @SerializedName("is_favorite")
    val isFavorite: Boolean? = null,
    val likes: LikesDTO? = null,
    @SerializedName("reaction_set_id")
    val reactionSetId: String? = null,
    val reactions: ReactionsDTO? = null,
    @SerializedName("owner_id")
    val ownerId: Long? = null,
    @SerializedName("post_source")
    val postSource: PostSourceDTO? = null,
    @SerializedName("post_type")
    val postType: String? = null,
    val reposts: RepostsDTO? = null,
    val text: String? = null,
    val views: ViewsDTO? = null,
    @SerializedName("carousel_offset")
    val carouselOffset: Long? = null,
)

data class CommentsDTO(
    @SerializedName("can_post")
    val canPost: Long? = null,
    @SerializedName("can_close")
    val canClose: Long? = null,
    @SerializedName("can_view")
    val canView: Long? = null,
    val count: Long? = null,
    @SerializedName("groups_can_post")
    val groupsCanPost: Boolean? = null,
)

data class AttachmentDTO(
    val type: String? = null,
    val photo: PhotoDTO? = null,
    val audio: AudioDTO? = null,
)

data class PhotoDTO(
    @SerializedName("album_id")
    val albumId: Long? = null,
    val date: Long? = null,
    val id: Long? = null,
    @SerializedName("owner_id")
    val ownerId: Long? = null,
    @SerializedName("post_id")
    val postId: Long? = null,
    @SerializedName("square_crop")
    val squareCrop: String? = null,
    val text: String? = null,
    @SerializedName("web_view_token")
    val webViewToken: String? = null,
    @SerializedName("has_tags")
    val hasTags: Boolean? = null,
    @SerializedName("access_key")
    val accessKey: String? = null,
)

data class AudioDTO(
    val artist: String? = null,
    val id: Long? = null,
    @SerializedName("owner_id")
    val ownerId: Long? = null,
    val title: String? = null,
    val duration: Long? = null,
    @SerializedName("is_explicit")
    val isExplicit: Boolean? = null,
    @SerializedName("is_focus_track")
    val isFocusTrack: Boolean? = null,
    @SerializedName("track_code")
    val trackCode: String? = null,
    val url: String? = null,
    val date: Long? = null,
    @SerializedName("no_search")
    val noSearch: Long? = null,
    @SerializedName("content_restricted")
    val contentRestricted: Long? = null,
    @SerializedName("short_videos_allowed")
    val shortVideosAllowed: Boolean? = null,
    @SerializedName("stories_allowed")
    val storiesAllowed: Boolean? = null,
    @SerializedName("stories_cover_allowed")
    val storiesCoverAllowed: Boolean? = null,
)

data class LikesDTO(
    @SerializedName("can_like")
    val canLike: Long? = null,
    val count: Long? = null,
    @SerializedName("user_likes")
    val userLikes: Long? = null,
    @SerializedName("can_publish")
    val canPublish: Long? = null,
    @SerializedName("repost_disabled")
    val repostDisabled: Boolean? = null,
)

data class ReactionsDTO(
    val count: Long? = null,
    @SerializedName("user_reaction")
    val userReaction: Long? = null,
)

data class PostSourceDTO(
    val data: String? = null,
    val platform: String? = null,
    val type: String? = null,
)

data class RepostsDTO(
    val count: Long? = null,
    @SerializedName("wall_count")
    val wallCount: Long? = null,
    @SerializedName("mail_count")
    val mailCount: Long? = null,
    @SerializedName("user_reposted")
    val userReposted: Long? = null,
)

data class ViewsDTO(
    val count: Long? = null,
)

