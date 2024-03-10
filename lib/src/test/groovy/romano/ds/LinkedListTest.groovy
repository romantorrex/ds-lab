package romano.ds

import spock.lang.Specification

class LinkedListTest extends Specification {
  def "Should add a value when the list is empty"() {
    given: "Aa empty list"
    def list = new LinkedList<Integer>()

    when:
    list.add(100)

    then:
    list.size() == 1
  }

  def "Should add a value when the list is not empty"() {
    given: "A non-empty list"
    def list = new LinkedList<Integer>(100)

    when:
    list.add(200)

    then:
    list.size() == 2
    list.toString() == "100 -> 200"
  }
}
