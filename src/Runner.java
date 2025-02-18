public class Runner {

    public String id;
    public int birthYear;
    private Node<Item> lstItems;

    public Runner(String id, int birthYear) {
        this.id = id;
        this.birthYear = birthYear;
        lstItems = new Node<>(new Item(-1, -1));
    }

    public void addItem(Item item){
        HelpCommands.setLast(lstItems, item);
    }

    public void addItems(Item... items){
        for (Item item : items){
            HelpCommands.setLast(lstItems, item);
        }
    }

    public Node<Item> lstItems() {
        return lstItems.getNext();
    }
}
