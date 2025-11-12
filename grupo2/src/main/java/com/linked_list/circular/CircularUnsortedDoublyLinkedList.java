package com.linked_list.circular;

import com.linked_list.ListNode;
import com.linked_list.interfaces.IDoublyLinkedList;
import com.linked_list.interfaces.IUnsortedList;

public class CircularUnsortedDoublyLinkedList<T extends Object> implements IUnsortedList<T>, IDoublyLinkedList<T> {

  private ListNode<T> first;
  private ListNode<T> last;
  private ListNode<T> navigationPointer;

  @Override
  public boolean remove(T value) {
    if (this.first == null || this.last == null) {
      return false;
    }

    if (this.first.getValue().equals(value)) {
      if (this.first.getNext() == this.first) {
        this.first = null;
        this.last = null;
        this.navigationPointer = null;
        return true;
      }
      this.first = this.first.getNext();
      if (this.first != null) {
        this.last.setNext(first);
        this.first.setPrevious(this.last);
      }
      return true;
    }

    
    ListNode<T> element = this.first;
    ListNode<T> previousNode = null;
    
    do {
      T currentValue = element.getValue();
      
      if (currentValue.equals(value)) {
        previousNode.setNext(element.getNext());
        element = null;
        return true;
      }

      previousNode = element;
      element = element.getNext();
    } while (element != this.first && element != this.first && element != null);
    
    if (this.last.getValue().equals(value)) {
      this.last = this.last.getPrevious();
      this.first.setPrevious(last);
      this.last.setNext(this.first);
      return true;
    }
    
    return false;
  }

  @Override
  public T find(T value) {
     ListNode<T> element = this.first;

    do {
      T currentValue = element.getValue();

      if (currentValue.equals(value)) {
        return currentValue;
      }

      element = element.getNext();
    } while (element != null && element != this.first);

    return null;
  }

  @Override
  public void clear() {
    this.first = null;
    this.last = null;
    this.navigationPointer = null;
  }

  @Override
  public String listContent() {
    StringBuilder listContent = new StringBuilder();

    ListNode<T> element = this.first;
    Boolean has_element = false;
    listContent.append("->");
    while (element != null && (element != this.first || !has_element)) {
      has_element = true;
      listContent.append(" ");
      listContent.append(element.getValue());
      listContent.append(" ->");

      element = element.getNext();
    }
    if (!has_element) {
      listContent.delete(0, 2);
      listContent.append("null");
    }

    return listContent.toString();
  }

  @Override
  public String listContentReverse() {
    StringBuilder listContent = new StringBuilder();

    ListNode<T> element = this.last;
    Boolean has_element = false;
    listContent.append("->");
    while (element != null && (element != this.last || !has_element)) {
      has_element = true;
      listContent.append(" ");
      listContent.append(element.getValue());
      listContent.append(" ->");

      element = element.getPrevious();
    }
    if (!has_element) {
      listContent.delete(0, 2);
      listContent.append("null");
    }

    return listContent.toString();
  }

  @Override
  public void append(T value) {
    ListNode<T> newElement = new ListNode<T>(value);

    if (first == null) {
      this.first = newElement;
      this.first.setNext(newElement);
      this.first.setPrevious(newElement);
      this.last = newElement;
      this.last.setNext(newElement);
      this.last.setPrevious(newElement);
      this.navigationPointer = newElement;
    } else {
      newElement.setPrevious(this.last);
      this.last.setNext(newElement);
      this.last = newElement;
      this.first.setPrevious(this.last);
      this.last.setNext(this.first);
    }
  }

  @Override
  public void prepend(T value) {
    ListNode<T> newElement = new ListNode<T>(value);

    if (first == null) {
      this.first = newElement;
      this.first.setNext(newElement);
      this.first.setPrevious(newElement);
      this.last = newElement;
      this.last.setNext(newElement);
      this.last.setPrevious(newElement);
      this.navigationPointer = newElement;
    } else {
      this.first.setPrevious(newElement);
      newElement.setNext(this.first);
      this.first = newElement;
      this.last.setNext(this.first);
      this.first.setPrevious(this.last);
    }
  }

  @Override
  public void clearNavigation() {
    this.navigationPointer = this.first;
  }

  @Override
  public T getNextElement() {
    if (this.first == null || this.last == null) {
      return null;
    }

    if (this.navigationPointer == null) {
      return null;
    }

    T value = this.navigationPointer.getValue();
    this.navigationPointer = this.navigationPointer.getNext();
    return value;
  }

  @Override
  public T getPreviousElement() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPreviousElement'");
  }

}
