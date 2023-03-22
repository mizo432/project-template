package com.undecided.projectTemplate.resource.domain.story.dependency;

import com.undecided.projectTemplate.resource.domain.story.Story;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DependencyTest {

    /**
     * Method under test: {@link Dependency#reconstruct(String, String, String)}
     */
    @Test
    void testReconstruct() {
        Dependency actualReconstructResult = Dependency.reconstruct("42", "42", "42");
        System.out.println(actualReconstructResult);
        UlidIdentifier<Story> sourceStoryId = actualReconstructResult.getSourceStoryId();
        UlidIdentifier<Story> destStoryId = actualReconstructResult.getDestStoryId();
        assertEquals(sourceStoryId, destStoryId);
        UlidIdentifier<Dependency> id = actualReconstructResult.getId();
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
        UlidIdentifier<Story> sourceStoryId = actualReconstructResult.getSourceStoryId();
        UlidIdentifier<Story> destStoryId = actualReconstructResult.getDestStoryId();
        assertEquals(sourceStoryId, destStoryId);
        UlidIdentifier<Dependency> id = actualReconstructResult.getId();
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
        UlidIdentifier<Story> sourceStoryId = actualReconstructResult.getSourceStoryId();
        UlidIdentifier<Story> destStoryId = actualReconstructResult.getDestStoryId();
        assertEquals(sourceStoryId, destStoryId);
        assertEquals("42", destStoryId.getValue());
        assertEquals("42", sourceStoryId.getValue());

        List<String> list = new ArrayList<>();
        for (String s : list) {

        }

    }
}

