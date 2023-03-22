package com.undecided.projectTemplate.modules.teamMember.domain.productOwner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.undecided.projectTemplate.modules.teamMember.domain.member.MemberInitial;
import com.undecided.projectTemplate.modules.teamMember.domain.member.MemberName;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.WhoNoticed;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import org.junit.jupiter.api.Test;

class ProductOwnerTest {

    /**
     * Method under test:
     * {@link ProductOwner#ProductOwner(UlidIdentifier, AuditInfo, MemberName, MemberInitial)}
     */
    @Test
    void testConstructor() {
        UlidIdentifier<ProductOwner> emptyResult = UlidIdentifier.empty();
        AuditInfo emptyResult1 = AuditInfo.empty();
        MemberName ofResult = MemberName.of("42");
        MemberInitial ofResult1 = MemberInitial.of("42");
        ProductOwner actualProductOwner = new ProductOwner(emptyResult, emptyResult1, ofResult,
            ofResult1);

        AuditInfo auditInfo = actualProductOwner.getAuditInfo();
        assertSame(emptyResult1, auditInfo);
        MemberName name = actualProductOwner.getName();
        assertSame(ofResult, name);
        UlidIdentifier<ProductOwner> id = actualProductOwner.getId();
        assertSame(emptyResult, id);
        MemberInitial initial = actualProductOwner.getInitial();
        assertSame(ofResult1, initial);
        assertNull(id.toString());
        assertFalse(initial.isEmpty());
        assertTrue(id.isEmpty());
        assertTrue(auditInfo.isEmpty());
        assertFalse(name.isEmpty());
        WhoNoticed whoNoticed = auditInfo.getWhoNoticed();
        assertTrue(whoNoticed.isEmpty());
        assertTrue(auditInfo.getWhenNoticed().isEmpty());
        assertNull(whoNoticed.toString());
        System.out.println(actualProductOwner);
    }
}

