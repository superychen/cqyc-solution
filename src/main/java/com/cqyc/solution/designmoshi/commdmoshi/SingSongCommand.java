package com.cqyc.solution.designmoshi.commdmoshi;

/**
 * @author cqyc
 * @create 2023-10-25-10:14
 */
public class SingSongCommand implements Command{

    private BingbingReceiver bingbingReceiver;

    public SingSongCommand(BingbingReceiver bingbingReceiver) {
        this.bingbingReceiver = bingbingReceiver;
    }

    @Override
    public void execute() {
        bingbingReceiver.signSong();
    }
}
