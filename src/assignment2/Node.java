package assignment2;

/**
 *
 * @author UMIT KILINC 101232721
 * @author RAVKEERAT SINGH 101344680
 */
class Node {
    
            String word;
            int key;
            Node next;
            Node left , right ;
            
            public Node(String key, Node next) {
                this.word = key;
                this.next = next;
            }
}