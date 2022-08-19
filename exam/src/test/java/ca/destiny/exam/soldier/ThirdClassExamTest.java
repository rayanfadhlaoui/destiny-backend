package ca.destiny.exam.soldier;

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
public class ThirdClassExamTest extends AbstractExamTest {

    public ThirdClassExamTest(@Autowired ThirdClassExam thirdClassExam) {
        super(ThirdClassExamTest.class, thirdClassExam);
    }

    @Test
    void thirdClassesExam_WithOld() throws IOException, URISyntaxException {
        exam("apprentices.json", "thirdClasses.json", "apprentices.json", 2500);
    }
}
