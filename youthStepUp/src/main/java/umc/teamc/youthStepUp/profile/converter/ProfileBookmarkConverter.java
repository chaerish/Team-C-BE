package umc.teamc.youthStepUp.profile.converter;

import org.springframework.data.domain.Slice;
import umc.teamc.youthStepUp.calendar.entity.Bookmark;
import umc.teamc.youthStepUp.profile.dto.response.BookmarkResponseDTO;
import umc.teamc.youthStepUp.profile.dto.response.BookmarkSliceResponseDTO;

import java.util.ArrayList;

public class ProfileBookmarkConverter {
    public static BookmarkResponseDTO toBookmarkResponseDTO(Bookmark bookmark) {
        return new BookmarkResponseDTO(
                bookmark.getId(),
                bookmark.getPolicy().getId(),
                bookmark.getName()
        );
    }

    public static BookmarkSliceResponseDTO toBookmarkSliceResponseDTO(Slice<Bookmark> bookmarks) {
        return new BookmarkSliceResponseDTO(
                bookmarks.getContent().isEmpty() ? new ArrayList<>() : bookmarks.getContent().stream().map(ProfileBookmarkConverter::toBookmarkResponseDTO).toList(),
                bookmarks.hasNext(),
                bookmarks.getContent().isEmpty() ? 0 : bookmarks.getContent().get(bookmarks.getContent().size() - 1).getId()
        );
    }
}
