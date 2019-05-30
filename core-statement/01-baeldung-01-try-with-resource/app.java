import java.util.Scanner;
import java.io.*;

class app {

    public static String FILE_NAME = "data/text.txt";
    public static String INPUT_FILE_NAME  = "data/inputText.txt";
    public static String OUTPUT_FILE_NAME = "data/outputText.txt";

    public static void main(String[] args) throws Exception {
        firstExample();
        secondExample();
        thirdExample();
        forthExample();
    }
    /**
     * write content to file
     * @throws Exception
     */
    public static void firstExample() throws Exception {
        try(PrintWriter writer = new PrintWriter(new File(FILE_NAME))){
            writer.println("first writer");
        }
    }

    /**
     * read content from file
     * @throws Exception
     */
    public static void secondExample() throws Exception{
         try(Scanner scanner = new Scanner(new File(FILE_NAME));){
            System.out.println(scanner.nextLine());
        }
    }


    public static void thirdExample() throws Exception{
        try(
            Scanner scanner = new Scanner(new File(INPUT_FILE_NAME));
            PrintWriter printWriter = new PrintWriter(new File(OUTPUT_FILE_NAME))){
                while(scanner.hasNext()){
                    printWriter.println(scanner.nextLine());
                }
        }


    }

    public static void forthExample() throws Exception {
        try(Resource resource = new Resource()){
            resource.doSomthing();
        }
    }

    @Test
    public static void call(){

    }
}


class Resource implements AutoCloseable{
    
    public void doSomthing(){
        System.out.println("[RESOURCE] Do somthing");
    }

    @Override
    public void close() throws Exception {
        System.out.println("[RESOURCE] Auto Close");    
    }
}


