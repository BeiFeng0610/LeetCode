import java.util.LinkedList;
import java.util.Queue;

class AnimalShelf {
    Queue<Integer> cat;
    Queue<Integer> dog;
    public AnimalShelf() {
        cat = new LinkedList<>();
        dog = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            cat.offer(animal[0]);
        } else {
            dog.offer(animal[0]);
        }
    }

    public int[] dequeueAny() {
        if (dog.isEmpty() && cat.isEmpty()) {
            return new int[]{-1, -1};
        }
        if (dog.isEmpty()) {
            return new int[]{cat.poll(), 0};
        }
        if (cat.isEmpty()) {
            return new int[]{dog.poll(), 1};
        }
        return cat.peek() < dog.peek() ? new int[]{cat.poll(), 0} : new int[]{dog.poll(), 1};
    }

    public int[] dequeueDog() {
        if (dog.isEmpty()) {
            return new int[]{-1, -1};
        }
        return new int[]{dog.poll(), 1};
    }

    public int[] dequeueCat() {
        if (cat.isEmpty()) {
            return new int[]{-1, -1};
        }
        return new int[]{cat.poll(), 0};
    }
}

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */