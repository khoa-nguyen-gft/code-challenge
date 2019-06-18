public class AppBefore {
    public static void main(String[] arg) {

        System.out.println(new Garland(new ChrismastTreeImpl()).decorate());
        System.out.println(new BubbleLights(new Garland(new ChrismastTreeImpl())).decorate());

    }
}

interface ChrismastTree {
    public String decorate();
}

class ChrismastTreeImpl implements ChrismastTree {

    @Override
    public String decorate() {
        return "Christmas tree";
    }

}

abstract class ChrismastTreeDecorate implements ChrismastTree {
    private ChrismastTree chrismastTree;

    public ChrismastTreeDecorate(ChrismastTree chrismastTree) {
        this.chrismastTree = chrismastTree;
    }

    @Override
    public String decorate() {
        return chrismastTree.decorate();
    }
}

class BubbleLights extends ChrismastTreeDecorate {
    public BubbleLights(ChrismastTree chrismastTree) {
        super(chrismastTree);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithGarland();
    }

    private String decorateWithGarland() {
        return " with Bubble Lights ";
    }
}

class Garland extends ChrismastTreeDecorate {
    public Garland(ChrismastTree chrismastTree) {
        super(chrismastTree);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithGarland();
    }

    private String decorateWithGarland() {
        return " with Garland";
    }
}