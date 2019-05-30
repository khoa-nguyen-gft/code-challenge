
public class App {
    public static void main(String[] args) {
        AbstractFactory<Animal> animalFactory = FactoryProvider.getFactory("Animal");
        AbstractFactory<Color> colorFactory = FactoryProvider.getFactory("Color");

       Animal animal =  animalFactory.create("Dog");
       System.out.println(animal.getAnimal());
       System.out.println(animal.makeSound());

       Color color =  colorFactory.create("While");
       System.out.println(color.getColor());


    }
}

class FactoryProvider{
    public static AbstractFactory getFactory(String choice){
  
        if("Animal".equalsIgnoreCase(choice)){
            return new AnimalFactory();
        }
        else if("Color".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }
         
        return null;
    }
}


interface AbstractFactory<T>{
    T create(String  type);
}

class AnimalFactory implements AbstractFactory<Animal>{

    public Animal create(String type){
        if ("Dog".equalsIgnoreCase(type)) {
            return new Dog();
        } else if ("Duck".equalsIgnoreCase(type)) {
            return new Duck();
        }

        return null;
    }
}

class ColorFactory implements AbstractFactory<Color>{
    public Color create(String type) {
        if ("While".equalsIgnoreCase(type)) {
            return new While();
        } else if ("Brown".equalsIgnoreCase(type)) {
            return new Brown();
        }
		return null;
	}
} 




interface Animal {
    String getAnimal();
    String makeSound();
}

interface Color {
    String getColor();
}

class While implements Color{

    @Override
    public String getColor(){
        return "While";
    }

}

class Brown implements Color{

    @Override
    public String getColor(){
        return "Brown";
    }

}

class Duck implements Animal {
 
    @Override
    public String getAnimal() {
        return "Duck";
    }
 
    @Override
    public String makeSound() {
        return "Squeks";
    }
}

class Dog implements Animal {
 
    @Override
    public String getAnimal() {
        return "Dog";
    }
 
    @Override
    public String makeSound() {
        return "go";
    }
}