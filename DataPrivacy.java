import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class DataPrivacy {
    static Node insert_Value(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            return temp;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }

    static void print_Linked_List(Node head) {
        head = head.next;
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
        }
    }

    static Node Ex_OR_Operation(Node link1, Node link2, Node link3) {
        Node linkHead = link3;
        while (link1 != null && link2 != null) {
            if ((link1.data == 1 && link2.data == 1) || (link1.data == 0 && link2.data == 0)) {
                insert_Value(link3, 0);
                link3 = link3.next;
                link1 = link1.next;
                link2 = link2.next;
            } else if ((link1.data == 1 && link2.data == 0) || (link1.data == 0 && link2.data == 1)) {
                insert_Value(link3, 1);
                link3 = link3.next;
                link1 = link1.next;
                link2 = link2.next;
            }
        }
        return linkHead;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int selector;
            System.out.println("Encrytion-1 || Decryption-0 : ");
            selector = sc.nextInt();
            if (selector == 1) {
                Node ResultantLinkedList = new Node(0);
                String s, k;
                System.out.print("Plain Text : ");
                s = sc.next();
                System.out.print("KeyStream : ");
                k = sc.next();
                Node PlainText = new Node(s.charAt(0) - '0');
                Node KeyStream = new Node(k.charAt(0) - '0');
                for (int i = 1; i < s.length(); i++) {
                    PlainText = insert_Value(PlainText, s.charAt(i) - '0');
                }
                for (int i = 1; i < k.length(); i++) {
                    KeyStream = insert_Value(KeyStream, k.charAt(i) - '0');
                }
                ResultantLinkedList = Ex_OR_Operation(PlainText, KeyStream, ResultantLinkedList);
                System.out.println("Cipher Text : ");
                print_Linked_List(ResultantLinkedList);
            } else if (selector == 0) {
                // ------------------------------------Decryption part-----------------------//
                Node ResultantPlainLinkedList = new Node(0);
                String cipherText, key;
                System.out.print("CipherText : ");
                cipherText = sc.next();
                System.out.print("KeyStream: ");
                key = sc.next();
                Node CipherText = new Node(cipherText.charAt(0) - '0');
                Node Key = new Node(key.charAt(0) - '0');
                for (int i = 1; i < cipherText.length(); i++) {
                    CipherText = insert_Value(CipherText, cipherText.charAt(i) - '0');
                }
                for (int i = 1; i < key.length(); i++) {
                    Key = insert_Value(Key, key.charAt(i) - '0');
                }
                ResultantPlainLinkedList = Ex_OR_Operation(CipherText, Key, ResultantPlainLinkedList);
                System.out.println("Plain Text : ");
                print_Linked_List(ResultantPlainLinkedList);
            }
        }
    }
}
