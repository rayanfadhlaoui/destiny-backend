package ca.destiny.exam;

import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.fighter.equipment.weapon.*;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public abstract class Exam {

    public static final int NB_ROUNDS = 5;

    private final OptimalWeaponFinder optimalWeaponFinder;
    private final PromotedFilter promotedFilter;
    private final RoundExecutor roundExecutor;

    public Exam(OptimalWeaponFinder optimalWeaponFinder,
                PromotedFilter promotedFilter,
                RoundExecutor roundExecutor) {
        this.promotedFilter = promotedFilter;
        this.roundExecutor = roundExecutor;
        this.optimalWeaponFinder = optimalWeaponFinder;
    }

    public void exam(List<BattleFighterDto> fighters, int laureate, List<Supplier<WeaponDto>> weaponSuppliers) {
        List<BattleFighterDto> participants = getParticipants(fighters);
        List<BattleFighterDto> promoted = new ArrayList<>();
        List<BattleFighterDto> rejected = new ArrayList<>();
        int count = 0;
        while (promoted.size() != laureate) {
            Map<ExamStatus, List<BattleFighterDto>> examResult = executeExam(laureate - promoted.size(), participants);
            promoted.addAll(examResult.get(ExamStatus.PROMOTED));
            participants = examResult.get(ExamStatus.PENDING);
            rejected.addAll(examResult.get(ExamStatus.REJECTED));
            count++;
        }

        System.out.println("number of execution :" + count);

        applyPromotion(promoted, weaponSuppliers);
        applyDemotion(rejected);
    }

    private void applyDemotion(List<BattleFighterDto> rejected) {
        rejected.forEach(w -> {
            w.setClassEnum(getPromotion().getPrevious());
        });
    }

    private Map<ExamStatus, List<BattleFighterDto>> executeExam(int laureate, List<BattleFighterDto> participants) {
        Map<Long, Integer> score = roundExecutor.execute(participants, NB_ROUNDS);

        return promotedFilter.sort(participants, score, laureate);
    }

    private void applyPromotion(List<BattleFighterDto> promoted, List<Supplier<WeaponDto>> weaponSuppliers) {
        List<Supplier<WeaponDto>> localWeaponSuppliers = Arrays.asList(this::createDagger,
                this::createSword,
                this::createAxe,
                this::createFist);

        weaponSuppliers.addAll(localWeaponSuppliers);

        var weapons = weaponSuppliers.stream()
                .map(Supplier::get)
                .collect(Collectors.toList());

        promoted.forEach(w -> {
            w.setClassEnum(getPromotion());
            var all = new ArrayList<>(weapons);
            all.add(w.getEquipmentDto().getRightWeapon());
            optimalWeaponFinder.findOptimal(all, w.getBattleInformation())
                    .ifPresent(optimal -> w.getEquipmentDto().setRightWeapon(optimal));
        });
    }

    private List<BattleFighterDto> getParticipants(List<BattleFighterDto> fighters) {
        ClassEnum previous = getPromotion().getPrevious();
        return fighters.stream()
                .filter(f -> f.getClassEnum() == previous || f.getClassEnum() == getPromotion())
                .filter(f -> f.getBattleInformation().getFightingStatus().isAlive())
                .collect(Collectors.toList());
    }

    protected abstract ClassEnum getPromotion();

    protected abstract int getMinimumDamage();

    protected abstract int getMaximumDamage();

    protected abstract String getWeaponName();

    protected abstract int getStaminaNeeded();

    protected abstract int getMinimalDexterity();

    protected abstract int getOptimalDexterity();

    private WeaponDto createAxe() {
        WeaponDto weaponDto = new AxeDto();
        weaponDto.setBlunt(1);
        weaponDto.setName(getWeaponName() + " axe");
        weaponDto.setMinimumDamage(getMinimumDamage());
        weaponDto.setMaximumDamage(getMaximumDamage());
        weaponDto.setStaminaNeeded(getStaminaNeeded());
        weaponDto.setOptimalDexterity(getOptimalDexterity());
        weaponDto.setMinimumDexterity(getMinimalDexterity());
        weaponDto.setAbilityBonus(createAbilityBonus(0, 0, 0));
        return weaponDto;
    }

    private WeaponDto createSword() {
        WeaponDto weaponDto = new SwordDto();
        weaponDto.setBlunt(1);
        weaponDto.setName(getWeaponName() + " sword");
        weaponDto.setMinimumDamage(getMinimumDamage());
        weaponDto.setMaximumDamage(getMaximumDamage());
        weaponDto.setStaminaNeeded(getStaminaNeeded());
        weaponDto.setOptimalDexterity(getOptimalDexterity());
        weaponDto.setMinimumDexterity(getMinimalDexterity());
        weaponDto.setAbilityBonus(createAbilityBonus(0, 0, 0));
        return weaponDto;
    }

    private WeaponDto createDagger() {
        WeaponDto weaponDto = new DaggerDto();
        weaponDto.setBlunt(1);
        weaponDto.setName(getWeaponName() + " dagger");
        weaponDto.setMinimumDamage(getMinimumDamage());
        weaponDto.setMaximumDamage(getMaximumDamage());
        weaponDto.setStaminaNeeded(getStaminaNeeded());
        weaponDto.setOptimalDexterity(getOptimalDexterity());
        weaponDto.setMinimumDexterity(getMinimalDexterity());
        weaponDto.setAbilityBonus(createAbilityBonus(0, 0, 0));
        return weaponDto;
    }

    private WeaponDto createFist() {
        WeaponDto weaponDto = new FistDto();
        weaponDto.setBlunt(1);
        weaponDto.setName(getWeaponName() + " fist");
        weaponDto.setMinimumDamage(getMinimumDamage());
        weaponDto.setMaximumDamage(getMaximumDamage());
        weaponDto.setStaminaNeeded(getStaminaNeeded());
        weaponDto.setOptimalDexterity(getOptimalDexterity());
        weaponDto.setMinimumDexterity(getMinimalDexterity());
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
