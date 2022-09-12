package ca.destiny.exam;

import ca.destiny.destinytest.AbstractIntegration;
import ca.destiny.fighter.BattleFighterDto;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractExamTest extends AbstractIntegration {

    private final Exam exam;

    public AbstractExamTest(Class<?> aClass,
                            Exam exam) {
        super(aClass);
        this.exam = exam;
    }

    protected void exam(String inputFile, String outputFile, String loserFile, int laureate) throws IOException, URISyntaxException {
        List<BattleFighterDto> participants = loadListFromFile(inputFile, new TypeReference<>() {
        });
        exam(participants, outputFile, loserFile, laureate);
    }

    protected void exam(List<BattleFighterDto> participants, String outputFile, String loserFile, int laureate) throws IOException, URISyntaxException {

        if (participants.size() % 2 == 1) {
            throw new IllegalArgumentException(participants.size() + " Not even");
        }

        reassignIds(participants);
//         this.exam.exam(participants, laureate);
//
//        writePromoted(outputFile, results.get(ExamStatus.PROMOTED));
//        writeData(results.get(ExamStatus.REJECTED), loserFile);
    }

    private void writePromoted(String outputFile, List<BattleFighterDto> promoted) throws URISyntaxException, IOException {
        try {
            List<BattleFighterDto> oldPromoted = loadListFromFile(outputFile, new TypeReference<>() {
            });
            promoted.addAll(oldPromoted);
        } catch (NoSuchFileException e) {

        }
        writeData(promoted, outputFile);
    }

    private void reassignIds(List<BattleFighterDto> list) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        list.forEach(c -> {
            c.setId(atomicInteger.getAndIncrement());
        });
    }
}
