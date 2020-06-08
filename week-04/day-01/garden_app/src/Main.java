public class Main {
  public static void main(String[] args) {
    Garden firstGarden = new Garden("My First Garden");

    Flower yeFl = new Flower("yellow", 1);
    Flower blFl = new Flower("blue", 1);
    Tree puTr = new Tree("purple", 1);
    Tree orTr = new Tree("orange", 1);

    firstGarden.addFlower(yeFl);
    firstGarden.addFlower(blFl);
    firstGarden.addTree(puTr);
    firstGarden.addTree(orTr);

    firstGarden.getStatus();
    System.out.println();
    firstGarden.watering(40);
    System.out.println();
    firstGarden.watering(70);
  }
}
