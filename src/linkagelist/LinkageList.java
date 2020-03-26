package linkagelist;

public class LinkageList {

	private Node head = new Node();

	LinkageList() {
	}

	public static void main(String[] args) {

		LinkageList nodes = new LinkageList();
		nodes.insert(5);
		nodes.insert(2);
		nodes.insert(3);
		nodes.insert(1);
		nodes.delete(3);
		nodes.insert(6);
		nodes.delete(5);
		nodes.printElements();

		nodes.deleteFirst();
		nodes.printElements();

		nodes.deleteLast();
		nodes.printElements();
	}

	void insert(int element) {

		Node newNode = new Node(element);

		Node oldNode = head.next;
		head.next = newNode;
		newNode.prev = head;
		newNode.next = oldNode;
		if (oldNode != null) // 要素数0の時のinsert
			oldNode.prev = newNode;
		if (oldNode == null)
			head.prev = newNode;
	}

	boolean delete(int element) {

		Node node = head.next;
		while (node != null) {

			if (node.val == element) {

				Node nextNode = node.next;
				Node prevNode = node.prev;
				prevNode.next = nextNode;
				if (nextNode != null) //　削除対象が最後の要素以外の場合
					nextNode.prev = prevNode;
				if(head.prev == node) //　削除対象が最後の要素の場合はhead.prevの参照先を更新
					head.prev = prevNode;

				return true;
			}
			node = node.next;
		}
		return false;
	}

	boolean deleteFirst() {

		Node firstNode = head.next;
		if (firstNode == null) {
			return false;
		}
		head.next = firstNode.next;

		if (firstNode.next != null)
			firstNode.next.prev = head;

		return true;
	}

	boolean deleteLast() {

		Node lastNode = head.prev;
		if (lastNode == null) {
			return false;
		}
		head.prev = lastNode.prev;

		if (lastNode.prev != null)
			lastNode.prev.next = null; // 参照が循環しないようにnullを代入

		return true;
	}

	void printElements() {

		Node node = this.head.next;
		while (true) {

			if (node == null) {
				break;
			}
			System.out.println(node.val);
			node = node.next;
		}
	}
}

class Node {

	Node next;
	Node prev;
	int val;

	Node() {
	}

	Node(int val) {
		this.val = val;
	}
}
