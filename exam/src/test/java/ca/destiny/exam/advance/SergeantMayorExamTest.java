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
public class SergeantMayorExamTest extends AbstractExamTest {

    public SergeantMayorExamTest(@Autowired SergeantMayorExam sergeantMayorExam) {
        super(SergeantMayorExamTest.class, sergeantMayorExam);
    }

    @Test
    void sergeantMayorExam() throws IOException, URISyntaxException {
        exam("sergeants.json", "sergeantsMayor.json", "sergeants.json", 250);
    }
}
