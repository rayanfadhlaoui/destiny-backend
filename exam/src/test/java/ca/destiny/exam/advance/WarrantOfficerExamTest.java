package ca.destiny.exam.advance;

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
public class WarrantOfficerExamTest extends AbstractExamTest {

    public WarrantOfficerExamTest(@Autowired WarrantOfficerExam warrantOfficerExam) {
        super(WarrantOfficerExamTest.class, warrantOfficerExam);
    }

    @Test
    void warrantOfficerExam() throws IOException, URISyntaxException {
        exam("sergeantsMayor.json", "warrantOfficers.json", "sergeantsMayor.json", 500);
    }
}
