package bitcamp.myapp.command;

import java.util.Arrays;

public class ArrayList {

  private static final int MAX_SIZE = 3;

  private Object[] list = new Object[MAX_SIZE];
  private int size = 0;

  public void add(Object obj) {
    if (size == list.length) {
      // grow();
      int oldSize = list.length;
      int newSize = oldSize + (oldSize >> 1);
      list = Arrays.copyOf(list, newSize);
    }
    list[size++] = obj;
  }

  private void grow() {
    int oldSize = list.length;
    int newSize = oldSize + (oldSize >> 1);  // 50% 증가

    Object[] arr = new Object[newSize];  // 새 배열을 만든다.

    for (int i = 0; i < list.length; i++) {  // 기존 배열의 값을 복사해온다.
      arr[i] = list[i];
    }
    list = arr;  // 기존 배열의 주소를 버리고 새 배열의 주소를 담는다.
  }


  public Object remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    Object deletedObj = list[index];
    for (int i = index + 1; i < size; i++) {
      list[i - 1] = list[i];
    }
    list[--size] = null;
    return deletedObj;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = list[i];
    }
    return arr;
  }

  public int indexOf(Object obj) {
    for (int i = 0; i < size; i++) {
      if (list[i] == obj) {
        return i;
      }
    }
    return -1;
  }

  public int size() {
    return size;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    java.util.ArrayList l;
    return list[index];
  }

  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }

}
