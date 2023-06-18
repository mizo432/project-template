package template.modules.story.domain.model.estimate.businessValue;

/**
 * 業務品質
 */
public enum BusinessQuality {
    /**
     * 必須
     */
    MUST_BE("必須", 100),
    /**
     * それなり
     */
    ONE_DIMENSIONAL("それなり", 66),
    /**
     * 魅力的
     */
    ATTRACTIVE("魅力的", 33),
    /**
     * 無関心
     */
    INDIFFERENT("関心がない", 0),
    /**
     * 逆心的
     */
    REVERSE("逆心的", -25),
    /**
     * 要確認
     */
    UNKNOWN("要確認", -100);

    /**
     * 表示名
     */
    private final String displayName;

    /**
     * 業務価値
     */
    private final int value;

    /**
     * コンストラクター
     *
     * @param displayName 表示名
     * @param value       値
     */
    BusinessQuality(String displayName, int value) {
        this.displayName = displayName;
        this.value = value;

    }

    /**
     * ビジネス価値を計算する
     *
     * @param functionalEmotion    機能じゅうぞく時感情
     * @param dysfunctionalEmotion 機能否じゅうぞく時感情
     * @return ビジネス価値
     */
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

    /**
     * 表示名を取得する
     *
     * @return 表示名
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 値の取得
     *
     * @return 値
     */
    public int getValue() {
        return value;
    }

}
