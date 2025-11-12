package com.linked_list.circular;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

public class CircularUnsortedDoublyLinkedListTest {

  @Test
  @DisplayName("requisitar uma lista vazia")
  public void retrieveAnEmptyList() {
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    String content = list.listContent();

    assertEquals("null", content);
  }

  @Nested
  @DisplayName("ação de inserir")
  class Insertion {

    @Test
    @DisplayName("inserir elementos no inicio com sucesso")
    public void insertElementsAtInitSuccessfully() {
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.prepend(2);
      list.prepend(5);
      list.prepend(8);
      list.prepend(4);

      String content = list.listContent();

      assertEquals("-> 4 -> 8 -> 5 -> 2 ->", content);
    }

    @Test
    @DisplayName("inserir elementos no fim com sucesso")
    public void insertElementsAtEndSuccessfully() {
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.append(2);
      list.append(5);
      list.append(8);
      list.append(4);

      String content = list.listContent();

      assertEquals("-> 2 -> 5 -> 8 -> 4 ->", content);
    }

    @Test
    @DisplayName("inserir elementos com sucesso")
    public void insertElementsSuccessfuly() {
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.append(2);
      list.prepend(5);
      list.prepend(8);
      list.append(4);

      String content = list.listContent();

      assertEquals("-> 8 -> 5 -> 2 -> 4 ->", content);
    }

  }

  @Nested
  @DisplayName("ação de encontrar")
  class Find {

    @Test
    @DisplayName("achar um elemento existente")
    public void findAnExistingElement() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.prepend(elements);

      Integer value = list.find(5);

      assertEquals(5, value);
    }

    @Test
    @DisplayName("não achar um elemento")
    public void doesNotFindAnElement() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.prepend(elements);

      Integer value = list.find(666);

      assertNull(value);
    }

  }

  @Nested
  @DisplayName("ação de remover")
  class Remove {

    @Test
    @DisplayName("remover um elemento existente")
    public void removeAnExistingElement() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.append(elements);

      boolean removed = list.remove(5);
      String content = list.listContent();

      assertTrue(removed);
      assertEquals("-> 2 -> 8 -> 4 ->", content);
    }

    @Test
    @DisplayName("remover o ultimo elemento")
    public void removeTheLastElement() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.append(elements);

      boolean removed = list.remove(4);
      String content = list.listContent();

      assertTrue(removed);
      assertEquals("-> 2 -> 5 -> 8 ->", content);
    }

    @Test
    @DisplayName("remover o primeiro elemento")
    public void removeTheFirstElement() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.append(elements);

      boolean removed = list.remove(2);
      String content = list.listContent();

      assertTrue(removed);
      assertEquals("-> 5 -> 8 -> 4 ->", content);
    }

    @Test
    @DisplayName("remover o primeiro elemento de uma lista de um elemento")
    public void removeTheFirstElementOfASingleList() {
      Integer[] elements = new Integer[] { 2 };
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.append(elements);

      boolean removed = list.remove(2);
      String content = list.listContent();

      assertTrue(removed);
      assertEquals("null", content);
    }

    @Test
    @DisplayName("não remover um elemento")
    public void doesNotRemoveAnElement() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.append(elements);

      boolean removed = list.remove(666);
      String content = list.listContent();

      assertFalse(removed);
      assertEquals("-> 2 -> 5 -> 8 -> 4 ->", content);
    }

  }

  @Nested
  @DisplayName("ação de navegação")
  class Navigate {

    @Test
    @DisplayName("navegar por todos os elementos")
    public void navigateThroughAllElements() {
      Integer[] elements = new Integer[] { 2, 5, 8 };
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.append(elements);

      Integer element = list.getNextElement();
      assertEquals(2, element);

      element = list.getNextElement();
      assertEquals(5, element);

      element = list.getNextElement();
      assertEquals(8, element);

      element = list.getNextElement();
      assertEquals(2, element);
    }

    @Test
    @DisplayName("navegar pelos elementos limpar a navegação e navegar")
    public void navigateThroughElementsAndRestartNavigationPointer() {
      Integer[] elements = new Integer[] { 2, 5, 8 };
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.append(elements);

      Integer element = list.getNextElement();
      assertEquals(2, element);

      element = list.getNextElement();
      assertEquals(5, element);

      list.clearNavigation();

      element = list.getNextElement();
      assertEquals(2, element);

      element = list.getNextElement();
      assertEquals(5, element);

      element = list.getNextElement();
      assertEquals(8, element);

      element = list.getNextElement();
      assertEquals(2, element);
    }

  }

  @Test
  @DisplayName("limpar a lista")
  public void clearAListWithElements() {
    Integer[] elements = new Integer[] { 2, 5, 8, 4 };
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(elements);

    list.clear();
    String content = list.listContent();

    assertEquals("null", content);
  }

  @Nested
  @DisplayName("Ação de mostrar lista")
  class Exibir{
    @Test
    @DisplayName("Exibir normal")
    public void exibirNormal() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.append(elements);
      String content = list.listContent();
      assertEquals("-> 2 -> 5 -> 8 -> 4 ->", content);

      elements = new Integer[] { 3, 1, 9, 7 };
      list.prepend(elements);
      
      content = list.listContent();
      assertEquals("-> 7 -> 9 -> 1 -> 3 -> 2 -> 5 -> 8 -> 4 ->", content);
    }
    @Test
    @DisplayName("Exibir reverso")
    public void exibirReverso() {
      Integer[] elements = new Integer[] { 2, 5, 8, 4 };
      CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

      list.append(elements);
      String content = list.listContentReverse();
      assertEquals("-> 4 -> 8 -> 5 -> 2 ->", content);

      elements = new Integer[] { 3, 1, 9, 7 };
      list.prepend(elements);
      
      content = list.listContentReverse();
      assertEquals("-> 4 -> 8 -> 5 -> 2 -> 3 -> 1 -> 9 -> 7 ->", content);

    }

  }

}
