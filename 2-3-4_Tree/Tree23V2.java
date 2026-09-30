

class Node {
    private static final int ORDER = 3;
    private int numItems;
    private Node parent;
    private Node[] childArray = new Node[ORDER];
    private int[] itemArray = new int[ORDER - 1];

    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) child.parent = this;
    }

    public Node disconnectChild(int childNum) {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return childArray[0] == null;
    }

    public int getNumItems() {
        return numItems;
    }

    public int getItem(int index) {
        return itemArray[index];
    }

    public boolean isFull() {
        return numItems == ORDER - 1;
    }

    public int findItem(int key) {
        for (int i = 0; i < numItems; i++) {
            if (itemArray[i] == key) return i;
        }
        return -1;
    }

    public int insertItem(int newItem) {
        numItems++;
        for (int i = ORDER - 2; i >= 0; i--) {
            if (itemArray[i] == 0) continue;
            if (newItem < itemArray[i]) {
                itemArray[i + 1] = itemArray[i];
            } else {
                itemArray[i + 1] = newItem;
                return i + 1;
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

    public int removeLargestItem() {
        int temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = 0;
        numItems--;
        return temp;
    }

    public void displayNode() {
        for (int i = 0; i < numItems; i++) {
            System.out.print("/" + itemArray[i]);
        }
        System.out.print(" ");
    }
}

public class Tree23V2 {
    private Node root = new Node();

    public int find(int key) {
        Node current = root;
        while (true) {
            int childNumber;
            if ((childNumber = current.findItem(key)) != -1)
                return childNumber;
            else if (current.isLeaf())
                return -1;
            else
                current = getNextChild(current, key);
        }
    }

    public void insert(int key) {
        Node current = root;
        while (true) {
            if (current.isLeaf()) break;
            else current = getNextChild(current, key);
        }

        if (current.isFull()) {
            if (current == root) {
                root = split(current);
            } else {
                Node parent = current.getParent();
                if (!parent.isFull()) {
                    split(current);
                } else {
                    System.out.println("Split skipped: parent is full (limit of simplified 2-3 tree reached).");
                    return;
                }
            }
        }

        current.insertItem(key);
    }

    public Node split(Node thisNode) {
        int itemB = thisNode.removeLargestItem();
        Node parent = thisNode.getParent();

        Node newRight = new Node();
        newRight.insertItem(itemB);

        if (thisNode == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        }

        int itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        for (int j = n - 1; j > itemIndex; j--) {
            Node temp = parent.disconnectChild(j);
            parent.connectChild(j + 1, temp);
        }

        parent.connectChild(itemIndex + 1, newRight);
        return parent;
    }

    public Node getNextChild(Node theNode, int key) {
        int numItems = theNode.getNumItems();
        for (int i = 0; i < numItems; i++) {
            if (key < theNode.getItem(i)) return theNode.getChild(i);
        }
        return theNode.getChild(numItems);
    }

    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node thisNode, int level, int childNumber) {
        System.out.print("Level=" + level + " Child=" + childNumber + " ");
        thisNode.displayNode();
        System.out.println();

        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            Node nextNode = thisNode.getChild(j);
            if (nextNode != null)
                recDisplayTree(nextNode, level + 1, j);
        }
    }

    // Example usage:
    public static void main(String[] args) {
        Tree23V2 tree = new Tree23V2();
        int[] values = {50, 40, 60, 30, 70, 20, 10, 5}; // More than 8 may cause crash (limit)

        for (int val : values) {
            System.out.println("Inserting " + val);
            tree.insert(val);
            tree.displayTree();
            System.out.println();
        }
    }
}