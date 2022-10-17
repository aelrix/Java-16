class Start{
    public static void main(String [] data){
        int[] score = { 8, 5, 4, 2, 7, 1, 9, 3 };

    Element list = createList(score);
    showList(list);
    System.out.println();
    System.out.println("Maximum : " + findMax(list).value);
    System.out.println("Minimum : " + findMin(list).value);
    System.out.println("Count node : " + countNode(list));
    System.out.println("Sum : " + findSum(list));
    System.out.println("Duplicate : " + findDuplicate(list));

    System.out.println();
    showReverse(list);
  }

  static void showList(Element e) {
    if (e == null) return;
    System.out.print(" " + e.value);
    showList(e.next);
  }

  static void showReverse(Element e) {
    if (e == null) return;
    showReverse(e.next);
    System.out.print(" " + e.value);
  }

  static Element createList(int ... data) {
    Element head = null;
    Element tail = null;
    
    for (int i = 0; i < data.length; i++) {
       Element current = new Element();
       current.value = data[i];
       if (head == null) {
          head = current;
          tail = current;
       } else {
          tail.next = current;
          tail = tail.next;
       }
    }
    return head;
  }

  static Element findMax(Element e) {
      Element result = e;
      for (Element c = e; c != null; c = c.next) {
          if (result.value < c.value) {
              result = c;
          }
      }
      return result;
  }

  static Element findMin(Element e) {
      Element result = e;
      for (Element c = e; c != null; c = c.next) {
          if (result.value > c.value) {
              result = c;
          }
      }
      return result;
  }

  static int countNode(Element e) {
      if (e == null) return 0;
      return countNode(e.next) + 1;
  }

  static int findSum(Element e) {
      int result = 0;
      Element current = e;
      for (Element c = e; c != null; c = c.next) {
          result += c.value;
      }
      return result;
  }

  static boolean findDuplicate(Element e) {
      boolean flag = false;
      Element item = e;
      for (Element c = e; c != null; c = c.next) {
           if (item.value == c.value) {
              flag = true;
           } else {
              flag = false;
           }
      }
      return flag;
  }
}

class Element {
  String name;
  int value;
  Element next;
}
