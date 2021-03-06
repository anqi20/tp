package seedu.eduke8.topic;

import org.junit.jupiter.api.Test;
import seedu.eduke8.Eduke8Test;
import seedu.eduke8.common.Displayable;
import seedu.eduke8.exception.Eduke8Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TopicListTest extends Eduke8Test {
    private static final int DEFAULT_TOPIC_COUNT = 2;

    @Test
    void getCount_TwoTopics_returnsCountOfTwo() {
        TopicList topicList = createTestTopicList();

        assertEquals(DEFAULT_TOPIC_COUNT, topicList.getCount());
    }


    @Test
    void find_topicListWithTwoTopics_returnsFirstTopic() throws Eduke8Exception {
        TopicList topicList = createTestTopicList();
        Displayable topic1 = topicList.find(PLACEHOLDER_TOPIC_ONE_DESCRIPTION);

        assertEquals(PLACEHOLDER_TOPIC_ONE_DESCRIPTION, topic1.getDescription());
    }

    @Test
    void find_topicNotFound_expectEduke8Exception() {
        TopicList topicList = createTestTopicList();

        assertThrows(Eduke8Exception.class, () -> topicList.find(NONSENSE_DESCRIPTION));
    }
}
