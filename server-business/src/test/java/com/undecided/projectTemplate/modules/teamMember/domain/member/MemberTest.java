package com.undecided.projectTemplate.modules.teamMember.domain.member;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import org.junit.jupiter.api.Test;

class MemberTest {

    /**
     * Method under test:
     * {@link Member#Member(UlidIdentifier, AuditInfo, MemberName, MemberInitial)}
     */
    @Test
    void testConstructor() {
        UlidIdentifier<Member> emptyResult = UlidIdentifier.empty();
        AuditInfo emptyResult1 = AuditInfo.empty();
        MemberName ofResult = MemberName.of("42");
        MemberInitial ofResult1 = MemberInitial.of("42");
        Member actualMember = new Member(emptyResult, emptyResult1, ofResult, ofResult1);

        AuditInfo auditInfo = actualMember.getAuditInfo();
        assertSame(emptyResult1, auditInfo);
        MemberName name = actualMember.getName();
        assertSame(ofResult, name);
        UlidIdentifier<Member> id = actualMember.getId();
        assertSame(emptyResult, id);
        MemberInitial initial = actualMember.getInitial();
        assertSame(ofResult1, initial);
        assertTrue(id.isEmpty());
        assertFalse(initial.isEmpty());
        assertTrue(auditInfo.isEmpty());
        assertFalse(name.isEmpty());
        assertTrue(auditInfo.getWhenNoticed().isEmpty());
        assertTrue(auditInfo.getWhoNoticed().isEmpty());
    }

    @Test
    void testToString() {
        UlidIdentifier<Member> emptyResult = UlidIdentifier.empty();
        AuditInfo emptyResult1 = AuditInfo.empty();
        MemberName ofResult = MemberName.of("42");
        MemberInitial ofResult1 = MemberInitial.of("42");
        Member actualMember = new Member(emptyResult, emptyResult1, ofResult, ofResult1);

        System.out.println(actualMember);

    }
}

