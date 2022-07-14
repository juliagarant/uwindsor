package Lab8;

public class TestEat {
    public static void main(String[] args) {
        //Fruits
        DragonFruit dragon = new DragonFruit();
        Honeyvine honey = new Honeyvine();

        //Animals
        Chicken chick = new Chicken();
        Fish fish = new Fish();

        System.out.println(dragon.howToEat());
        System.out.println(honey.notEdible());
        System.out.println(chick.howToEat());
        System.out.println(fish.howToEat());
    }
}