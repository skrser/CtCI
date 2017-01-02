package ru.skrser.ctci1dot6;

/**
 * Created by Sergey Skryabin
 * on 01.01.2017.
 */
public class Solution {

    public static void rotate(byte[][][] image) {
        if (image == null)
            return;
        checkImageIsSquare(image);

        int quarterPlus = image.length / 2 + image.length % 2;
        int quarterMinus = image.length / 2;
        for (int i = 0; i < quarterPlus; i++) {
            for (int j = 0; j < quarterMinus; j++) {
                rotatePixel(image, i, j);
            }
        }
    }

    private static void checkImageIsSquare(byte[][][] image) {
        for (byte[][] anImage : image)
            if (anImage.length != image.length)
                throw new IllegalArgumentException("Image should be square to rotate!");
    }

    private static void rotatePixel(byte[][][] image, int x, int y) {
        byte[] tmpPixel = image[x][y];

        int prevX = x;
        int prevY = y;
        int nextX;
        int nextY;

        for (int i = 0; i < 3; i++) {
            nextX = image.length - 1 - prevY;
            nextY = prevX;
            image[prevX][prevY] = image[nextX][nextY];
            prevX = nextX;
            prevY = nextY;
        }
        image[prevX][prevY] = tmpPixel;
    }

}
