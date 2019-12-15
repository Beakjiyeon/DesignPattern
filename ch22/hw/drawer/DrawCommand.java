package ch22.hw.drawer;

import java.awt.Point;
import ch22.hw.command.Command;

public class DrawCommand implements Command {
    // �׸� �׸��� ���
    protected Drawable drawable;
    // �׸� �׸��� ��ġ
    private Point position;
    // ������
    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }
    // ����
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
