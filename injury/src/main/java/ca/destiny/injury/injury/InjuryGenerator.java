package ca.destiny.injury.injury;

public interface InjuryGenerator {
    InjuryGenerator EMPTY = new NoneInjuryGenerator(null);

    void inflict(boolean knockout);
}
