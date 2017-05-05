package P03_GraphicEditor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphicEditorTest {

    private GraphicEditor editor;

    @Before
    public void inicializeEditor() {
        editor = new GraphicEditor();
    }

    @Test
    public void drawCircle() throws Exception {
        Shape shape = new Circle();
        editor.drawShape(shape);
    }

    @Test
    public void drawRectangle() throws Exception {
        Shape shape = new Rectangle();
        editor.drawShape(shape);
    }

}