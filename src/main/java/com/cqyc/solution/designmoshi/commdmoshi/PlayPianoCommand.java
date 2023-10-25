package com.cqyc.solution.designmoshi.commdmoshi;

/**
 * @author cqyc
 * @create 2023-10-25-10:16
 */
public class PlayPianoCommand implements Command{

    private BingbingReceiver receiver;

    public PlayPianoCommand(BingbingReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.playPiano();
    }
}
