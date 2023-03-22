package com.undecided.projectTemplate.resource.domain.story.estimate.businessValue;

public enum BusinessQuality {
    MUST_BE("必須", 100),
    ONE_DIMENSIONAL("それなり", 66),
    ATTRACTIVE("未食的", 33),
    INDIFFERENT("関心がない", 0),
    REVERSE("逆心的", -25),
    UNKNOWN("要確認", -100);

    private final String displayName;
    private final int value;

    public String getDisplayName() {
        return displayName;
    }

    public int getValue() {
        return value;
    }

    BusinessQuality(String displayName, int value) {
        this.displayName = displayName;
        this.value = value;

    }

    public static BusinessQuality computeFrom(Emotion functionalEmotion,
        Emotion dysfunctionalEmotion) {
        return switch (functionalEmotion) {
            case EXPECT_IT -> switch (dysfunctionalEmotion) {
                case EXPECT_IT -> BusinessQuality.UNKNOWN;
                case LIKE_IT, NATURAL, CAN_TOLERATE_IT -> BusinessQuality.ATTRACTIVE;
                case DISLIKE_IT -> BusinessQuality.ONE_DIMENSIONAL;
            };
            case LIKE_IT, NATURAL, CAN_TOLERATE_IT -> switch (dysfunctionalEmotion) {
                case EXPECT_IT -> BusinessQuality.REVERSE;
                case LIKE_IT, NATURAL, CAN_TOLERATE_IT -> BusinessQuality.INDIFFERENT;
                case DISLIKE_IT -> BusinessQuality.MUST_BE;
            };
            case DISLIKE_IT -> switch (dysfunctionalEmotion) {
                case EXPECT_IT, LIKE_IT, NATURAL, CAN_TOLERATE_IT -> BusinessQuality.REVERSE;
                case DISLIKE_IT -> BusinessQuality.UNKNOWN;
            };
        };

    }

}
