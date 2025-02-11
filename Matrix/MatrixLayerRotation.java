class Solution {
    public static void getLayer(int layer, int[][] matrix, int m, int n, List<Integer> curLayer) {
        int top = layer, left = layer;
        int bottom = m - layer, right = n - layer;

        // Spiral Matrix to get Layer

        if (left < right && top < bottom) {
            // LEFT - RIGHT
            for (int i = left; i < right; i++) {
                curLayer.add(matrix[top][i]);
            }
            top++;

            // TOP - BOTTOM
            for (int i = top; i < bottom; i++) {
                curLayer.add(matrix[i][right - 1]);
            }
            right--;

            if (!(left < right && top < bottom)) {
                return;
            }

            // RIGHT - LEFT
            for (int i = right - 1; i >= left; i--) {
                curLayer.add(matrix[bottom - 1][i]);
            }
            bottom--;

            // BOTTOM - TOP
            for (int i = bottom - 1; i >= top; i--) {
                curLayer.add(matrix[i][left]);
            }
        }
    }

    public static void reverseUtil(List<Integer> arr, int start, int end) {
        while (start <= end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);

            start++;
            end--;
        }
    }

    public static void rotateLayer(List<Integer> curLayer, int r) {
        int len = curLayer.size();

        // R is larger than the layer size - MOD
        r = r % len;  

        // Reverse enitre Layer
        reverseUtil(curLayer, 0, len - 1);

        // Reverse First Len - R elements
        reverseUtil(curLayer, 0, len - r - 1);

        // Reverse Last R elements
        reverseUtil(curLayer, len - r, len - 1);
    }

    public static void insertLayer(int layer, int[][] matrix, int m, int n, List<Integer> curLayer) {
        int top = layer, left = layer;
        int bottom = m - layer, right = n - layer;

        // Insert rotated Layer into Spiral Matrix 

        int idx = 0;

        if (left < right && top < bottom) {
            // LEFT - RIGHT
            for (int i = left; i < right; i++) {
                matrix[top][i] = curLayer.get(idx);
                idx++;
            }
            top++;

            // TOP - BOTTOM
            for (int i = top; i < bottom; i++) {
                matrix[i][right - 1] = curLayer.get(idx);
                idx++;
            }
            right--;

            if (!(left < right && top < bottom)) {
                return;
            }

            // RIGHT - LEFT
            for (int i = right - 1; i >= left; i--) {
                matrix[bottom - 1][i] = curLayer.get(idx);
                idx++;
            }
            bottom--;

            // BOTTOM - TOP
            for (int i = bottom - 1; i >= top; i--) {
                matrix[i][left] = curLayer.get(idx);
                idx++;
            }
        }
    }

    public static void matrixRotation(int[][] matrix, int r) {
        int m = matrix.length, n = matrix[0].length;

        // Total Number of Layers
        int layers = Math.min(m, n) / 2;

        // Current Spiral Layer
        List<Integer> curLayer = new ArrayList<>();

        // Traverse each Layer
        for (int l = 0; l < layers; l++) {
            // get Current Spiral Layer
            getLayer(l, matrix, m, n, curLayer);

            // Rotate Current Spiral Layer - Anti Clockwise
            rotateLayer(curLayer, r);

            // Insert back Rotated Layer
            insertLayer(l, matrix, m, n, curLayer);
            
            // Clear current Layer
            curLayer.clear();
        }
    }
}
