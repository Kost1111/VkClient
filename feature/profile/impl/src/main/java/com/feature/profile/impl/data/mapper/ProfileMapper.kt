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
import com.feature.profile.api.model.RootEntity
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
import com.feature.profile.impl.data.model.Root
import com.feature.profile.impl.data.model.ViewsDTO
import com.feature.profile.impl.data.model.WallDTO

fun Root.toEntity(): RootEntity {
    return RootEntity(
        response = response.toEntity()
    )
}

fun WallDTO.toEntity(): WallEntity {
    return WallEntity(
        count = count,
        items = items.map { it.toEntity() }
    )
}

fun ItemDTO.toEntity(): ItemEntity {
    return ItemEntity(
        innerType = innerType,
        canDelete = canDelete,
        canPin = canPin,
        comments = comments.toEntity(),
        markedAsAds = markedAsAds,
        hash = hash,
        type = type,
        attachments = attachments.map { it.toEntity() },
        canArchive = canArchive,
        date = date,
        fromId = fromId,
        id = id,
        isArchived = isArchived,
        isFavorite = isFavorite,
        likes = likes.toEntity(),
        reactionSetId = reactionSetId,
        reactions = reactions.toEntity(),
        ownerId = ownerId,
        postSource = postSource.toEntity(),
        postType = postType,
        reposts = reposts.toEntity(),
        text = text,
        views = views.toEntity(),
        carouselOffset = carouselOffset
    )
}

fun CommentsDTO.toEntity(): CommentsEntity {
    return CommentsEntity(
        canPost = canPost,
        canClose = canClose,
        canView = canView,
        count = count,
        groupsCanPost = groupsCanPost
    )
}

fun AttachmentDTO.toEntity(): AttachmentEntity {
    return AttachmentEntity(
        type = type,
        photo = photo?.toEntity(),
        audio = audio?.toEntity()
    )
}

fun PhotoDTO.toEntity(): PhotoEntity {
    return PhotoEntity(
        albumId = albumId,
        date = date,
        id = id,
        ownerId = ownerId,
        postId = postId,
        squareCrop = squareCrop,
        text = text,
        webViewToken = webViewToken,
        hasTags = hasTags,
        accessKey = accessKey
    )
}

fun AudioDTO.toEntity(): AudioEntity {
    return AudioEntity(
        artist = artist,
        id = id,
        ownerId = ownerId,
        title = title,
        duration = duration,
        isExplicit = isExplicit,
        isFocusTrack = isFocusTrack,
        trackCode = trackCode,
        url = url,
        date = date,
        noSearch = noSearch,
        contentRestricted = contentRestricted,
        shortVideosAllowed = shortVideosAllowed,
        storiesAllowed = storiesAllowed,
        storiesCoverAllowed = storiesCoverAllowed
    )
}

fun LikesDTO.toEntity(): LikesEntity {
    return LikesEntity(
        canLike = canLike,
        count = count,
        userLikes = userLikes,
        canPublish = canPublish,
        repostDisabled = repostDisabled
    )
}

fun ReactionsDTO.toEntity(): ReactionsEntity {
    return ReactionsEntity(
        count = count,
        userReaction = userReaction
    )
}

fun PostSourceDTO.toEntity(): PostSourceEntity {
    return PostSourceEntity(
        data = data,
        platform = platform,
        type = type
    )
}

fun RepostsDTO.toEntity(): RepostsEntity {
    return RepostsEntity(
        count = count,
        wallCount = wallCount,
        mailCount = mailCount,
        userReposted = userReposted
    )
}

fun ViewsDTO.toEntity(): ViewsEntity {
    return ViewsEntity(
        count = count
    )
}
