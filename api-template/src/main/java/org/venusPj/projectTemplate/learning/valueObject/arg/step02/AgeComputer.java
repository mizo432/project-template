package org.venusPj.projectTemplate.learning.valueObject.arg.step02;

import java.time.LocalDate;
import org.jetbrains.annotations.NotNull;

public class AgeComputer {

    /**
     * ���N��������Ώ۔N�������_�̔N������߂�
     * <pre>
     * 1. [���ݔN�[���܂�N]�ɂ���ƂȂ�N����v�Z����B
     * 2. ���N�a�������}���Ă��邩�𔻒f����B
     * �@�@      2.1. [���݌� < �a����]�ł���ΔN����|�P����B
     * �@�@      2.2. [���݌� = �a����]�ł͂��邪[���ݓ� < �a����]�ł���ΔN��|�P����B
     *
     * </pre>
     *
     * @param birthDate  ���N����
     * @param targetDate �Ώ۔N����
     * @return �N��
     * @throws IllegalArgumentException �Ώ۔N���������N�����ȑO�̏ꍇ�ɃX���[���܂��B
     */
    public int computeAge(@NotNull LocalDate birthDate, @NotNull LocalDate targetDate)
        throws IllegalArgumentException {
        BirthDate wBirthDate = BirthDate.of(birthDate);
        if (wBirthDate.asLocalDate().isAfter(targetDate)) {
            throw new IllegalArgumentException("�Ώ۔N���������N�����ȑO�̂��ߔN������߂��܂���");
        }
        int baseAge = targetDate.getYear() - wBirthDate.asLocalDate().getYear();
        if (targetDate.getMonthValue() < wBirthDate.asLocalDate().getMonthValue()) {
            return baseAge - 1;
        }
        if (targetDate.getMonth().equals(wBirthDate.asLocalDate().getMonth()) &&
            (targetDate.getDayOfMonth() < wBirthDate.asLocalDate().getDayOfMonth())) {
            return baseAge - 1;
        }

        return baseAge;

    }


}
