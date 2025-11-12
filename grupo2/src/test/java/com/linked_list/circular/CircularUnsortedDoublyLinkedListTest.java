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
      assertEquals(8, element);

      element = list.getPreviousElement();
      assertEquals(5, element);

      element = list.getNextElement();
      assertEquals(8, element);
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
    assertEquals(30, e);

    e = list.getPreviousElement();
    assertEquals(20, e);

    e = list.getPreviousElement();
    assertEquals(10, e);

    e = list.getPreviousElement();
    assertEquals(30, e);
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

  @Test
  @DisplayName("remover todos os elementos um por um")
  public void removerTodosElementosUmPorUm() {
    Integer[] elements = new Integer[] { 5, 10, 15, 20, 25 };
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(elements);

    assertTrue(list.remove(5));
    assertEquals("-> 10 -> 15 -> 20 -> 25 ->", list.listContent());

    assertTrue(list.remove(25));
    assertEquals("-> 10 -> 15 -> 20 ->", list.listContent());

    assertTrue(list.remove(15));
    assertEquals("-> 10 -> 20 ->", list.listContent());

    assertTrue(list.remove(10));
    assertEquals("-> 20 ->", list.listContent());

    assertTrue(list.remove(20));
    assertEquals("null", list.listContent());

    assertFalse(list.remove(999));
  }

  @Test
  @DisplayName("navegar apos remocoes sucessivas")
  public void navegarAposRemocoesSucessivas() {
    Integer[] elements = new Integer[] { 1, 2, 3, 4, 5 };
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(elements);

    Integer first = list.getNextElement();
    assertEquals(1, first);

    list.remove(1);

    list.clearNavigation();
    Integer newFirst = list.getNextElement();
    assertEquals(2, newFirst);

    list.remove(5);
    list.clearNavigation();

    Integer second = list.getNextElement();
    assertEquals(2, second);

    Integer third = list.getNextElement();
    assertEquals(3, third);

    Integer fourth = list.getNextElement();
    assertEquals(4, fourth);

    Integer fifth = list.getNextElement();
    assertEquals(2, fifth);
  }

  @Test
  @DisplayName("alternancia entre prepend e append com remocoes")
  public void alternanciaPreprependAppendComRemocoes() {
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(100);
    list.prepend(50);
    list.append(150);
    list.prepend(25);
    list.append(200);

    assertEquals("-> 25 -> 50 -> 100 -> 150 -> 200 ->", list.listContent());
    assertEquals("-> 200 -> 150 -> 100 -> 50 -> 25 ->", list.listContentReverse());

    list.remove(100);
    assertEquals("-> 25 -> 50 -> 150 -> 200 ->", list.listContent());

    list.prepend(10);
    list.append(300);
    assertEquals("-> 10 -> 25 -> 50 -> 150 -> 200 -> 300 ->", list.listContent());

    list.remove(50);
    list.remove(200);
    assertEquals("-> 10 -> 25 -> 150 -> 300 ->", list.listContent());
    assertEquals("-> 300 -> 150 -> 25 -> 10 ->", list.listContentReverse());
  }

  @Test
  @DisplayName("encontrar elementos apos multiplas operacoes")
  public void encontrarElementosAposMultiplasOperacoes() {
    Integer[] elements = new Integer[] { 11, 22, 33, 44, 55, 66, 77, 88 };
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(elements);

    assertEquals(11, list.find(11));
    assertEquals(88, list.find(88));
    assertEquals(44, list.find(44));
    assertNull(list.find(999));

    list.remove(44);
    assertNull(list.find(44));

    list.prepend(9);
    assertEquals(9, list.find(9));

    list.append(99);
    assertEquals(99, list.find(99));

    list.remove(11);
    assertNull(list.find(11));
  }

  @Test
  @DisplayName("navegacao forward e backward alternada")
  public void navegacaoForwardEBackwardAlternada() {
    Integer[] elements = new Integer[] { 10, 20, 30, 40, 50 };
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(elements);

    Integer e1 = list.getNextElement();
    assertEquals(10, e1);

    Integer e2 = list.getNextElement();
    assertEquals(20, e2);

    Integer e3 = list.getPreviousElement();
    assertEquals(10, e3);

    Integer e4 = list.getNextElement();
    assertEquals(20, e4);

    Integer e5 = list.getNextElement();
    assertEquals(30, e5);

    Integer e6 = list.getPreviousElement();
    assertEquals(20, e6);

    Integer e7 = list.getPreviousElement();
    assertEquals(10, e7);

    Integer e8 = list.getPreviousElement();
    assertEquals(50, e8);
  }

  @Test
  @DisplayName("inserir elementos duplicados e validar integridade")
  public void inserirElementosDuplicados() {
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(5);
    list.append(5);
    list.append(5);

    assertEquals("-> 5 -> 5 -> 5 ->", list.listContent());
    assertEquals("-> 5 -> 5 -> 5 ->", list.listContentReverse());

    assertTrue(list.remove(5));
    assertEquals("-> 5 -> 5 ->", list.listContent());

    assertTrue(list.remove(5));
    assertEquals("-> 5 ->", list.listContent());

    assertTrue(list.remove(5));
    assertEquals("null", list.listContent());
  }

  @Test
  @DisplayName("operacoes apos limpar navegacao")
  public void operacoesAposLimparNavegacao() {
    Integer[] elements = new Integer[] { 7, 14, 21, 28 };
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(elements);

    Integer e1 = list.getNextElement();
    assertEquals(7, e1);

    Integer e2 = list.getNextElement();
    assertEquals(14, e2);

    list.clearNavigation();

    Integer e3 = list.getNextElement();
    assertEquals(7, e3);

    list.clearNavigation();

    Integer e4 = list.getPreviousElement();
    assertEquals(28, e4);

    list.clearNavigation();

    Integer e5 = list.getNextElement();
    assertEquals(7, e5);

    list.remove(7);
    list.clearNavigation();

    Integer e6 = list.getNextElement();
    assertEquals(14, e6);
  }

  @Test
  @DisplayName("remover primeiro elemento apos navegar")
  public void removerPrimeiroElementoAposNavegar() {
    Integer[] elements = new Integer[] { 1, 2, 3, 4, 5 };
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(elements);

    Integer e1 = list.getNextElement();
    assertEquals(1, e1);

    Integer e2 = list.getNextElement();
    assertEquals(2, e2);

    assertTrue(list.remove(1));
    
    list.clearNavigation();
    Integer e3 = list.getNextElement();
    assertEquals(2, e3);

    Integer e4 = list.getNextElement();
    assertEquals(3, e4);
  }

  @Test
  @DisplayName("remover ultimo elemento apos navegar")
  public void removerUltimoElementoAposNavegar() {
    Integer[] elements = new Integer[] { 1, 2, 3, 4, 5 };
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(elements);

    list.getNextElement();
    list.getNextElement();
    list.getNextElement();
    list.getNextElement();

    Integer e5 = list.getNextElement();
    assertEquals(5, e5);

    assertTrue(list.remove(5));

    list.clearNavigation();
    Integer e1 = list.getNextElement();
    assertEquals(1, e1);

    Integer e4 = list.getPreviousElement();
    assertEquals(4, e4);
  }

  @Test
  @DisplayName("validar circularidade apos operacoes")
  public void validarCircularidadeAposOperacoes() {
    Integer[] elements = new Integer[] { 10, 20, 30 };
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    list.append(elements);

    for (int i = 0; i < 10; i++) {
      Integer e = list.getNextElement();
      assertTrue(e == 10 || e == 20 || e == 30, "Elemento inválido: " + e);
    }

    list.remove(20);

    for (int i = 0; i < 8; i++) {
      Integer e = list.getNextElement();
      assertTrue(e == 10 || e == 30, "Elemento inválido após remoção: " + e);
    }
  }

  @Test
  @DisplayName("operacoes massivas com muitos elementos")
  public void operacoesMassivasComMuitosElementos() {
    CircularUnsortedDoublyLinkedList<Integer> list = new CircularUnsortedDoublyLinkedList<Integer>();

    Integer[] largeArray = new Integer[100];
    for (int i = 0; i < 100; i++) {
      largeArray[i] = i;
    }

    list.append(largeArray);

    assertEquals(0, list.find(0));
    assertEquals(99, list.find(99));
    assertEquals(50, list.find(50));

    assertTrue(list.remove(0));
    assertTrue(list.remove(99));
    assertTrue(list.remove(50));

    assertNull(list.find(0));
    assertNull(list.find(99));
    assertNull(list.find(50));

    assertEquals(1, list.find(1));
    assertEquals(98, list.find(98));
  }

}
