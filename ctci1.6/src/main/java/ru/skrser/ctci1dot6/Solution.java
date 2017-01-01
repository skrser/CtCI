package ru.skrser.ctci1dot6;

/**
 * Created by Sergey Skryabin
 * on 01.01.2017.
 */
public class Solution {

    public static void rotate(byte[][][] image) {
        if (image == null)
            return;
        if (image.length != image[0].length) // TODO
            throw new IllegalArgumentException("Image should be square to rotate!");
        int quater = image.length/2 + image.length%2;
        for (int i = 0; i < quater;i++) {
            for (int j = 0; j < quater; j++) {
                rotatePixel(image, i, j);
            }
        }
    }

    private static void rotatePixel(byte[][][] image, int x, int y) {
        byte[] tmpPixel = image[x][y];

        int prevX = x;
        int prevY = y;
        int nextX;
        int nextY;

        for (int i = 0; i< 3; i++) {
            nextX = image.length - 1 - prevY;
            nextY = image.length - 1 - prevX;
            image[prevX][prevY] = image[nextX][nextY];
            prevX = nextX;
            prevY = nextY;
        }
        image[prevX][prevY] = tmpPixel;
    }

}
