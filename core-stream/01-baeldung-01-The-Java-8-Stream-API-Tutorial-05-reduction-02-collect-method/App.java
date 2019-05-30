import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class App {
	public static void main(String[] args) {
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"), 
        new Product(14, "orange"),
        new Product(13, "lemon"), 
        new Product(23, "bread"), 
        new Product(13, "sugar"));
        
        
        //Converting a stream to the Collection (Collection, List or Set):
        productList
        .stream()
        .map(Product::getName)
        .collect(Collectors.toList())
        .forEach(System.out::println);
        
        
        //Converting a stream to the string array
        System.out.println(productList
        .stream()
        .map(Product::getName)
        .collect(Collectors.joining("; ", "[", "]")));
        
        //Processing the average value of all numeric elements of the stream
        System.out.println(productList.stream().collect(Collectors.averagingInt(Product::getPrice)).doubleValue());


        //Grouping of stream’s elements according to the specified function:
        System.out.println(productList.stream().collect(Collectors.groupingBy(Product::getPrice)));

        //Dividing stream’s elements into groups according to some predicate:
        System.out.println(productList.stream()
        		.collect(Collectors.partitioningBy(prod -> prod.getPrice() > 15)));

        
        //Multi-threading with Streams
        productList.parallelStream().forEach(System.out::println);
	}
}

class Product {
	private int price;
	private String name;

	
	@Override
	public String toString() {
        try {
			Thread.sleep(10);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "Product [price=" + price + ", name=" + name + "]";
	}



	public Product(int price, String name) {
		super();
		this.price = price;
		this.name = name;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}