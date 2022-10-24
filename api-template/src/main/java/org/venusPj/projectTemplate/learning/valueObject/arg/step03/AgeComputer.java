package org.venusPj.projectTemplate.learning.valueObject.arg.step03;

import java.time.LocalDate;
import org.jetbrains.annotations.NotNull;
import org.venusPj.precondition.object.ObjectPrecondition;

public class AgeComputer {

    /**
     * 生年月日から対象年月日時点の年齢を求める
     * <pre>
     * 1. [現在年ー生まれ年]により基準となる年齢を計算する。
     * 2. 今年誕生日を迎えているかを判断する。
     * 　　      2.1. [現在月 < 誕生月]であれば年齢を－１する。
     * 　　      2.2. [現在月 = 誕生月]ではあるが[現在日 < 誕生日]であれば年齢－１する。
     *
     * </pre>
     *
     * @param birthDate  生年月日
     * @param targetDate 対象年月日
     * @return 年齢
     * @throws IllegalArgumentException 対象年月日が生年月日以前の場合にスローします。
     */
    public int computeAge(@NotNull LocalDate birthDate, @NotNull LocalDate targetDate)
        throws IllegalArgumentException {
        ObjectPrecondition.checkNotNull(targetDate, () ->
            new IllegalArgumentException("対象年月日が指定されていません"));
        ObjectPrecondition.checkNotNull(birthDate, () ->
            new IllegalArgumentException("生年月日が指定されていません"));

        BirthDate wBirthDate = BirthDate.of(birthDate);
        TargetDate targetDate1 = TargetDate.of(targetDate);

        return wBirthDate.computeAge2(targetDate1);

    }

}
