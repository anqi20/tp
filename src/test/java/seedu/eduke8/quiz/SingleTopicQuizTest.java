package seedu.eduke8.quiz;

import org.junit.jupiter.api.Test;
import seedu.eduke8.Eduke8Test;
import seedu.eduke8.bookmark.BookmarkList;
import seedu.eduke8.exception.Eduke8Exception;
import seedu.eduke8.topic.Topic;
import seedu.eduke8.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SingleTopicQuizTest extends Eduke8Test {
    @Test
    public void startQuiz_zeroQuestions_expectEduke8Exception() {
        BookmarkList bookmarks = createTestBookmarkList();
        Topic topic = createTestTopic(PLACEHOLDER_TOPIC_ONE_DESCRIPTION);
        SingleTopicQuiz singleTopicQuiz = new SingleTopicQuiz(topic, 0, bookmarks, 10);

        assertThrows(Eduke8Exception.class, () -> singleTopicQuiz.startQuiz(new Ui()));
    }

    @Test
    public void startQuiz_tooManyQuestions_expectEduke8Exception() {
        BookmarkList bookmarks = createTestBookmarkList();
        Topic topic = createTestTopic(PLACEHOLDER_TOPIC_ONE_DESCRIPTION);
        int questionsInTopic = topic.getQuestionList().getCount();

        SingleTopicQuiz singleTopicQuiz = new SingleTopicQuiz(topic, questionsInTopic + 1, bookmarks, 10);

        assertThrows(Eduke8Exception.class, () -> singleTopicQuiz.startQuiz(new Ui()));
    }

}
