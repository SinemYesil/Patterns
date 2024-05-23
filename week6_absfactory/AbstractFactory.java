package week6_absfactory;
import java.util.ArrayList;

abstract class Furniture{
    abstract public String displayName();
    abstract double getPrice();
}
abstract class Chair extends Furniture {
    protected double price;
    protected String name;
    public double getPrice(){ return price; }
    public String displayName() { return name;	}
}
abstract class CoffeeTable extends Furniture {
    protected double price;
    protected String name;
    public double getPrice(){ return price; }
    public String displayName() { return name;	}
}

class ModernAfrica extends Chair  {
    public ModernAfrica(double p) {
        price = p;
        name = new String("Modern Africa create");
        System.out.println("Modern Africa is created...");
    }
}
class Antique1 extends Chair  {

    public Antique1(double p) {
        price = p;
        name = new String("Antique1 create");
        System.out.println("Antique1 is created...");
    }
}
class MarbleCloud extends CoffeeTable  {

    public MarbleCloud(double p) {
        price = p;
        name = new String("MarbleCloud create");
        System.out.println("MarbleCloud is created...");
    }
}
class ValedictorianTable extends CoffeeTable  {

    public ValedictorianTable (double p) {
        price = p;
        name = new String("ValedictorianTable  create");
        System.out.println("ValedictorianTable  is created...");
    }
}
class WaveletChair extends Chair{
    public WaveletChair(double p) {
        price = p;
        name = new String("WaveletChair create");
        System.out.println("WaveletChair is created...");
    }
}
class CorianTable extends CoffeeTable{
    public CorianTable(double p) {
        price = p;
        name = new String("CorianTable create");
        System.out.println("CorianTable is created...");
    }
}

abstract class FurnitureFactory {
//    abstract public Chair createChair();
//    abstract public CoffeeTable createCTable();
    abstract  public Furniture createAll(int furnitureType);
}
class ArtMFactory extends FurnitureFactory {
    public Furniture createAll(int furnitureType){
        if (furnitureType==1){
            return new ModernAfrica(20000.00);
        }
        else if (furnitureType==2){
            return new MarbleCloud(20000.00);
        } return null;
    }

}
class HistoryFurnitureFactory extends FurnitureFactory {
    public Furniture createAll(int furnitureType){
        if (furnitureType==1) {

            return new Antique1(20000.00);
        }
        else if (furnitureType==2){
        return new ValedictorianTable(12000.00);
    }
        return null;
    }
}
class FutureNowFactory extends FurnitureFactory{
    public Furniture createAll(int furnitureType){
        if (furnitureType==1) {

            return new WaveletChair (20000.00);
    }
        else if (furnitureType==2){
        return new CorianTable (12000.00);
    }
        return null;
    }

}
class BuildFurniture {
    // Object creation is delegated to factory.
    public void createFurniture(FurnitureFactory factory) {
        furnitures = new ArrayList<Furniture>();
        furnitures.add(factory.createAll(1));
        furnitures.add(factory.createAll(2));


    }
    void displayParts() {
        System.out.println("\tListing Parts\n\t-------------");
        furnitures.forEach(f  -> System.out.println("\t"+ f.displayName() +
                " " + f.getPrice()));
    }
    private ArrayList<Furniture> furnitures;
}
public class AbstractFactory {
    public static void main(String[] args) {
        // Create factories.
        FurnitureFactory ArtMCompany = new ArtMFactory();
        FurnitureFactory HFuniture = new HistoryFurnitureFactory();
        FurnitureFactory Future=new FutureNowFactory();

        BuildFurniture furniture = new BuildFurniture();
        System.out.println("Creating ArtMCompany ");
        furniture.createFurniture(ArtMCompany);
        furniture.displayParts();


        BuildFurniture furniture2 = new BuildFurniture();
        System.out.println("Creating History Furniture");
        furniture2.createFurniture(HFuniture);
        furniture2.displayParts();



        BuildFurniture furniture3 = new BuildFurniture();
        System.out.println("Creating History Furniture");
        furniture2.createFurniture(Future);
        furniture2.displayParts();
    }
}
