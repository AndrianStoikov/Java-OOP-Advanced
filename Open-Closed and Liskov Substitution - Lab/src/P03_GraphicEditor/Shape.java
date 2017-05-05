package P03_GraphicEditor;

public abstract class Shape implements Drawable{

    public Shape() {

    }

    @Override
    public String draw() {
        return "I'm Shape";
    }
}
