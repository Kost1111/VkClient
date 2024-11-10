package com.feature.profile.impl.data.mapper

import com.feature.profile.api.model.AttachmentEntity
import com.feature.profile.api.model.AudioEntity
import com.feature.profile.api.model.CommentsEntity
import com.feature.profile.api.model.ItemEntity
import com.feature.profile.api.model.LikesEntity
import com.feature.profile.api.model.PhotoEntity
import com.feature.profile.api.model.PostSourceEntity
import com.feature.profile.api.model.ReactionsEntity
import com.feature.profile.api.model.RepostsEntity
import com.feature.profile.api.model.ViewsEntity
import com.feature.profile.api.model.WallEntity
import com.feature.profile.impl.data.model.AttachmentDTO
import com.feature.profile.impl.data.model.AudioDTO
import com.feature.profile.impl.data.model.CommentsDTO
import com.feature.profile.impl.data.model.ItemDTO
import com.feature.profile.impl.data.model.LikesDTO
import com.feature.profile.impl.data.model.PhotoDTO
import com.feature.profile.impl.data.model.PostSourceDTO
import com.feature.profile.impl.data.model.ReactionsDTO
import com.feature.profile.impl.data.model.RepostsDTO
import com.feature.profile.impl.data.model.ViewsDTO
import com.feature.profile.impl.data.model.WallDTO

fun WallDTO.toEntity() = WallEntity(
    count = count ?: 0L,
    items = items?.map { it.toEntity() } ?: emptyList()
)

fun ItemDTO.toEntity() = ItemEntity(
    innerType = innerType.orEmpty(),
    canDelete = canDelete ?: 0L,
    canPin = canPin ?: 0L,
    comments = comments.toEntity(),
    markedAsAds = markedAsAds ?: 0L,
    hash = hash.orEmpty(),
    type = type.orEmpty(),
    attachments = attachments?.map { it.toEntity() } ?: emptyList(),
    canArchive = canArchive ?: false,
    date = date ?: 0L,
    fromId = fromId ?: 0L,
    id = id ?: 0L,
    isArchived = isArchived ?: false,
    isFavorite = isFavorite ?: false,
    likes = likes.toEntity(),
    reactionSetId = reactionSetId.orEmpty(),
    reactions = reactions.toEntity(),
    ownerId = ownerId ?: 0L,
    postSource = postSource.toEntity(),
    postType = postType.orEmpty(),
    reposts = reposts.toEntity(),
    text = text.orEmpty(),
    views = views.toEntity(),
    carouselOffset = carouselOffset
)

fun CommentsDTO?.toEntity() = CommentsEntity(
    canPost = this?.canPost ?: 0L,
    canClose = this?.canClose ?: 0L,
    canView = this?.canView ?: 0L,
    count = this?.count ?: 0L,
    groupsCanPost = this?.groupsCanPost ?: false
)

fun AttachmentDTO.toEntity() = AttachmentEntity(
    type = type.orEmpty(),
    photo = photo?.toEntity(),
    audio = audio?.toEntity()
)

fun PhotoDTO.toEntity() = PhotoEntity(
    albumId = albumId ?: 0L,
    date = date ?: 0L,
    id = id ?: 0L,
    ownerId = ownerId ?: 0L,
    postId = postId ?: 0L,
    squareCrop = squareCrop,
    text = text.orEmpty(),
    webViewToken = webViewToken.orEmpty(),
    hasTags = hasTags ?: false,
    accessKey = accessKey
)

fun AudioDTO.toEntity() = AudioEntity(
    artist = artist.orEmpty(),
    id = id ?: 0L,
    ownerId = ownerId ?: 0L,
    title = title.orEmpty(),
    duration = duration ?: 0L,
    isExplicit = isExplicit ?: false,
    isFocusTrack = isFocusTrack ?: false,
    trackCode = trackCode.orEmpty(),
    url = url.orEmpty(),
    date = date ?: 0L,
    noSearch = noSearch ?: 0L,
    contentRestricted = contentRestricted ?: 0L,
    shortVideosAllowed = shortVideosAllowed ?: false,
    storiesAllowed = storiesAllowed ?: false,
    storiesCoverAllowed = storiesCoverAllowed ?: false
)

fun LikesDTO?.toEntity() = LikesEntity(
    canLike = this?.canLike ?: 0L,
    count = this?.count ?: 0L,
    userLikes = this?.userLikes ?: 0L,
    canPublish = this?.canPublish ?: 0L,
    repostDisabled = this?.repostDisabled ?: false
)

fun ReactionsDTO?.toEntity() = ReactionsEntity(
    count = this?.count ?: 0L,
    userReaction = this?.userReaction ?: 0L
)

fun PostSourceDTO?.toEntity() = PostSourceEntity(
    data = this?.data,
    platform = this?.platform.orEmpty(),
    type = this?.type.orEmpty()
)

fun RepostsDTO?.toEntity() = RepostsEntity(
    count = this?.count ?: 0L,
    wallCount = this?.wallCount ?: 0L,
    mailCount = this?.mailCount ?: 0L,
    userReposted = this?.userReposted ?: 0L
)

fun ViewsDTO?.toEntity() = ViewsEntity(
    count = this?.count ?: 0L
)
