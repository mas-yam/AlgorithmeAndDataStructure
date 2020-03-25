package queue;

public class SampleQueue {

	static int head = 0;
	static int tail = 0;
	static SampleModel[] queue = new SampleModel[10000];

	public static void main(String[] args) {

		String input = "5 100 p1 150 p2 80 p3 200 p4 350 p5 20";
		String[] elements = input.split(" ");

		for (int i = 0; i < elements.length; i+=2) {
			if(i == 0 || i == 1) {
				continue;
			}
			enqueue(elements[i],Integer.parseInt(elements[i+1]));
		}
		System.out.println(queue);
		for (int i = 0; i < elements.length; i+=2) {
			if(i == 0 || i == 1) {
				continue;
			}
			System.out.println(dequeue());
		}
		System.out.println();
	}

	static void enqueue(String name, int time) {
		queue[tail++] = new SampleModel(name, time);
	}

	static SampleModel dequeue() {

		if(tail == 0) {
			return null;
		}
		SampleModel model = queue[head];
		queue[head++] = null;
		if(head == tail) { // head==tailの場合は要素数が0なので初期化
			head = 0;
			tail = 0;
		}
		return model;
	}
}

class SampleModel {
	String name;
	int time;

	SampleModel(String name, int time) {
		this.name = name;
		this.time = time;
	}

	@Override
	public String toString() {
		return name + " " + time;
	}
}
