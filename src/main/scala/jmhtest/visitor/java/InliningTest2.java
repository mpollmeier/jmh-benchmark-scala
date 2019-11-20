package jmhtest.visitor.java;

import java.util.Iterator;

// for jitwatch
public class InliningTest2 {
  static final int Iterations = 1_000_000_000;
  final Iterator<Node> iter2 = infiniteNodeIterator(new N1("1a"), new N2("2a"), new N2("2b"), new N1("1b"), new N2("2ca"), new N1("1c"));
  final NodeVisitor<String> visitor2 = new Visitor2();

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

  public InliningTest2() {
    long start = System.currentTimeMillis();

    for (int i = 0; i < Iterations; i++) {
      final Node node = iter2.next();
      node.accept(visitor2);
    }

    long duration = System.currentTimeMillis() - start;
    System.out.println("finished in " + duration + "ms");
  }

  public static void main(String[] args) {
    new InliningTest2();
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
    final String s;

    public N1(String s) {
      this.s = s;
    }

    @Override
    final public <T> T accept(NodeVisitor<T> visitor) {
      return visitor.visit(this);
    }
  }

  class N2 implements Node {
    final String s;

    public N2(String s) {
      this.s = s;
    }

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

  class Visitor2 implements NodeVisitor<String> {
    @Override
    final public String visit(N1 node) {
      return node.s;
    }

    @Override
    final public String visit(N2 node) {
      return node.s;
    }

    @Override
    final public String visit(N3 node) {
      throw new RuntimeException("not implemented");
    }
  }

}
