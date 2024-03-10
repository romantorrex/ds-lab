package romano.ds

import spock.lang.Specification

class MaxHeapTest extends Specification {

  def "Should insert a value at the top when heap is empty"() {
    given: "an empty heap"
    def maxHeap = new MaxHeap()

    when: "inserting first value"
    maxHeap.insert(15)

    then: "value is inserted at the top"
    maxHeap.toString() == "[15]"
  }

  def "Should insert new value at the top if it is greater than the root of the heap"() {
    given: "a heap with one value"
    def maxHeap = new MaxHeap()
    maxHeap.insert(20)

    when: "inserting a value greater than the max value"
    maxHeap.insert(50)

    then: "the new value should be at the top"
    maxHeap.toString() == "[50, 20]"
  }

  def "Should insert new value at the last position if it is smaller than the root of the heap"() {
    given: "a heap with one value"
    def maxHeap = new MaxHeap()
    maxHeap.insert(9)

    when: "inserting a value less than the max value"
    maxHeap.insert(5)

    then: "the new value should be at the end of the heap"
    maxHeap.toString() == "[9, 5]"
  }
}
