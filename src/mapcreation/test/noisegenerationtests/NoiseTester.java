package noisegenerationtests;


import mapcreation.mapgeneration.TerrainGeneration;
import mapcreation.noisegeneration.NoiseGenerator;
import mapcreation.noisegeneration.noiseutil.PrintMap;
import org.junit.Test;


public class NoiseTester {

    @Test
    public void testNoiseGeneration_1() {
        int width = 200, height = 200;
        int xPos, yPos;
        double[][] mapTopology;
        double max = Double.MIN_VALUE, min = Double.MAX_VALUE;
        double noise;
        int seed;
        for (int i = 0; i < 100; i++) {
            seed = (int) (Math.random() * 255);
            NoiseGenerator generatedNoise = new NoiseGenerator(64, 0.01, seed);
            mapTopology = new double[width][height];
            for (int x = 0; x < mapTopology.length; x++) {
                for (int y = 0; y < mapTopology[0].length; y++) {
                    xPos = x * width;
                    yPos = y * height;
                    noise = generatedNoise.getNoise(xPos, yPos);
                    noise = (noise + 12) / 24;
                    mapTopology[x][y] = noise;
                    if (max < noise) max = noise;
                    if (min > noise) min = noise;
                }
            }
        }
        //Includes a little leeway
        assert (max < 1.02);
        assert (min > -0.02);

    }

    @Test
    public void mapTest_1() {
        TerrainGeneration TG = new TerrainGeneration();
        double[][] map = TG.testFillMap(50, 50, 1, 90);
        //To physically compare to correctTopology
        PrintMap.greyImage(map);
        double[][] testMap = TestResources.testMap;
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                if (map[x][y] != testMap[x][y]) System.out.println(map[x][y] + "!=" + testMap[x][y]);

            }
        }
    }

    @Test
    public void forestTest_1() {
        TerrainGeneration TG = new TerrainGeneration();
        boolean[][] forest = TG.testFillForest(50, 50, 1, 90);
        //To physically compare to correctForest
        PrintMap.greyImage(forest);
        boolean[][] testForest = TestResources.testForest;
        for (int x = 0; x < forest.length; x++) {
            for (int y = 0; y < forest[0].length; y++) {
                assert (forest[x][y] == testForest[x][y]);
            }
        }
    }

    @Test
    public void genericTest() {
        int width = 7, height = 7;
        int x = 0, y = 0;
        for (int i = 0; i < width + height - 2; i++) {
            if (i % 2 == 0) x++;
            else y++;
            System.out.println("[" + x + "][" + y + "]");
        }

    }

}
