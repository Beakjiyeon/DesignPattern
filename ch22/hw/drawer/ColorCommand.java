package ch22.hw.drawer;

import java.awt.Color;
import ch22.hw.command.Command;

public class ColorCommand implements Command {
    // 그리는 대상
    protected Drawable drawable;
    // 그리는 색
    private Color color;
    // 생성자
    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }
    // 실행
    public void execute() {
        drawable.setColor(color);
    }
}