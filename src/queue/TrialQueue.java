package queue;

import java.util.Arrays;

public class TrialQueue {

	static int head = 0;
	static int tail = 0;
	static TrialModel[] queue = new TrialModel[10000];
	static int resultIndex = 0;
	static TrialModel[] result;
	static int consumptionTime = 0;
	static int quantum = 0;

	public static void main(String[] args) {

		String input = "5 100 p1 150 p2 80 p3 200 p4 350 p5 20";
		String[] elements = input.split(" ");
		result = new TrialModel[Integer.parseInt(elements[0])];
		quantum = Integer.parseInt(elements[1]);

		for (int i = 0; i < elements.length; i += 2) {
			if (i == 0 || i == 1) {
				continue;
			}
			enqueue(new TrialModel(elements[i], Integer.parseInt(elements[i + 1])));
		}

		while (true) {
			TrialModel model = dequeue();
			System.out.println(model);
			if (model == null)
				break;
		}
		Arrays.asList(result).stream().forEach(e -> System.out.println(e.printEndtime()));
	}

	static void enqueue(TrialModel model) {
		queue[tail++] = model;
	}

	static TrialModel dequeue() {

		if (tail == 0) {
			return null;
		}

		TrialModel model = queue[head];
		if (model.time > quantum) {
			consumptionTime += quantum;
			enqueue(new TrialModel(model.name, model.time - quantum));
		} else if (model.time == quantum) {
			consumptionTime += quantum;
			result[resultIndex++] = new TrialModel(model.name, 0, consumptionTime);
		} else {
			consumptionTime += model.time;
			result[resultIndex++] = new TrialModel(model.name, 0, consumptionTime);
		}

		queue[head++] = null; // 引き出した位置の要素は初期化
		if (head == tail) { // head==tailの場合は要素数が0なので初期化
			head = 0;
			tail = 0;
		}
		return model;
	}

}

class TrialModel {
	String name;
	int time;
	int endTime;

	TrialModel(String name, int time) {
		this.name = name;
		this.time = time;
	}

	TrialModel(String name, int time, int endTime) {
		this.name = name;
		this.time = time;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return name + " " + time;
	}

	public String printEndtime() {

		return name + " " + endTime;
	}
}