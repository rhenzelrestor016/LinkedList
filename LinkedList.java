public class LinkedList {
  private int G = 0;
  private ListNode first, last;
  public LinkedList() {
    this.first = null;
    this.last = null;
  }
  public boolean isEmpty() {
    return (this.G == 0);
  }
  public int size() {
    return this.G;
  }
  public void showSize() {
    System.out.print("List of values: " + this.size() );
  }
  public void insertFirst(int value) {
    ListNode newNode = new ListNode(value);
    if (this.isEmpty()) {
      this.last = newNode;
    } else {
      this.first.previous = newNode;
    }
    newNode.next = first;
    this.first = newNode;
    this.G++;
  }
  public void insertLast(int value) {
    ListNode newNode = new ListNode(value);
    if (this.isEmpty()) {
      this.first = newNode;
    } else {
      this.last.next = newNode;
      newNode.previous = this.last;
    }
    this.last = newNode;
    this.G++;
  }
  public ListNode deleteFirst() {
    ListNode temp = this.first;
    if (this.first.next == null) {
      this.last = null;
    } else {
      this.first.next.previous = null;
    }
    this.first = first.next;
    this.G--;
    return temp;
  }
  public ListNode deleteLast() {
    ListNode temp = this.last;
    if (this.first.next == null) {
      this.first = null;
    } else {
      this.last.previous.next = null;
    }
    this.last =this.last.previous;
    this.G--;
    return temp;
  }
  public boolean insertAfter(int key, int value) {
    ListNode current = this.first;
    while (current.getData() != key) {
      current = current.next;
      if (current == null) {
        return false;
      }
    }
    ListNode newNode = new DoublyNode(value);
    if (current == this.last) {
      newNode.next = null;
      this.last = newNode;
    } else {
      newNode.next = current.next;
      current.next.previous = newNode;
    }
    newNode.previous = current;
    current.next = newNode;
    this.G++;
    return true;
  }
  public ListNode deleteKey(int key) {
    ListNode current = first;
    while (current.getData() != key) {
      current = current.next;
      if (current == null) {
        return null;
      }
    }
    if (current == this.first) {
      this.first = current.next;
    } else {
      current.previous.next = current.next;
    }
    if (current == this.last) {
      this.last = current.previous;
    } else {
      current.next.previous = current.previous;
    }
    this.G--;
    return current;
  }
  public void displayBackward() {
    System.out.print("List Data (last --> first): ");
    ListNode   current = this.last;
    while (current != null) {
      current.showData();
      current = current.previous;
    }
    System.out.println(" ");
  }
  public void displayForward() {
    System.out.print("List Data (first --> last): ");
    ListNode current = this.first;
    while (current != null) {
      current.showData();
      current = current.next;
    }
    System.out.println(" ");
  }
}
