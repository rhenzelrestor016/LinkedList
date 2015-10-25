public class ListNode {
  private int data;
  public DoublyNode next, previous;
  public ListNode(int data) {
  	this.data = data;
  }
  public int getData() {
  	return this.data;
  }
  public void showData() {
  	System.out.print(this.getData() + " ");
  }
}
