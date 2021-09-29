package S202220005;

public class Snake extends Commander{
    @Override
    protected void execute(String step) {
        String[] couple = step.split("<->");
        Monster.getGourdByRank(Integer.parseInt(couple[0]))
                .swapPosition(Monster.getGourdByRank(Integer.parseInt(couple[1])));
    }
}
