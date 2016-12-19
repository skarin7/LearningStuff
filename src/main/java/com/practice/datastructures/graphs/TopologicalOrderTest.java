package com.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shankark on 4/11/16.
 */
public class TopologicalOrderTest {

    private static class Graph extends GrapthWithAdjList {
        Queue<Integer> queue = new LinkedList<>();
        int indegrees[] = new int[verticesCount];

        Graph(int vertices) {
            super(vertices);

        }

        public void topSort() {
            calculateIndegreesOfAllVertiecs();
            //Add all the vertices wth indegree 0 to queue

            for (int i = 0; i < verticesCount; i++) {
                if(indegrees[i] == 0) {
                    queue.add(i);
                }
            }

            int noOfverticesVisited = 0;
            List<Integer> sortedlist = new ArrayList<>();
            // Untill the queue empty , iterate and decrese the indegrees of all the neighbours
            while (!queue.isEmpty()) {
                int x = queue.poll();
                sortedlist.add(x);
                for(int y : adjList[x]) {
                    if(--indegrees[y] == 0) {
                        queue.add(y);
                    }
                }

                noOfverticesVisited++;
            }

            if(verticesCount != noOfverticesVisited) {
                System.out.println(" All vertices are not visited");
            }
            for (int x: sortedlist) {
                System.out.println(" -> " + x);
            }

        }

        private void calculateIndegreesOfAllVertiecs() {
            for (int i = 0; i< verticesCount; i++) {
                LinkedList<Integer> neighbours = adjList[i];
                for (int node : neighbours) {
                    indegrees[node]++;
                }

            }

        }


    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.topSort();
    }


}
