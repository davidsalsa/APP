package huiswerk.trees

class BinarySearchTreeScala(){

  class Node(var key:Int, var left:Node, var right:Node){ //Constructor
    def this(key:Int){this(key,null,null)} //Aux constructor with 1 param
  }


  var root:Node = null //root node

  def insert(key:Int): Unit ={ //Insert calls recursive
    root = insertRec(root, key)
  }

  def insertRec(root:Node, key:Int): Node ={ //recursive insert
    var node = root

    if (root == null) {
      node = new Node(key)
      return node
    }
    if (key < node.key)
      node.left = insertRec(node.left, key)
    else if (key > node.key)
      node.right = insertRec(root.right, key)

    node
  }


  def findRec(root:Node,key: Int): Node = { //find node with matching value
    var node = root
    if (node != null) if (key < node.key) node = findRec(node.left, key) else if (key > node.key) node = findRec(node.right, key)
    node
  }

  def inOrder(root: Node): Unit = {
    if (root != null) {
      inOrder(root.left)
      System.out.println(root.key)
      inOrder(root.right)
    }
  }

  def preOrder(node: Node): Unit = {
    if (node != null) {
      System.out.println(" " + node.key)
      preOrder(node.left)
      preOrder(node.right)
    }
  }

  def postOrder(node: Node): Unit = {
    if (node != null) {
      postOrder(node.left)
      postOrder(node.right)
      System.out.println(" " + node.key)
    }
  }
}

object App{
  def main(args: Array[String]): Unit = { //main
    val bst = new BinarySearchTreeScala()

    bst.insert(8)
    bst.insert(32)
    bst.insert(19)
    bst.insert(10)
    bst.insert(1)
    bst.insert(3)
    bst.insert(22)

    println("In order:")
    bst.inOrder(bst.root)
    println("Pre order:")
    bst.preOrder(bst.root)
    println("Post order:")
    bst.postOrder(bst.root)

    println("find: " + bst.findRec(bst.root, 19))

  }
}