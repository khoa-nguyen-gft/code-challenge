package demo;

public class App{
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded from disk
        image.display(); 
        System.out.println("");
        
        //image will not be loaded from disk
        image.display(); 	
    }
}

interface Image{
    public void display();
}

class RealImage implements Image{
	private String  fileName;
	
	public RealImage(String fileName) {
		super();
		this.fileName = fileName;
		loadFromDisk(fileName);
	}

	@Override
	public void display() {
		System.out.println("Displaying: " + fileName);
	}
	
	private void loadFromDisk(String fileName) {
		System.out.println("Load: " + fileName);
	}
	
}

class ProxyImage  implements Image{
	private String fileName;
	private Image realImage;
	
	
	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}


	@Override
	public void display() {
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}
}
