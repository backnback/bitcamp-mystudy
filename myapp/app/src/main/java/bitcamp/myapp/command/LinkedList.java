package bitcamp.myapp.command;

public class LinkedList {

  Node first;
  Node last;
  int size;

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.append("홍길동");
    list.append("임꺽정");
    list.append("유관순");
    list.append("빌리");
    list.append("김민수");

    // list.printAll();

    //    for (int i = 0; i < list.size(); i++) {
    //      System.out.println(list.getValue(i));
    //    }

    list.delete(2);
    list.printAll();

    list.delete(2);
    list.printAll();

    list.delete(2);
    list.printAll();

    list.delete(2);
    list.printAll();


  }

  public void append(Object value) {
    Node newNode = new Node(value);

    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    size++;
  }

  public Object getValue(int index) {
    if (index < 0 || index >= size) {
      throw null;
    }
    Node cursor = first;
    int currentIndex = 0;

    while (cursor != null) {
      if (currentIndex == index) {
        return cursor.value;
      }
      cursor = cursor.next;
      currentIndex++;
    }
    return null;
  }

  public Object delete(int index) {
    if (index < 0 || index >= size) {
      return null;
    }

    Node deletedNode = null;
    size--;

    if (index == 0) {
      deletedNode = first;
      first = first.next;
      if (first == null) {
        last = null;
      }
      return deletedNode.value;
    }

    Node cursor = first;
    int currentIndex = 0;

    while (cursor != null) {
      if (currentIndex == (index - 1)) {  // 삭제할 인덱스 이전 인덱스일 때  index = 3일 때 currentindex = 2일때
        break;
      }
      cursor = cursor.next;
      currentIndex++;
    }

    deletedNode = cursor.next;
    cursor.next = cursor.next.next;

    if (cursor.next == null) {
      last = cursor;
    }
    return deletedNode.value;
  }

  public int index(Object value) {
    Node cursor = first;
    int currentIndex = 0;

    while (cursor != null) {
      if (cursor.value == value) {
        return currentIndex;
      }
      cursor = cursor.next;
      currentIndex++;
    }
    return -1;
  }


  public Object[] getArray() {
    Object[] arr = new Object[size];

    Node cursor = first;
    int currentIndex = 0;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }



  public int size() {
    return size;
  }


  public void printAll() {
    Node cursor = first;
    while (cursor != null) {
      System.out.print(cursor.value + ", ");
      cursor = cursor.next;
    }
    System.out.println();
  }



}
