package ca.destiny.battle.integration.soldier;

import ca.destiny.ApplicationTest;
import ca.destiny.battle.integration.BattleConfiguration;
import ca.destiny.destinytest.AbstractIntegration;
import ca.destiny.fighter.BattleFighterDto;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@Import(BattleConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class ThirdClassBattle extends AbstractIntegration {

    private String rootName;

    public ThirdClassBattle() {
        super(ThirdClassBattle.class);
    }

    @Test
    void merge() throws IOException, URISyntaxException {
        rootName = "Whutchan/";
        List<BattleFighterDto> res = get("apprentices.json");
        res.addAll(get("noClassFighters.json"));
        res.addAll(get("thirdClasses.json"));
        res.addAll(get("secondClasses.json"));
        res.addAll(get("firstClasses.json"));
        res.addAll(get("sergeants.json"));
        res.addAll(get("sergeantsMayor.json"));
        res.addAll(get("warrantOfficers.json"));
        res.addAll(get("officers.json"));
        res.addAll(get("mayors.json"));
        res.addAll(get("colonels.json"));
        res.addAll(get("firstLieutenants.json"));
        res.addAll(get("lieutenants.json"));
        res.addAll(get("juniorLieutenants.json"));
        res.addAll(get("admirals.json"));
        res.addAll(get("viceAdmirals.json"));
        res.addAll(get("subAdmirals.json"));
        res.addAll(get("grandAdmirals.json"));
        res.addAll(get("rearAdmirals.json"));
        writeData(res, "whutchan.json");
    }

    private List<BattleFighterDto> get(String s) throws java.net.URISyntaxException, java.io.IOException {
        return loadListFromFile(rootName + s, new TypeReference<>() {
        });
    }
}
