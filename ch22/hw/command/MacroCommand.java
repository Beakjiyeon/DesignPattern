package ch22.hw.command;

import java.util.Stack;
import java.util.Iterator;

public class MacroCommand implements Command {
    // 명령의 집합
    private Stack commands = new Stack();
    // 백지연 : redo 기능 구현을 위한 스택
    // 백지연 : undo로 인해 삭제되었던 명령어들을 보관하는 변수
    private Stack commandsForRedo = new Stack();
    // 실행
    public void execute() {
        Iterator it = commands.iterator();
        while (it.hasNext()) {
            ((Command)it.next()).execute();
        }
    }
    // 추가
    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }
    // 최후의 명령을 삭제
    // 백지연 : commands 속성에서 최근 명령을 삭제하여 
    // 백지연 : commandsForRedo 속성에 추가한다.
    public void undo() {
        if (!commands.empty()) {
        	commandsForRedo.push(commands.pop());
        }
    }
    // 백지연 : redo 추가
    // 백지연 : commandsForRedo 속성에서 최근 명령어들을 삭제하여
    // 백지연 : commands 속성에 추가한다.
    // 백지연 : 되돌리기
    public void redo(){
    	if(!commandsForRedo.empty()){
    		commands.push(commandsForRedo.pop());
    	}
    }
    // 전부 삭제
    public void clear() {
        commands.clear();
    }
}
