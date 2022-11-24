package ca.destiny.battle2;

public class DuelAction implements Action {
    private DuelExecutor duelExecutor;
    private Duel duel;

    public DuelAction(DuelExecutor duelExecutor, Duel duel) {
        super();
        this.duelExecutor = duelExecutor;
        this.duel = duel;
    }

    @Override
    public void execute() {
        duelExecutor.execute(duel);
    }
}
