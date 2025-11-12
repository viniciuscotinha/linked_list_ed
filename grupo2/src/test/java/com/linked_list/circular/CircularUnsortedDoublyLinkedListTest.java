package com.linked_list.circular;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

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

      element = list.getNextElement();
      assertEquals(5, element);

      list.clearNavigation();

      element = list.getPreviousElement();
      assertEquals(2, element);

      element = list.getPreviousElement();
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

  @Test
  @DisplayName("remover elemento em lista de dois elementos")
  public void removerElementoEmListaDeDoisElementos() {
    Integer[] elements = new Integer[] { 1, 2 };
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(elements);

    boolean removed = list.remove(1);
    String content = list.listContent();

    assertTrue(removed);
    assertEquals("-> 2 ->", content);
  }

  @Test
  @DisplayName("navegar previous ciclo completo")
  public void navegarPreviousCicloCompleto() {
    Integer[] elements = new Integer[] { 10, 20, 30 };
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(elements);

    Integer e = list.getPreviousElement();
    assertEquals(10, e);

    e = list.getPreviousElement();
    assertEquals(30, e);

    e = list.getPreviousElement();
    assertEquals(20, e);

    e = list.getPreviousElement();
    assertEquals(10, e);
  }

  @Test
  @DisplayName("navegar em lista vazia retorna null")
  public void navegarEmListaVaziaRetornaNull() {
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    assertNull(list.getNextElement());
    assertNull(list.getPreviousElement());
  }

  @Test
  @DisplayName("encontrar em lista vazia retorna null")
  public void encontrarEmListaVaziaRetornaNull() {
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    Integer value = list.find(123);
    assertNull(value);
  }

  @Test
  @DisplayName("manter integridade apos remover elemento intermediario (forward)")
  public void manterIntegridadeAposRemoverIntermediarioForward() {
    Integer[] elements = new Integer[] { 1, 2, 3, 4 };
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(elements);

    boolean removed = list.remove(3);
    String content = list.listContent();
    Integer found = list.find(3);

    assertTrue(removed);
    assertEquals("-> 1 -> 2 -> 4 ->", content);
    assertNull(found);
  }

  @Test
  @DisplayName("inserir usando arrays com prepend e append")
  public void inserirUsandoArraysComPrependEAppend() {
    Integer[] toAppend = new Integer[] { 2, 3 };
    Integer[] toPrepend = new Integer[] { 1, 0 };
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(toAppend);
    list.prepend(toPrepend);

    String content = list.listContent();
    assertEquals("-> 0 -> 1 -> 2 -> 3 ->", content);
  }

  @Test
  @DisplayName("manipular única lista em várias sequências e validar forward e reverse")
  public void manipularListaComplexaEValidarSequencias() {
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(new Integer[] {1,2,3,4,5,6,7,8,9,10});

    String contentNormal = list.listContent(); 
    String contentReverse = list.listContentReverse(); 
    assertEquals("-> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 ->", contentNormal);
    assertEquals("-> 10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 ->", contentReverse);
    
    list.prepend(new Integer[] {11,12,13,14,15,16,17,18,19,20});
    
    contentNormal = list.listContent(); 
    contentReverse = list.listContentReverse(); 
    assertEquals("-> 20 -> 19 -> 18 -> 17 -> 16 -> 15 -> 14 -> 13 -> 12 -> 11 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 ->", contentNormal);
    assertEquals("-> 10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> 18 -> 19 -> 20 ->", contentReverse);
    

    list.prepend(new Integer[] {100,101});

    contentNormal = list.listContent(); 
    contentReverse = list.listContentReverse(); 
    assertEquals("-> 101 -> 100 -> 20 -> 19 -> 18 -> 17 -> 16 -> 15 -> 14 -> 13 -> 12 -> 11 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 ->", contentNormal);
    assertEquals("-> 10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> 18 -> 19 -> 20 -> 100 -> 101 ->", contentReverse);
    
    list.prepend(999);

    contentNormal = list.listContent(); 
    contentReverse = list.listContentReverse(); 
    assertEquals("-> 999 -> 101 -> 100 -> 20 -> 19 -> 18 -> 17 -> 16 -> 15 -> 14 -> 13 -> 12 -> 11 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 ->", contentNormal);
    assertEquals("-> 10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> 18 -> 19 -> 20 -> 100 -> 101 -> 999 ->", contentReverse);
    

    list.remove(5);

    contentNormal = list.listContent(); 
    contentReverse = list.listContentReverse(); 
    assertEquals("-> 999 -> 101 -> 100 -> 20 -> 19 -> 18 -> 17 -> 16 -> 15 -> 14 -> 13 -> 12 -> 11 -> 1 -> 2 -> 3 -> 4 -> 6 -> 7 -> 8 -> 9 -> 10 ->", contentNormal);
    assertEquals("-> 10 -> 9 -> 8 -> 7 -> 6 -> 4 -> 3 -> 2 -> 1 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> 18 -> 19 -> 20 -> 100 -> 101 -> 999 ->", contentReverse);
    
    list.prepend(555);

    contentNormal = list.listContent(); 
    contentReverse = list.listContentReverse(); 
    assertEquals("-> 555 -> 999 -> 101 -> 100 -> 20 -> 19 -> 18 -> 17 -> 16 -> 15 -> 14 -> 13 -> 12 -> 11 -> 1 -> 2 -> 3 -> 4 -> 6 -> 7 -> 8 -> 9 -> 10 ->", contentNormal);
    assertEquals("-> 10 -> 9 -> 8 -> 7 -> 6 -> 4 -> 3 -> 2 -> 1 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> 18 -> 19 -> 20 -> 100 -> 101 -> 999 -> 555 ->", contentReverse);

    list.remove(20);

    contentNormal = list.listContent(); 
    contentReverse = list.listContentReverse(); 
    assertEquals("-> 555 -> 999 -> 101 -> 100 -> 19 -> 18 -> 17 -> 16 -> 15 -> 14 -> 13 -> 12 -> 11 -> 1 -> 2 -> 3 -> 4 -> 6 -> 7 -> 8 -> 9 -> 10 ->", contentNormal);
    assertEquals("-> 10 -> 9 -> 8 -> 7 -> 6 -> 4 -> 3 -> 2 -> 1 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> 18 -> 19 -> 100 -> 101 -> 999 -> 555 ->", contentReverse);

    Integer foundFirst = list.find(555);
    Integer foundLast = list.find(10);
    assertEquals(555, foundFirst);
    assertEquals(10, foundLast);

    assertTrue(list.remove(10));
    assertTrue(list.remove(555));
    assertTrue(list.remove(100));

    contentNormal = list.listContent(); 
    contentReverse = list.listContentReverse(); 
    assertEquals("-> 999 -> 101 -> 19 -> 18 -> 17 -> 16 -> 15 -> 14 -> 13 -> 12 -> 11 -> 1 -> 2 -> 3 -> 4 -> 6 -> 7 -> 8 -> 9 ->", contentNormal);
    assertEquals("-> 9 -> 8 -> 7 -> 6 -> 4 -> 3 -> 2 -> 1 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> 18 -> 19 -> 101 -> 999 ->", contentReverse);

    list.prepend(77);
    list.append(88);

    contentNormal = list.listContent(); 
    contentReverse = list.listContentReverse(); 
    assertEquals("-> 77 -> 999 -> 101 -> 19 -> 18 -> 17 -> 16 -> 15 -> 14 -> 13 -> 12 -> 11 -> 1 -> 2 -> 3 -> 4 -> 6 -> 7 -> 8 -> 9 -> 88 ->", contentNormal);
    assertEquals("-> 88 -> 9 -> 8 -> 7 -> 6 -> 4 -> 3 -> 2 -> 1 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> 18 -> 19 -> 101 -> 999 -> 77 ->", contentReverse);
  }

}
