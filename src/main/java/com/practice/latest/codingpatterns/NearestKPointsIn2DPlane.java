package com.practice.latest.codingpatterns;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*

 */
public class NearestKPointsIn2DPlane {

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /*
          Ecludian rule to find out distance from origin is x^2 + y^2
         */
        int distanceFromOrigin() {
            return (x*x) + (y*y);
        }

        @Override
        public String toString() {
            return "x= "+ x + ", y=" + y;
        }
    }
    public static void main(String[] args) {
        Point[] points= new Point[]{new Point(1,2), new Point(0,2), new Point(3,1), new Point(5,9),
                new Point(100,35), new Point(1,9)};
        int k= 3;
        List<Point> results = kNearestMembers(points, k);
        System.out.printf("Result is " + results);
    }

    private static List<Point> kNearestMembers(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((point, point2) -> point2.distanceFromOrigin() - point.distanceFromOrigin());
        for (int i = 0; i< k; i++) {
            maxHeap.add(points[i]);
        }
        //Now that we have k elements, loop through all other items and see if the head (max value) is greater than the current value,
        // else remove it and add new item..
        for (int i = k; i< points.length; i++) {
            if(points[i].distanceFromOrigin() < maxHeap.peek().distanceFromOrigin()) {
                maxHeap.poll();
                maxHeap.add(points[k]);
            }
        }

        return new ArrayList<>(maxHeap);
    }
}
