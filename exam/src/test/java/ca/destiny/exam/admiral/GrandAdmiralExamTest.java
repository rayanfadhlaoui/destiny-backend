package ca.destiny.exam.admiral;

import ca.destiny.ApplicationTest;
import ca.destiny.exam.AbstractExamTest;
import ca.destiny.exam.BattleConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URISyntaxException;

@ExtendWith(SpringExtension.class)
@Import(BattleConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class GrandAdmiralExamTest extends AbstractExamTest {

    public GrandAdmiralExamTest(@Autowired GrandAdmiralExam grandAdmiralExam) {
        super(GrandAdmiralExamTest.class, grandAdmiralExam);
    }

    @Test
    void grandAdmiralExam() throws IOException, URISyntaxException {
        exam("admirals.json", "grandAdmirals.json", "admirals.json", 1);
    }
}
