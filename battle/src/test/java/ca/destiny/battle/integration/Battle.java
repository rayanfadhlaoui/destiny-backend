package ca.destiny.battle.integration;

import ca.destiny.battle.factory.BattleBuilder;
import ca.destiny.battle.factory.BattleType;
import ca.destiny.battle.model.BattleDto;
import ca.destiny.battle.simulation.SimulationBattleExecutor;
import ca.destiny.destinytest.AbstractIntegration;
import ca.destiny.fighter.*;
import ca.destiny.fighter.equipment.weapon.*;
import ca.destiny.other.RandomNumberGeneratorService;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.NoSuchFileException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public abstract class Battle extends AbstractIntegration {

    private final SimulationBattleExecutor simulationBattleExecutor;

    private final RandomNumberGeneratorService randomNumberGeneratorService;

    private final OptimalWeaponFinder optimalWeaponFinder;

    public Battle(Class<?> aClass,
                  OptimalWeaponFinder optimalWeaponFinder,
                  RandomNumberGeneratorService randomNumberGeneratorService,
                  SimulationBattleExecutor simulationBattleExecutor) {
        super(aClass);
        this.simulationBattleExecutor = simulationBattleExecutor;
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.optimalWeaponFinder = optimalWeaponFinder;
    }

    protected void exam(String inputFile, String outputFile, String loserFile, int nbRounds) throws IOException, URISyntaxException {
        List<BattleFighterDto> participants = loadListFromFile(inputFile, new TypeReference<>() {
        });
        exam(participants, outputFile, loserFile, nbRounds);
    }

    protected void exam(List<BattleFighterDto> participants, String outputFile, String loserFile, int nbRounds) throws IOException, URISyntaxException {

        if (participants.size() % 2 == 1) {
            throw new IllegalArgumentException(participants.size() + " Not even");
        }

        List<WeaponDto> weapons = Arrays.asList(createDagger(), createSword(), createAxe(), createFist());
        participants.forEach(w -> {
            var all = new ArrayList<>(weapons);
            WeaponDto rightWeapon = w.getEquipmentDto().getRightWeapon();
            all.add(rightWeapon);
            WeaponDto optimal = optimalWeaponFinder.findOptimal(all, w.getCharacteristics());
            w.getEquipmentDto().setRightWeapon(optimal);
        });

        reassignIds(participants);
        Map<Long, Integer> score = new HashMap<>();
        participants.forEach(p -> score.put(p.getId(), 0));
        for (int i = 0; i < nbRounds; i++) {
            Collections.shuffle(participants);
            round(participants, score);
            if (i == nbRounds / 2) {
                participants.forEach(w -> {
                    var all = new ArrayList<>(weapons);
                    all.add(w.getEquipmentDto().getRightWeapon());
                    WeaponDto optimal = optimalWeaponFinder.findOptimal(all, w.getCharacteristics());
                    w.getEquipmentDto().setRightWeapon(optimal);
                });
            }
        }

        List<BattleFighterDto> sorted = score.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .map(Map.Entry::getKey)
                .map(id -> participants.stream().filter(a -> a.getId() == id).findFirst().orElseThrow(() -> new RuntimeException(String.valueOf(id))))
                .collect(Collectors.toList());
        List<BattleFighterDto> promoted = new ArrayList<>();
        List<BattleFighterDto> losers = new ArrayList<>();
        int count = 0;
        for (BattleFighterDto fighter : sorted) {
            if (count < laureate()) {
                promoted.add(fighter);
            } else {
                losers.add(fighter);
            }
            int age = fighter.getPerson().getAge();
            fighter.getPerson().setAge(age + 1);
            count++;
        }
        promoted.forEach(w -> {
            while (randomNumberGeneratorService.getRandomNumberInts(0, specialisationDifficulty()) == 0) {
                w.addSpecialisation(SpecialisationEnum.values()[randomNumberGeneratorService.getRandomNumberInts(0, 5)]);
            }

            w.setClassEnum(getPromotion());
            var all = new ArrayList<>(weapons);
            all.add(w.getEquipmentDto().getRightWeapon());
            WeaponDto optimal = optimalWeaponFinder.findOptimal(all, w.getCharacteristics());
            w.getEquipmentDto().setRightWeapon(optimal);
        });

        writePromoted(outputFile, promoted);
        writeData(losers, loserFile);
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

    protected abstract int laureate();

    protected abstract ClassEnum getPromotion();

    protected abstract int specialisationDifficulty();

    protected abstract int getMinimumDamage();

    protected abstract int getMaximumDamage();

    protected abstract String getWeaponName();

    private WeaponDto createAxe() {
        WeaponDto weaponDto = new AxeDto();
        weaponDto.setPenetration(1);
        weaponDto.setName(getWeaponName() + " axe");
        weaponDto.setMinimumDamage(getMinimumDamage());
        weaponDto.setMaximumDamage(getMaximumDamage());
        weaponDto.setAbilityBonus(createAbilityBonus(0, 0, 0));
        return weaponDto;
    }

    private WeaponDto createSword() {
        WeaponDto weaponDto = new SwordDto();
        weaponDto.setPenetration(1);
        weaponDto.setName(getWeaponName() + " sword");
        weaponDto.setMinimumDamage(getMinimumDamage());
        weaponDto.setMaximumDamage(getMaximumDamage());
        weaponDto.setAbilityBonus(createAbilityBonus(0, 0, 0));
        return weaponDto;
    }

    private WeaponDto createDagger() {
        WeaponDto weaponDto = new DaggerDto();
        weaponDto.setPenetration(1);
        weaponDto.setName(getWeaponName() + " dagger");
        weaponDto.setMinimumDamage(getMinimumDamage());
        weaponDto.setMaximumDamage(getMaximumDamage());
        weaponDto.setAbilityBonus(createAbilityBonus(0, 0, 0));
        return weaponDto;
    }

    private WeaponDto createFist() {
        WeaponDto weaponDto = new FistDto();
        weaponDto.setPenetration(10);
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

    private void reassignIds(List<BattleFighterDto> list) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        list.forEach(c -> {
            c.setId(atomicInteger.getAndIncrement());
        });
    }

    private void round(List<BattleFighterDto> list, Map<Long, Integer> score) {
        for (int i = 0; i < list.size(); i += 2) {
            BattleFighterDto battleFighterDto = list.get(i);
            refresh(battleFighterDto);
            BattleFighterDto battleFighterDto2 = list.get(i + 1);
            refresh(battleFighterDto2);

            var battleDto = createBattleDto(battleFighterDto, battleFighterDto2);
            BattleDto res = simulationBattleExecutor.execute(battleDto);
            var winner = res.getSummary().getWinners().get(0);
            refresh(battleFighterDto);
            refresh(battleFighterDto2);
            score.putIfAbsent(winner.getId(), 0);
            score.computeIfPresent(winner.getId(), (k, v) -> v + 1);
        }
    }

    private void refresh(BattleFighterDto battleFighterDto) {
        CharacteristicsDto characteristics = battleFighterDto.getCharacteristics();
        int speed = characteristics.getSpeed();
        int vitality = characteristics.getVitality();
        int resistance = characteristics.getResistance();
        BattleInformation battleInformation = battleFighterDto.getBattleInformation();
        battleInformation.setSpeed(speed);
        battleInformation.setResistance(resistance);
        battleInformation.setVitality(vitality);
    }

    private BattleDto createBattleDto(BattleFighterDto battleFighterDto,
                                      BattleFighterDto battleFighterDto2) {
        return BattleBuilder.initWith(BattleType.DUEL_SINGLE_CELL)
                .addFighters(battleFighterDto, battleFighterDto2)
                .build();
    }
}
