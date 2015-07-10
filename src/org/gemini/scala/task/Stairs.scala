package org.gemini.scala.task

/*
 * �������� ���������� ����� �������, � ������� ������ ����� �������
 * ���� �������� ������� ������, ��� ����������. ��������� ��������
 * ���������, ����������� ����� �������, ������� ����� ���������
 * �� N �������.
 */

/**
 * Created by Roman on 10.07.2015
 */
object Stairs extends App {

  def compareAll[A](list: List[A], p: (A, A) => Boolean): Boolean = {
    if (list.isEmpty || list.tail.isEmpty) true
    else if (p(list.head, list.tail.head)) compareAll(list.tail, p)
    else false
  }

  def partNumber(num: Int): List[List[Int]] =
    List(num) :: (1 until num).flatMap(n => partNumber(num - n).map(n :: _)).toList

  def calc(arr: Int) = partNumber(arr).count(a => compareAll[Int](a, _ < _))

  println(calc(10))

}