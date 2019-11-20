package jmhtest.visitor.java;

import java.util.Iterator;

// for jitwatch
public class InliningTest3 {
  static final int Iterations = 1_000_000_000;
  final Iterator<Node> iter3 = infiniteNodeIterator(new N1(), new N2(), new N3());
  final NodeVisitor<String> visitor3 = new Visitor3();

  private static Iterator<Node> infiniteNodeIterator(Node... nodes) {
    return new Iterator<Node>() {
      private int i = 0;
      @Override
      final public boolean hasNext() {
        return true;
      }

      @Override
      final public Node next() {
        Node node = nodes[i];
        i++;
        if (i == nodes.length) {
          i = 0;
        }
        return node;
      }
    };
  }

  public InliningTest3() {
    long start = System.currentTimeMillis();

    for (int i = 0; i < Iterations; i++) {
      final Node node = iter3.next();
      node.accept(visitor3);
    }

    long duration = System.currentTimeMillis() - start;
    System.out.println("finished in " + duration + "ms");
  }

  public static void main(String[] args) {
    new InliningTest3();
  }

  interface Node {
    <T> T accept(NodeVisitor<T> visitor);
  }

  interface NodeVisitor<T> {
    T visit(N1 node);
    T visit(N2 node);
    T visit(N3 node);
  }

  class N1 implements Node {
    @Override
    final public <T> T accept(NodeVisitor<T> visitor) {
      return visitor.visit(this);
    }
  }

  class N2 implements Node {
    @Override
    final public <T> T accept(NodeVisitor<T> visitor) {
      return visitor.visit(this);
    }
  }

  class N3 implements Node {
    @Override
    final public <T> T accept(NodeVisitor<T> visitor) {
      return visitor.visit(this);
    }
  }

  class Visitor3 implements NodeVisitor<String> {
    @Override
    final public String visit(N1 node) {
      return "N1Foo";
    }

    @Override
    final public String visit(N2 node) {
      return "N2Foo";
    }

    @Override
    final public String visit(N3 node) {
      return "N3Foo";
    }
  }

}
