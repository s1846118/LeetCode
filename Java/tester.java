public class linkedList {
    int value;
    linkedList next;

    public linkedList(int value) {
        this.value = value;
        this.linkedList = null;
    }

    public static void main(String[] args){

        linkedList l1 = new linkedList(5);
        linkedList l2 = new linkedList(6);
        linkedList l3 = new linkedList(7);
        linkedList l4 = new linkedList(8);
        linkedList l5 = new linkedList(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l1;

        linkedList[] elems = {l1,l2,l3,l4,l5};

        for (linkedList elm : elms){
            System.out.println("Hello");
        }

    }
}