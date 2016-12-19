package com.practice.datastructures.graphs;

import java.util.Stack;

/**
 * Created by shankark on 3/11/16.
 */
public class MyGraph {

    int vertexCount = 0;
    int adjMatrix[][];
    Vertex[] vertices;
    int maxVertices = 10;
    Stack<String> stack = null;

    MyGraph() {
        adjMatrix = new int[maxVertices][maxVertices];
        vertices = new Vertex[maxVertices];
        for(int i =0 ; i <maxVertices; i++) {
            for(int j = 0; j<maxVertices; j++)
            adjMatrix[i][j] = 0;
        }
        stack = new Stack();
    }

    void addVertex(String lable) {
        vertices[vertexCount++] = new Vertex(lable);
    }

    void displayVertex(int position) {
        System.out.println(vertices[position].label);
    }

    int getVertexIndex(final String lable) {
/*        Stream<Vertex> stream = Arrays.stream(vertices);
        Optional<Vertex> vertex =  stream.filter(v -> v.label.equalsIgnoreCase(lable)).findFirst();
        if(vertex.isPresent()) {
           Vertex val = vertex.get();
        }*/

        for(int i = 0; i< vertexCount; i++) {
            if(vertices[i].label == lable) {
                return i;
            }
        }
        return 0;
    }

    void addEdge(String fromLable, String toLable) {
        adjMatrix[getVertexIndex(fromLable)][getVertexIndex(toLable)] = 1;
        adjMatrix[getVertexIndex(toLable)][getVertexIndex(fromLable)] = 1;
    }

    void depthFirstSearch() {
        vertices[0].visited = true;
        stack.push(vertices[0].label);
        while(!stack.isEmpty()) {
            int ver = getUnVisited(stack.peek());
            if(ver == -1) {
                // Means already visited
                System.out.println(stack.pop() + "->");
            } else  {
                vertices[ver].visited = true;
                stack.push(vertices[ver].label);
            }

        }
    }

    private int getUnVisited(String peek) {
/*
        Vertex vertex =  Stream.of(vertices).filter(u -> {
                    if (u.label.equalsIgnoreCase(peek) && u.visited == false) {
                        return true;
                    }
                    return false;
                }
        ).findFirst().orElse(null);
*/


        for (int i = 0; i < vertexCount; i++) {
            if(adjMatrix[i][getVertexIndex(peek)] == 1 && vertices[i].visited == false) {
                return i;
            }
        }
        return -1;
    }

    public static class Vertex {
        private boolean visited = false;
        String label;

        Vertex(String lable) {
            this.label = lable;
            this.visited = false;
        }
    }


    public static void main(String[] args) {
        MyGraph graph = new MyGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "C");
        graph.addEdge("A", "B");
        graph.depthFirstSearch();




     /*   System.out.println(Stream.of(1, 12, 13, 15, 19).filter(v -> {
            if (v > 13 && v <= 15) return true;
            return false;
        }).collect(Collectors.toList()));*/
    }
}
