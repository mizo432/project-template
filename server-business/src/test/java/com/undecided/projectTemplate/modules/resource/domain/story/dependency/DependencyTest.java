package com.undecided.projectTemplate.modules.resource.domain.story.dependency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.undecided.projectTemplate.modules.resource.domain.story.Story;
import com.undecided.projectTemplate.shared.entity.id.Identifier;
import org.junit.jupiter.api.Test;

class DependencyTest {

    /**
     * Method under test: {@link Dependency#reconstruct(String, String, String)}
     */
    @Test
    void testReconstruct() {
        Dependency actualReconstructResult = Dependency.reconstruct("42", "42", "42");
        System.out.println(actualReconstructResult);
        Identifier<Story> sourceStoryId = actualReconstructResult.getSourceStoryId();
        Identifier<Story> destStoryId = actualReconstructResult.getDestStoryId();
        assertEquals(sourceStoryId, destStoryId);
        Identifier<Dependency> id = actualReconstructResult.getId();
        assertEquals(destStoryId, id);
        assertEquals("42", destStoryId.getValue());
        assertEquals("42", id.getValue());
        assertEquals("42", sourceStoryId.getValue());
    }

    /**
     * Method under test: {@link Dependency#reconstruct(String, String, String)}
     */
    @Test
    void testReconstruct2() {
        Dependency actualReconstructResult = Dependency.reconstruct("foo", "foo", "foo");
        Identifier<Story> sourceStoryId = actualReconstructResult.getSourceStoryId();
        Identifier<Story> destStoryId = actualReconstructResult.getDestStoryId();
        assertEquals(sourceStoryId, destStoryId);
        Identifier<Dependency> id = actualReconstructResult.getId();
        assertEquals(destStoryId, id);
        assertEquals("foo", destStoryId.getValue());
        assertEquals("foo", id.getValue());
        assertEquals("foo", sourceStoryId.getValue());
    }

    /**
     * Method under test: {@link Dependency#reconstruct(String, String, String)}
     */
    @Test
    void testReconstruct3() {
        Dependency actualReconstructResult = Dependency.reconstruct("", "42", "42");
        Identifier<Story> sourceStoryId = actualReconstructResult.getSourceStoryId();
        Identifier<Story> destStoryId = actualReconstructResult.getDestStoryId();
        assertEquals(sourceStoryId, destStoryId);
        assertEquals("42", destStoryId.getValue());
        assertEquals("42", sourceStoryId.getValue());
    }
}

