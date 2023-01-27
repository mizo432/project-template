package com.undecided.projectTemplate.modules.resource.domain.story.estimate.businessValue;

public enum Emotion {
    EXPECT_IT("魅力的"),
    LIKE_IT("好ましい"),
    NATURAL("何も感じない"),
    CAN_TOLERATE_IT("我慢できる"),
    DISLIKE_IT("気に入らない");
    private final String displayName;

    Emotion(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;

    }
}
