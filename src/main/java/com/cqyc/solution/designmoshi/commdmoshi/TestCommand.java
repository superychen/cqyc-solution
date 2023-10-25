package com.cqyc.solution.designmoshi.commdmoshi;

/**
 * @author cqyc
 * @create 2023-10-25-10:20
 * 命令模式，具体调用者invoker，命令定义接口command, 命令具体实现类如signSongCommand，对应具体实现类的具体角色，如binbingReceiver
 */
public class TestCommand {

    public static void main(String[] args) {
        RobotInvoker robotInvoker = new RobotInvoker();

        BingbingReceiver bingbingReceiver = new BingbingReceiver();
        robotInvoker.addCommand(new SingSongCommand(bingbingReceiver));
        robotInvoker.addCommand(new PlayPianoCommand(bingbingReceiver));

        MiMiReceiver miMiReceiver = new MiMiReceiver();
        robotInvoker.addCommand(new TiaoLaWuCommand(miMiReceiver));

        robotInvoker.executeCommand();
    }

}
