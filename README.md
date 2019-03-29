David Salsbach
# Blogpost BST in Scala uitdaging

![Image](https://upload.wikimedia.org/wikipedia/en/8/85/Scala_logo.png)


Om een nieuwe programmeertaal te leren doe ik mee aan een programmeer uitdaging. 
Ik heb een van de talen uitgekozen uit het boek 'Seven Languages in seven weeks'.
In deze blog zal ik het hebben over mijn uitdaging en wat vertellen over syntaxis, semantiek, pragmatiek en paradigma's van Scala 
en een vergelijking trekken met een bekende taal, Java. 

Mijn programmeerchallenge luidt als volgt:

<b>"Maak en implementeer de Binary Search Tree in Scala."</b>

Ter controle moet de BST inOrder, preOrder en postOrder gesorteerd kunnen worden.

### Toelichting van de challenge:

Ik vind dat deze challenge voldoet aan de eisen van de programmeerchallenge. 

De Binary Search Tree is op zich zelf een redelijk simpele datastructuur, 
maar Scala is een object geörienteerde en functionele programmeertaal die volledig onbekend voor mij is.
In de eerste instantie lijkt de syntaxis ook erg verschillend van Java.
Scala heeft veel verschillende manieren om efficiënter code te schrijven, dat is een van de primaire verkooppunten.

![Image](https://1.bp.blogspot.com/-PL46dZDlB5U/WmXos5dFN4I/AAAAAAAAKL8/mNLo82-R0lYCwPQzjJyDvDk6UZbZ_4BaACLcBGAs/s400/Java%2Bvs%2BScala%2BCode.png)
Daarom denk ik dat het voor mij een uitdaging wordt om met deze taal aan de slag te gaan.


### Verschillen tussen Java en Scala
Een van de grootste verschillen tussen Java en Scala dat mij is opgevallen is dat je in Scala de constructor meegeeft  als parameter in een klasse.
Hieronder is een codevoorbeeld hiervan. 
```  
class Node(var key:Int, var left:Node, var right:Node){ //Constructor
      def this(key:Int){this(key,null,null)} //Aux constructor with 1 param
    }
```

Als je niet alle parameters wil invullen bij het instantiëren van de klasse kan je een auxiliary constructor definiëren met default waarden voor de klasse parameters.


Hieronder is een code voorbeeld van een Java constructor binnen een klasse.

```
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
} 
```
De Scala manier bespaart onnodige regels code, dit vind ik eigenlijk al een stuk beter dan de Java manier.

Verder zijn er nog kleine syntax verschillen tussen Scala en Java. Die leg ik hieronder uit.

```
var key:Int
```

In Scala geef je geen puntkomma aan het eind van een regel. 
Je ook geen public access-modifiers mee te geven. Er wordt vanuit te gaan dat een object altijd public is behalve als er wordt aangegeven dat dat niet zo is.
Een variabele wordt altijd geinstantieërd in de format ``var [naam]:[type]``

```
public int key;
```

Ik vind het fijner in java om een variabele te instantiëren, het is voor mij ongewoon om de type na een naam en dubbele punt mee te geven.

Scala is meer object georiënteerd dan Java en heeft geen statische objecten, daarom kan je niet zomaar ``public static void main(String[] args)`` definiëren binnen een klasse.
Scala heeft in plaats hiervan singleton objecten die de keyword object gebruiken in plaats van class.
Hieronder een object waar de code wordt aangeroepen.

```
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
```

Ik was in het begin verward over hoe ik mijn code moest runnen in Scala. 
Nu dat ik dit weet is het eigenlijk heel simpel.
Ik heb niet echt een voorkeur voor de Java (binnen een klasse) of Scala manier (binnen een object).

### Uitwerking
In dit deel van mijn blog zal ik wat vertellen over de geschreven code in Scala.

Hieronder zie je de Node klasse. 
Een node is een punt op de boom met een waarde, een linker childnode en een rechter childnode.
De Scala code wijkt erg af van de Java code. Zoals eerder vermeld wordt de constructor als parameter meegegeven aan de klasse.
Daarnaast  wordt een auxiliary constructor gedefiniëert die alleen de key als inputwaarde gebruikt en de linker en rechternode standaard op null zet.


```
  class Node(var key:Int, var left:Node, var right:Node){ //Constructor
    def this(key:Int){this(key,null,null)} //Aux constructor with 1 param
  }

```

Hieronder een recursieve methode om aan de Binary Search Trees waarden toe te voegen.
Dit heeft wel veel weg van de java code, op syntaxis na.

Er wordt gebruik gemaakt van recursie. 
De base case is als de root leeg is wordt er een nieuwe root aangemaakt,
Als een root bestaat wordt er gekeken of de nieuwe waarde kleiner (links) of groter (rechts) is van de root.
De methode roept zichzelf aan totdat er een lege childnode wordt gevonden waar de nieuwe key in kan.
```
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
```


Hieronder is de functie dat zoekt naar een node binnen de boom met een bepaalde waarde.
Als de node bestaat wordt die vervolgens geretourneerd. 

Ook is dit behalve syntaxis niet verschillend van Java.
Dat is ook logisch aangezien dit ook weer op een object georiënteerde manier uitgeprogrammeerd is.

```
  def findRec(root:Node,key: Int): Node = { //find node with matching value
    var node = root
    if (node != null) if (key < node.key) node = findRec(node.left, key) else if (key > node.key) node = findRec(node.right, key)
    node
  }
```

Voor de inOrder, preOrder en postOrder methoden geldt dat er weinig inhoudelijk verschil is met Java.
Er wordt gebruik gemaakt van recursie om de roots op een bepaalde volgorde te printen. 

```
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
 
```

Zoals eerder verteld wordt de main methoden niet binnen de klasse gedefiniëerd, maar in een singleton object.
Hier wordt alle code uitgevoerd. 

```
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
```

### Conclusie

Voor de programmeer uitdaging had ik het gevoel dat ik veel meer moeite zou hebben met Scala.
Ik had hierbij het voordeel dat Scala niet alleen functioneel programmeren, maar ook object geörienteerd programmeren ondersteunt.
De gedachtegang achter het programmeren van de bst is hetzelfde omdat het in beide talen object geörienteerd geprogrammeerd is.
Ik vind scala ook mooi omdat de syntaxis ervoor zorgt dat je in vergelijking met Java veel regels code kan besparen.

Voordat ik was begonnen met het programmeren in Scala heb ik eerste een paar filmpjes gekeken en de documentatie bekeken van Scala.
Ik vond bijvoorbeeld het definiëren van de constructor als parameter van een klasse vreemd en wist niet zo goed wat voor een voordelen het te bieden had.
Ik had echt niet verwacht dat ik het eigenlijk best fijn zou vinden nadat ik er mee gewerkt heb.

Al met al vond ik de uitdaging niet te uitdagend, het koste zeker wat tijd om wat dingen uit te zoeken, maar een goed begin om Scala te leren. 
Er zijn nog héél veel aspecten van Scala die ik nog niet ben tegengekomen, maar al met al heb ik een positieve indruk gekregen van Scala.