package com.undecided.projectTemplate.modules.resource.domain.story.estimate.businessValue;

public enum BusinessQuolyty {
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

    BusinessQuolyty(String displayName, int value) {
        this.displayName = displayName;
        this.value = value;

    }

    public static BusinessQuolyty computeFrom(Emotion functionalEmotion,
        Emotion dysfunctionalEmotion) {
        return switch (functionalEmotion) {
            case EXPECT_IT -> switch (dysfunctionalEmotion) {
                case EXPECT_IT -> BusinessQuolyty.UNKNOWN;
                case LIKE_IT, NATURAL, CAN_TOLERATE_IT -> BusinessQuolyty.ATTRACTIVE;
                case DISLIKE_IT -> BusinessQuolyty.ONE_DIMENSIONAL;
            };
            case LIKE_IT, NATURAL, CAN_TOLERATE_IT -> switch (dysfunctionalEmotion) {
                case EXPECT_IT -> BusinessQuolyty.REVERSE;
                case LIKE_IT, NATURAL, CAN_TOLERATE_IT -> BusinessQuolyty.INDIFFERENT;
                case DISLIKE_IT -> BusinessQuolyty.MUST_BE;
            };
            case DISLIKE_IT -> switch (dysfunctionalEmotion) {
                case EXPECT_IT, LIKE_IT, NATURAL, CAN_TOLERATE_IT -> BusinessQuolyty.REVERSE;
                case DISLIKE_IT -> BusinessQuolyty.UNKNOWN;
            };
        };

    }

}
