package ca.destiny.battle.action;

import ca.destiny.fighter.equipment.weapon.FistDto;
import ca.destiny.fighter.equipment.weapon.WeaponDto;
import ca.destiny.other.RandomNumberGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class HitServiceTest {

    private final RandomNumberGeneratorService randomNumberGeneratorService = mock(RandomNumberGeneratorService.class);

    private final HitService hitService = new HitService(randomNumberGeneratorService);

    @Test
    void hitPercentage_dexterityScore600() {
        given(randomNumberGeneratorService.getRandomNumberInts(5, 50)).willReturn(50);
        int result = hitService.hitPercentage(50, 5000, createWeapon());
        assertThat(result).isEqualTo(600);
    }

    @Test
    void hitPercentage_dexterityScore480() {
        given(randomNumberGeneratorService.getRandomNumberInts(5, 50)).willReturn(40);
        int result = hitService.hitPercentage(50, 5000, createWeapon());
        assertThat(result).isEqualTo(480);
    }

    @Test
    void hitPercentage_dexterityScore480AndDodge0() {
        given(randomNumberGeneratorService.getRandomNumberInts(5, 50)).willReturn(40);
        int result = hitService.hitPercentage(50, 185, createWeapon());
        assertThat(result).isEqualTo(480);
    }

    @Test
    void hitPercentage_dexterityScore600AndDodge400() {
        given(randomNumberGeneratorService.getRandomNumberInts(5, 500)).willReturn(500);
        int result = hitService.hitPercentage(500, 0, createWeapon());
        assertThat(result).isEqualTo(1000);
    }

    private WeaponDto createWeapon() {
        FistDto fistDto = new FistDto();
        fistDto.setOptimalDexterity(50);
        fistDto.setMinimumDexterity(5);
        return fistDto;
    }
//
//    @Test
//    public void hitPercentage_positiveRange50() {
//        int result = hitService.hitPercentage(0, 0);
//        assertThat(result).isEqualTo(500);
//        result = hitService.hitPercentage(10, 0);
//        assertThat(result).isEqualTo(550);
//        result = hitService.hitPercentage(20, 0);
//        assertThat(result).isEqualTo(600);
//        result = hitService.hitPercentage(30, 0);
//        assertThat(result).isEqualTo(650);
//        result = hitService.hitPercentage(40, 0);
//        assertThat(result).isEqualTo(700);
//        result = hitService.hitPercentage(50, 0);
//        assertThat(result).isEqualTo(750);
//    }
//
//    @Test
//    public void hitPercentage_positiveRange70() {
//        int result = hitService.hitPercentage(60, 0);
//        assertThat(result).isEqualTo(780);
//        result = hitService.hitPercentage(70, 0);
//        assertThat(result).isEqualTo(810);
//    }
//
//    @Test
//    public void hitPercentage_positiveRange100() {
//        int result = hitService.hitPercentage(80, 0);
//        assertThat(result).isEqualTo(830);
//        result = hitService.hitPercentage(90, 0);
//        assertThat(result).isEqualTo(850);
//        result = hitService.hitPercentage(100, 0);
//        assertThat(result).isEqualTo(870);
//    }
//
//    @Test
//    public void hitPercentage_positiveRange130() {
//        int result = hitService.hitPercentage(110, 0);
//        assertThat(result).isEqualTo(880);
//        result = hitService.hitPercentage(120, 0);
//        assertThat(result).isEqualTo(890);
//        result = hitService.hitPercentage(130, 0);
//        assertThat(result).isEqualTo(900);
//    }
//
//    @Test
//    public void hitPercentage_positiveRangeOver130() {
//        int result = hitService.hitPercentage(140, 0);
//        assertThat(result).isEqualTo(900);
//        result = hitService.hitPercentage(150, 0);
//        assertThat(result).isEqualTo(900);
//        result = hitService.hitPercentage(160, 0);
//        assertThat(result).isEqualTo(900);
//    }
//
//    @Test
//    public void hitPercentage_negativeRange50() {
//        int result = hitService.hitPercentage(0, 0);
//        assertThat(result).isEqualTo(500);
//        result = hitService.hitPercentage(0, 10);
//        assertThat(result).isEqualTo(450);
//        result = hitService.hitPercentage(0, 20);
//        assertThat(result).isEqualTo(400);
//        result = hitService.hitPercentage(0, 30);
//        assertThat(result).isEqualTo(350);
//        result = hitService.hitPercentage(0, 40);
//        assertThat(result).isEqualTo(300);
//        result = hitService.hitPercentage(0, 50);
//        assertThat(result).isEqualTo(250);
//    }
//
//    @Test
//    public void hitPercentage_negativeRange70() {
//        int result = hitService.hitPercentage(0, 60);
//        assertThat(result).isEqualTo(220);
//        result = hitService.hitPercentage(0, 70);
//        assertThat(result).isEqualTo(190);
//    }
//
//    @Test
//    public void hitPercentage_negativeRange100() {
//        int result = hitService.hitPercentage(0, 80);
//        assertThat(result).isEqualTo(170);
//        result = hitService.hitPercentage(0, 90);
//        assertThat(result).isEqualTo(150);
//        result = hitService.hitPercentage(0, 100);
//        assertThat(result).isEqualTo(130);
//    }
//
//    @Test
//    public void hitPercentage_negativeRange130() {
//        int result = hitService.hitPercentage(0, 110);
//        assertThat(result).isEqualTo(120);
//        result = hitService.hitPercentage(0, 120);
//        assertThat(result).isEqualTo(110);
//        result = hitService.hitPercentage(0, 130);
//        assertThat(result).isEqualTo(100);
//    }
//
//    @Test
//    public void hitPercentage_negativeRangeUnder130() {
//        int result = hitService.hitPercentage(0, 140);
//        assertThat(result).isEqualTo(100);
//        result = hitService.hitPercentage(0, 150);
//        assertThat(result).isEqualTo(100);
//        result = hitService.hitPercentage(0, 160);
//        assertThat(result).isEqualTo(100);
//    }

}