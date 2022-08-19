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
public class FirstClassExamTest extends AbstractExamTest {

    public FirstClassExamTest(@Autowired FirstClassExam firstClassExam) {
        super(FirstClassExamTest.class, firstClassExam);
    }

    @Test
    void firstClassesExam_WithOld() throws IOException, URISyntaxException {
        exam("secondClasses.json", "firstClasses.json", "secondClasses.json", 500);
    }
}
