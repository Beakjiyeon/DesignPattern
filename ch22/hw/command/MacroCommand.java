package ch22.hw.command;

import java.util.Stack;
import java.util.Iterator;

public class MacroCommand implements Command {
    // ����� ����
    private Stack commands = new Stack();
    // ������ : redo ��� ������ ���� ����
    // ������ : undo�� ���� �����Ǿ��� ��ɾ���� �����ϴ� ����
    private Stack commandsForRedo = new Stack();
    // ����
    public void execute() {
        Iterator it = commands.iterator();
        while (it.hasNext()) {
            ((Command)it.next()).execute();
        }
    }
    // �߰�
    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }
    // ������ ����� ����
    // ������ : commands �Ӽ����� �ֱ� ����� �����Ͽ� 
    // ������ : commandsForRedo �Ӽ��� �߰��Ѵ�.
    public void undo() {
        if (!commands.empty()) {
        	commandsForRedo.push(commands.pop());
        }
    }
    // ������ : redo �߰�
    // ������ : commandsForRedo �Ӽ����� �ֱ� ��ɾ���� �����Ͽ�
    // ������ : commands �Ӽ��� �߰��Ѵ�.
    // ������ : �ǵ�����
    public void redo(){
    	if(!commandsForRedo.empty()){
    		commands.push(commandsForRedo.pop());
    	}
    }
    // ���� ����
    public void clear() {
        commands.clear();
    }
}
