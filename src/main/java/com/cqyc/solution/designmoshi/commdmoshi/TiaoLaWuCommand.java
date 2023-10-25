package com.cqyc.solution.designmoshi.commdmoshi;

/**
 * @author cqyc
 * @create 2023-10-25-10:16
 */
public class TiaoLaWuCommand implements Command{

    private MiMiReceiver receiver;

    public TiaoLaWuCommand(MiMiReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.tiaoLaWu();
    }
}
