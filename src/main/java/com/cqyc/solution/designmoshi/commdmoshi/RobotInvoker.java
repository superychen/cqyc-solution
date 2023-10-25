package com.cqyc.solution.designmoshi.commdmoshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cqyc
 * @create 2023-10-25-10:17
 */
public class RobotInvoker {


    private List<Command> commands = new ArrayList<>();

    //直接往里面添加相关的命令，不管对应执行者
    public void addCommand(Command command) {
        commands.add(command);
    }

    //对于添加的命令执行
    public void executeCommand() {
        for (Command command : commands) {
            command.execute();
        }
    }


}
