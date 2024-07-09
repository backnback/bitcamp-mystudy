package bitcamp.myapp.util;

public class Queue extends LinkedList {

  public static void main(String[] args) {
    Queue s = new Queue();
    s.offer("111");
    s.offer("222");
    s.offer("333");

    System.out.println(s.poll());
    System.out.println(s.poll());
    System.out.println(s.poll());
    System.out.println(s.poll());
  }

  public void offer(Object value) {
    add(value);
  }

  public Object poll() {
    return remove(0);
  }

  public boolean isEmpty() {
    return size() == 0;
  }

}
