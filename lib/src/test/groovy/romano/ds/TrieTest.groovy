package romano.ds

import spock.lang.Specification

class TrieTest extends Specification {
  def "search() should return true if a given word exists"() {
    given: "A trie with the word apple"
    var trie = new Trie()
    trie.insert("apple")

    when: "we search for the word apple"
    def found = trie.search("apple")

    then: "the word is found"
    found
  }

  def "search() should return false if a given word exists"() {
    given: "A trie with the word software"
    var trie = new Trie()
    trie.insert("software")

    when: "we search for the word apple"
    def found = trie.search("soft")

    then: "the word is not found"
    !found
  }

  def "delete() should delete the word if it exists"() {
    given: "A trie with the words three and bat"
    def trie = new Trie()
    trie.insert("three")
    trie.insert("bat")

    when: "the word bat is deleted"
    trie.delete("bat")

    then: "the word is deleted"
    !trie.search("bat")
  }

  def "delete() should delete a word that is prefix of another word"() {
    given: "a trie and two words"
    def trie = new Trie()
    trie.insert("cat")
    trie.insert("category")

    when: "deleting a word that is the prefix of another existent word"
    trie.delete("cat")

    then: "the prefix word no longer exists"
    !trie.search("cat")
  }

  def "delete() should delete a word that has common prefix with another word"() {
    given: "a trie and two words"
    def trie = new Trie()
    trie.insert("sea")
    trie.insert("season")

    when: "deleting a word that has a common prefix"
    trie.delete("season")

    then: "the word does not exist"
    !trie.search("season")

    and: "the other word still exists"
    trie.search("sea")
  }
}
