package ca.destiny.exam;

import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.fighter.equipment.weapon.*;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Exam {

    public static final int NB_ROUNDS = 30;

    private final OptimalWeaponFinder optimalWeaponFinder;
    private final RoundExecutor roundExecutor;

    public Exam(OptimalWeaponFinder optimalWeaponFinder,
                RoundExecutor roundExecutor) {
        this.roundExecutor = roundExecutor;
        this.optimalWeaponFinder = optimalWeaponFinder;
    }

    public Map<ExamStatus, List<BattleFighterDto>> exam(List<BattleFighterDto> fighters, int laureate) {
        ClassEnum previous = getPromotion().getPrevious();
        List<BattleFighterDto> participants = fighters.stream()
                .filter(f -> f.getClassEnum() == previous)
                .filter(f -> f.getBattleInformation().getFightingStatus().isAlive())
                .collect(Collectors.toList());

        List<WeaponDto> weapons = Arrays.asList(createDagger(), createSword(), createAxe(), createFist());
        participants.forEach(w -> {
            var all = new ArrayList<>(weapons);
            WeaponDto rightWeapon = w.getEquipmentDto().getRightWeapon();
            all.add(rightWeapon);
            WeaponDto optimal = optimalWeaponFinder.findOptimal(all, w.getCharacteristics());
            w.getEquipmentDto().setRightWeapon(optimal);
        });

        Map<Long, Integer> score = roundExecutor.execute(participants, NB_ROUNDS);

        List<BattleFighterDto> sorted = score.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .map(Map.Entry::getKey)
                .map(id -> participants.stream().filter(a -> a.getId() == id).findFirst().orElseThrow(() -> new RuntimeException(String.valueOf(id))))
                .filter(f -> f.getBattleInformation().getFightingStatus().isAlive())
                .collect(Collectors.toList());

        List<BattleFighterDto> promoted = new ArrayList<>();
        List<BattleFighterDto> rejected = new ArrayList<>();
        int count = 0;
        for (BattleFighterDto fighter : sorted) {
            if (count < laureate) {
                promoted.add(fighter);
            } else {
                rejected.add(fighter);
            }
            int age = fighter.getPerson().getAge();
            fighter.getPerson().setAge(age + 1);
            count++;
        }

        promoted.forEach(w -> {
            w.setClassEnum(getPromotion());
            var all = new ArrayList<>(weapons);
            all.add(w.getEquipmentDto().getRightWeapon());
            WeaponDto optimal = optimalWeaponFinder.findOptimal(all, w.getCharacteristics());
            w.getEquipmentDto().setRightWeapon(optimal);
        });

        Map<ExamStatus, List<BattleFighterDto>> result = new HashMap<>();
        result.put(ExamStatus.PROMOTED, promoted);
        result.put(ExamStatus.REJECTED, rejected);
        return result;
    }

    protected abstract ClassEnum getPromotion();

    protected abstract int getMinimumDamage();

    protected abstract int getMaximumDamage();

    protected abstract String getWeaponName();

    private WeaponDto createAxe() {
        WeaponDto weaponDto = new AxeDto();
        weaponDto.setBlunt(1);
        weaponDto.setName(getWeaponName() + " axe");
        weaponDto.setMinimumDamage(getMinimumDamage());
        weaponDto.setMaximumDamage(getMaximumDamage());
        weaponDto.setAbilityBonus(createAbilityBonus(0, 0, 0));
        return weaponDto;
    }

    private WeaponDto createSword() {
        WeaponDto weaponDto = new SwordDto();
        weaponDto.setBlunt(1);
        weaponDto.setName(getWeaponName() + " sword");
        weaponDto.setMinimumDamage(getMinimumDamage());
        weaponDto.setMaximumDamage(getMaximumDamage());
        weaponDto.setAbilityBonus(createAbilityBonus(0, 0, 0));
        return weaponDto;
    }

    private WeaponDto createDagger() {
        WeaponDto weaponDto = new DaggerDto();
        weaponDto.setBlunt(1);
        weaponDto.setName(getWeaponName() + " dagger");
        weaponDto.setMinimumDamage(getMinimumDamage());
        weaponDto.setMaximumDamage(getMaximumDamage());
        weaponDto.setAbilityBonus(createAbilityBonus(0, 0, 0));
        return weaponDto;
    }

    private WeaponDto createFist() {
        WeaponDto weaponDto = new FistDto();
        weaponDto.setBlunt(1);
        weaponDto.setName(getWeaponName() + " fist");
        weaponDto.setMinimumDamage(getMinimumDamage());
        weaponDto.setMaximumDamage(getMaximumDamage());
        weaponDto.setAbilityBonus(createAbilityBonus(0, 0, 0));
        return weaponDto;
    }

    private AbilityBonus createAbilityBonus(int strength, int speed, int dexterity) {
        AbilityBonus abilityBonus = new AbilityBonus();
        abilityBonus.setDexterity(dexterity);
        abilityBonus.setSpeed(speed);
        abilityBonus.setStrength(strength);
        return abilityBonus;
    }
}
