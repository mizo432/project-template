package org.venusPj.projectTemplate.modules.resource.domain.story.attribute;

import static org.venusPj.projectTemplate.shared.precondition.object.ObjectPreconditions.checkNotNull;

import org.jetbrains.annotations.NotNull;
import org.venusPj.projectTemplate.shared.value.ValueNotFoundException;
import org.venusPj.projectTemplate.shared.value.description.Description;

public enum StoryState {
    SUGGESTED(1, "sandbox", Description.of("検討中、業務的価値を検討中")),
    ACCEPTED(2, "backlog", Description.of("見積り中、対応確定、見積り中")),
    ESTIMATED(3, "backlog", Description.of("見積り済み、対応スプリント決定待ち")),
    PLANNED(4, "sprint", Description.of("未着手、着手待ち")),
    IN_PROGRESS(5, "sprint", Description.of("着手中")),
    IN_REVIEW(6, "sprint", Description.of("検証中")),
    DONE(7, "sprint", Description.of("完了")),
    FROZEN(-1, "backlog", Description.of("対応凍結"));

    private final String boxName;
    private final Integer id;
    private final Description description;

    public String getBoxName() {
        return boxName;
    }

    public Description getDescription() {
        return description;
    }

    StoryState(Integer id, String boxName, Description description) {
        this.id = id;
        this.boxName = boxName;
        this.description = description;
    }

    public static @NotNull StoryState valueOfStateId(@NotNull Integer stateId) {
        checkNotNull(stateId, "stateId");
        for (StoryState value : values()) {
            if (value.id.equals(stateId)) {
                return value;
            }

        }
        throw new ValueNotFoundException("該当するStoryStateが見つかりません。stateId:" + stateId);
    }
}
