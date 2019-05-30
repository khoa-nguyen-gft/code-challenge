package demo;

public class App{
    public static void main(String[] args) {
        Window decorate =  new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(new SimpleWindow()));
          
        decorate.getDescription();
    }
}

interface Window{
    public void Draw();
    public void getDescription();
}

class SimpleWindow implements Window{

	@Override
	public void Draw() {
		System.out.println("DRAW: simple window");
	}

	@Override
	public void getDescription() {
		System.out.println("DESCRIPTION: simple window");
	
	}
    
}

abstract class WindowDecorator implements Window {
	private Window window;
	

	public WindowDecorator(Window window) {
		super();
		this.window = window;
	}

	@Override
	public void Draw() {
		window.Draw();
	}

	@Override
	public void getDescription() {
		window.getDescription();
	}
	
}


class HorizontalScrollBarDecorator extends WindowDecorator {

	public HorizontalScrollBarDecorator(Window window) {
		super(window);
	}
	
	@Override
	public void Draw() {
		super.Draw();
		System.out.println("DRAW: Horizontal Scroll Bar Decorator");
	}

	@Override
	public void getDescription() {
		super.getDescription();
		System.out.println("DESCRIPTION: Horizontal Scroll Bar Decorator");

	}
	
}

class VerticalScrollBarDecorator extends WindowDecorator {

	public VerticalScrollBarDecorator(Window window) {
		super(window);
	}
	
	@Override
	public void Draw() {
		super.Draw();
		System.out.println("DRAW: Vertical Scroll Bar Decorator");
	}

	@Override
	public void getDescription() {
		super.getDescription();
		System.out.println("DESCRIPTION: Vertical Scroll Bar Decorator");

	}
	
}