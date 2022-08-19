package ca.destiny.fighter.experience;

public class ExperienceDto {

    private int level = 1;
    private int currentExperience;
    private int worth;
    private int nextLevel;
    private PersonalImprovement personalImprovement;

    public int getCurrentExperience() {
        return currentExperience;
    }

    public void setCurrentExperience(int currentExperience) {
        this.currentExperience = currentExperience;
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }

    public int getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(int nextLevel) {
        this.nextLevel = nextLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PersonalImprovement getPersonalImprovement() {
        return personalImprovement;
    }

    public void setPersonalImprovement(PersonalImprovement personalImprovement) {
        this.personalImprovement = personalImprovement;
    }
}
