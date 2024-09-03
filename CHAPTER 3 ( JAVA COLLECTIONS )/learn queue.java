import java.util.Queue;

public class Queue {

    public static void main(String[] args) {

        Queue<Integer> pq = new LinkedList<>();

        pq.offer(40);
        pq.offer(12);
        pq.offer(24);
        pq.offer(36);

        System.out.println(pq);
        pq.poll();
        System.out.println(pq);

        System.out.println(pq.peek());

    }

}