package com.practice.datastructures.graphs;

import java.util.*;

/**
 * Created by shankark on 4/11/16.
 */
public class GrapthWithAdjList {

    int verticesCount;
    List<Vertex> vertices;
    LinkedList<Integer> adjList[];
    Stack<Integer> stack;
    GrapthWithAdjList(int noOfVertices) {
        this.verticesCount = noOfVertices;
        vertices = new ArrayList<>(noOfVertices);
        adjList = new LinkedList[noOfVertices];

        for(int i =0 ;i < verticesCount; i++) {
            adjList[i] = new LinkedList<Integer>();
            vertices.add(new Vertex(i));
        }
        stack = new Stack<Integer>();
    }

    void addEdge(int start, int end) {
        adjList[start].add(end);
    }

    void dfs() {
        vertices.get(0).visited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            int v = getUnvisiedVertex(stack.peek());
            if(v == -1) {
                stack.pop();
            } else {
                    stack.push(v);
                    displayVertex(v);
                    vertices.get(v).visited = true;
            }
        }
    }

    private void displayVertex(int i) {
        System.out.println(vertices.get(i).label);
    }

    private int getUnvisiedVertex(int x) {
        LinkedList<Integer> list = adjList[x];
        ListIterator<Integer> listIterator = list.listIterator();
        while(listIterator.hasNext()) {
            int v = listIterator.next();
            if (vertices.get(v).visited == false) {
                return v;
            }
        }
        return -1;
    }

    public class Vertex {
        private boolean visited = false;
        int label;

        Vertex(int lable) {
            this.label = lable;
            this.visited = false;
        }
    }

    public static void main(String[] args) {
        GrapthWithAdjList g = new GrapthWithAdjList(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        g.dfs();
    }

}
