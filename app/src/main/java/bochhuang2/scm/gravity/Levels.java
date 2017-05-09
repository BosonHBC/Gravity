package bochhuang2.scm.gravity;

import android.graphics.RectF;

import java.util.Random;

/**
 * Created by 黄波铖 on 2017/3/15.
 */

public class Levels {

    final int LEFT = -1;
    final int RIGHT = 1;

    RectF[][] levels = new RectF[18][];
    RectF[][] backUp = new RectF[18][];
    Random rd = new Random();

    public int currentLevel = 0;
    public int nextLevel = 1;

    float speed = 10;

    int moveCount = 0;

    int dir = RIGHT;

   public boolean isNext = false;

    public Levels(){



        levels[0] = new RectF[3];
        levels[1] = new RectF[2];
        levels[2] = new RectF[4];
        levels[3] = new RectF[4];
        levels[4] = new RectF[6];
        levels[5] = new RectF[7];
        levels[6] = new RectF[8];
        levels[7] = new RectF[9];
        levels[8] = new RectF[15];
        levels[9] = new RectF[9];

        levels[10] = new RectF[3];
        levels[11] = new RectF[2];
        levels[12] = new RectF[4];
        levels[13] = new RectF[4];
        levels[14] = new RectF[6];
        levels[15] = new RectF[7];
        levels[16] = new RectF[8];
        levels[17] = new RectF[15];


        // level0
        levels[0][0] = new RectF(345,511,552,642);
        levels[0][1] = new RectF(873,642,1119,1308);
        levels[0][2] = new RectF(1695,166,1874,777);
        // level1
        levels[1][0] = new RectF(941,170,1147,710);
        levels[1][1] = new RectF(643,710,1643,880);
        // level2
        levels[2][0] = new RectF(268,162,431,789);
        levels[2][1] = new RectF(940,435,1100,729);
        levels[2][2] = new RectF(1040,1029,1640,1229);
        levels[2][3] = new RectF(1440,535,1640,829);
        // level3
        levels[3][0] = new RectF(350,170,500,903);
        levels[3][1] = new RectF(500,680,1000,780);
        levels[3][2] = new RectF(1420,680,1920,780);
        levels[3][3] = new RectF(1920,536,2070,1270);
        // level4
        levels[4][0] = new RectF(405,170,605,310);
        levels[4][1] = new RectF(1060,170,1260,310);
        levels[4][2] = new RectF(1715,170,1915,310);
        levels[4][3] = new RectF(405,1130,605,1270);
        levels[4][4] = new RectF(1060,1130,1260,1270);
        levels[4][5] = new RectF(1715,1130,1915,1270);
        // level5
        levels[5][0] = new RectF(400,630,1310,780);
        levels[5][1] = new RectF(1110,530,1310,1270);
        levels[5][2] = new RectF(1110,480,1900,630);
        levels[5][3] = new RectF(1700,530,1730,830);
        levels[5][4] = new RectF(750,1130,950,1270);
        levels[5][5] = new RectF(950,970,1110,1270);
        levels[5][6] = new RectF(1565,830,1865,1130);
        // level6
        levels[6][0] = new RectF(1110,170,1310,1050);
        levels[6][1] = new RectF(710,570,1710,670);
        levels[6][2] = new RectF(710,670,810,850);
        levels[6][3] = new RectF(1610,620,1710,850);
        levels[6][4] = new RectF(300,700,400,800);
        levels[6][5] = new RectF(700,400,800,500);
        levels[6][6] = new RectF(1600,400,1700,500);
        levels[6][7] = new RectF(2000,700,2100,800);
        // level7
        levels[7][0] = new RectF(300,170,400,720);
        levels[7][1] = new RectF(2020,170,2120,720);
        levels[7][2] = new RectF(960,720-170,1460,920-170);
        levels[7][3] = new RectF(300,720-170,650,920-170);
        levels[7][4] = new RectF(1770,720-170,2120,920-170);
        levels[7][5] = new RectF(475,570-170,1110,720-170);
        levels[7][6] = new RectF(475,920-170,1110,1070-170);
        levels[7][7] = new RectF(1310,570-170,1945,720-170);
        levels[7][8] = new RectF(1310,920-170,1945,1070-170);

        // level8
        levels[8][0] = new RectF(1048,750,1354,1098);
        levels[8][1] = new RectF(1048,1098,1104,1270);
        levels[8][2] = new RectF(1298,1098,1354,1270);
        levels[8][3] = new RectF(695,785,1048,836);
        levels[8][4] = new RectF(695,531,746,785);
        levels[8][5] = new RectF(1342,825,1846,880);
        levels[8][6] = new RectF(998,700,1048,750);
        levels[8][7] = new RectF(948,650,998,700);
        levels[8][8] = new RectF(1167 - 50,666,1433- 50,750);
        levels[8][9] = new RectF(1107- 50,484,1200- 50,666);
        levels[8][10] = new RectF(1137- 50,400,1400- 50,484);
        levels[8][11] = new RectF(1400- 50,440,1500- 50,484);
        levels[8][12] = new RectF(1433- 50,636,1483- 50,686);
        levels[8][13] = new RectF(1207,559,1257,609);
        levels[8][14] = new RectF(1303,559,1353,609);
        // level9
        levels[9][0] = new RectF(300,1440 -  levels[7][0].bottom,400,1440 - levels[7][0].top);
        levels[9][1] = new RectF(2020,1440 -  levels[7][1].bottom,2120,1440 - levels[7][1].top);
        levels[9][2] = new RectF(960,1440 -  levels[7][2].bottom,1460,1440 - levels[7][2].top);
        levels[9][3] = new RectF(300,1440 -  levels[7][3].bottom,650,1440 - levels[7][3].top);
        levels[9][4] = new RectF(1770,1440 -  levels[7][4].bottom,2120,1440 - levels[7][4].top);
        levels[9][5] = new RectF(475,1440 -  levels[7][5].bottom,1110,1440 - levels[7][5].top);
        levels[9][6] = new RectF(475,1440 -  levels[7][6].bottom,1110,1440 - levels[7][6].top);
        levels[9][7] = new RectF(1310,1440 -  levels[7][7].bottom,1945,1440 - levels[7][7].top);
        levels[9][8] = new RectF(1310,1440 -  levels[7][8].bottom,1945,1440 - levels[7][8].top);

        // level0
        levels[10][0] = new RectF(345,1440 -  levels[0][0].bottom,552,1440 - levels[0][0].top);
        levels[10][1] = new RectF(873,1440 -  levels[0][1].bottom,1119,1440 - levels[0][1].top);
        levels[10][2] = new RectF(1695,1440 -  levels[0][2].bottom,1874,1440 - levels[0][2].top);
        // level1
        levels[11][0] = new RectF(941,1440 -  levels[1][0].bottom,1147,1440 - levels[1][0].top);
        levels[11][1] = new RectF(643,1440 -  levels[1][1].bottom,1643,1440 - levels[1][1].top);
        // level2
        levels[12][0] = new RectF(268,1440 -  levels[2][0].bottom,431,1440 - levels[2][0].top);
        levels[12][1] = new RectF(940,1440 -  levels[2][1].bottom,1100,1440 - levels[2][1].top);
        levels[12][2] = new RectF(1040,1440 -  levels[2][2].bottom,1640,1440 - levels[2][2].top);
        levels[12][3] = new RectF(1440,1440 -  levels[2][3].bottom,1640,1440 - levels[2][3].top);
        // level3
        levels[13][0] = new RectF(350,1440 -  levels[3][0].bottom,500,1440 - levels[3][0].top);
        levels[13][1] = new RectF(500,1440 -  levels[3][1].bottom,1000,1440 - levels[3][1].top);
        levels[13][2] = new RectF(1420,1440 -  levels[3][2].bottom,1920,1440 - levels[3][2].top);
        levels[13][3] = new RectF(1920,1440 -  levels[3][3].bottom,2070,1440 - levels[3][2].top);
        // level4
        levels[14][0] = new RectF(405,1440 -  levels[4][0].bottom,605,1440 - levels[4][0].top);
        levels[14][1] = new RectF(1060,1440 -  levels[4][1].bottom,1260,1440 - levels[4][1].top);
        levels[14][2] = new RectF(1715,1440 -  levels[4][2].bottom,1915,1440 - levels[4][2].top);
        levels[14][3] = new RectF(405,1440 -  levels[4][3].bottom,605,1440 - levels[4][3].top);
        levels[14][4] = new RectF(1060,1440 -  levels[4][4].bottom,1260,1440 - levels[4][4].top);
        levels[14][5] = new RectF(1715,1440 -  levels[4][5].bottom,1915,1440 - levels[4][5].top);
        // level5
        levels[15][0] = new RectF(400,1440 -  levels[5][0].bottom,1310,1440 - levels[5][0].top);
        levels[15][1] = new RectF(1110,1440 -  levels[5][1].bottom,1310,1440 - levels[5][1].top);
        levels[15][2] = new RectF(1110,1440 -  levels[5][2].bottom,1900,1440 - levels[5][2].top);
        levels[15][3] = new RectF(1700,1440 -  levels[5][3].bottom,1730,1440 - levels[5][3].top);
        levels[15][4] = new RectF(750,1440 -  levels[5][4].bottom,950,1440 - levels[5][4].top);
        levels[15][5] = new RectF(950,1440 -  levels[5][5].bottom,1110,1440 - levels[5][5].top);
        levels[15][6] = new RectF(1565,1440 -  levels[5][6].bottom,1865,1440 - levels[5][6].top);
        // level6
        levels[16][0] = new RectF(1110,1440 -  levels[6][0].bottom,1310,1440 - levels[6][0].top);
        levels[16][1] = new RectF(710,1440 -  levels[6][1].bottom,1710,1440 - levels[6][1].top);
        levels[16][2] = new RectF(710,1440 -  levels[6][2].bottom,810,1440 - levels[6][2].top);
        levels[16][3] = new RectF(1610,1440 -  levels[6][3].bottom,1710,1440 - levels[6][3].top);
        levels[16][4] = new RectF(300,1440 -  levels[6][4].bottom,400,1440 - levels[6][4].top);
        levels[16][5] = new RectF(700,1440 -  levels[6][5].bottom,800,1440 - levels[6][5].top);
        levels[16][6] = new RectF(1600,1440 -  levels[6][6].bottom,1700,1440 - levels[6][6].top);
        levels[16][7] = new RectF(2000,1440 -  levels[6][7].bottom,2100,1440 - levels[6][7].top);

        // level8
        levels[17][0] = new RectF(1048,1440 -  levels[8][0].bottom,1354,1440 - levels[8][0].top);
        levels[17][1] = new RectF(1048,1440 -  levels[8][1].bottom,1104,1440 - levels[8][1].top);
        levels[17][2] = new RectF(1298,1440 -  levels[8][2].bottom,1354,1440 - levels[8][2].top);
        levels[17][3] = new RectF(695,1440 -  levels[8][3].bottom,1048,1440 - levels[8][3].top);
        levels[17][4] = new RectF(695,1440 -  levels[8][4].bottom,746,1440 - levels[8][4].top);
        levels[17][5] = new RectF(1342,1440 -  levels[8][5].bottom,1846,1440 - levels[8][5].top);
        levels[17][6] = new RectF(998,1440 -  levels[8][6].bottom,1048,1440 - levels[8][6].top);
        levels[17][7] = new RectF(948,1440 -  levels[8][7].bottom,998,1440 - levels[8][7].top);
        levels[17][8] = new RectF(1167 - 50,1440 -  levels[8][8].bottom,1433- 50,1440 - levels[8][8].top);
        levels[17][9] = new RectF(1107- 50,1440 -  levels[8][9].bottom,1200- 50,1440 - levels[8][9].top);
        levels[17][10] = new RectF(1137- 50,1440 -  levels[8][10].bottom,1400- 50,1440 - levels[8][10].top);
        levels[17][11] = new RectF(1400- 50,1440 -  levels[8][11].bottom,1500- 50,1440 - levels[8][11].top);
        levels[17][12] = new RectF(1433- 50,1440 -  levels[8][12].bottom,1483- 50,1440 - levels[8][12].top);
        levels[17][13] = new RectF(1207,1440 -  levels[8][13].bottom,1257,1440 - levels[8][13].top);
        levels[17][14] = new RectF(1303,1440 -  levels[8][14].bottom,1353,1440 - levels[8][14].top);

        // back up
        backUp[0] = new RectF[3];
        backUp[1] = new RectF[2];
        backUp[2] = new RectF[4];
        backUp[3] = new RectF[4];
        backUp[4] = new RectF[6];
        backUp[5] = new RectF[7];
        backUp[6] = new RectF[8];
        backUp[7] = new RectF[9];
        backUp[8] = new RectF[15];
        backUp[9] = new RectF[9];

        backUp[10] = new RectF[3];
        backUp[11] = new RectF[2];
        backUp[12] = new RectF[4];
        backUp[13] = new RectF[4];
        backUp[14] = new RectF[6];
        backUp[15] = new RectF[7];
        backUp[16] = new RectF[8];
        backUp[17] = new RectF[15];
        // level0
        backUp[0][0] = new RectF(345,511,552,642);
        backUp[0][1] = new RectF(873,642,1119,1308);
        backUp[0][2] = new RectF(1695,166,1874,777);
        // level1
        backUp[1][0] = new RectF(941,170,1147,710);
        backUp[1][1] = new RectF(643,710,1643,880);
        // level2
        backUp[2][0] = new RectF(268,162,431,789);
        backUp[2][1] = new RectF(940,435,1100,729);
        backUp[2][2] = new RectF(1040,1029,1640,1229);
        backUp[2][3] = new RectF(1440,535,1640,829);
        // level3
        backUp[3][0] = new RectF(350,170,500,903);
        backUp[3][1] = new RectF(500,680,1000,780);
        backUp[3][2] = new RectF(1420,680,1920,780);
        backUp[3][3] = new RectF(1920,536,2070,1270);
        // level4
        backUp[4][0] = new RectF(405,170,605,310);
        backUp[4][1] = new RectF(1060,170,1260,310);
        backUp[4][2] = new RectF(1715,170,1915,310);
        backUp[4][3] = new RectF(405,1130,605,1270);
        backUp[4][4] = new RectF(1060,1130,1260,1270);
        backUp[4][5] = new RectF(1715,1130,1915,1270);
        // level5
        backUp[5][0] = new RectF(400,630,1310,780);
        backUp[5][1] = new RectF(1110,530,1310,1270);
        backUp[5][2] = new RectF(1110,480,1900,630);
        backUp[5][3] = new RectF(1700,530,1730,830);
        backUp[5][4] = new RectF(750,1130,950,1270);
        backUp[5][5] = new RectF(950,970,1110,1270);
        backUp[5][6] = new RectF(1565,830,1865,1130);
        // level6
        backUp[6][0] = new RectF(1110,170,1280,1050);
        backUp[6][1] = new RectF(710,570,1710,670);
        backUp[6][2] = new RectF(710,670,810,850);
        backUp[6][3] = new RectF(1610,620,1710,850);
        backUp[6][4] = new RectF(300,700,400,800);
        backUp[6][5] = new RectF(700,400,800,500);
        backUp[6][6] = new RectF(1600,400,1700,500);
        backUp[6][7] = new RectF(2000,700,2100,800);
        // level7
        backUp[7][0] = new RectF(300,170,400,720);
        backUp[7][1] = new RectF(2020,170,2120,720);
        backUp[7][2] = new RectF(960,720-170,1460,920-170);
        backUp[7][3] = new RectF(300,720-170,650,920-170);
        backUp[7][4] = new RectF(1770,720-170,2120,920-170);
        backUp[7][5] = new RectF(475,570-170,1110,720-170);
        backUp[7][6] = new RectF(475,920-170,1110,1070-170);
        backUp[7][7] = new RectF(1310,570-170,1945,720-170);
        backUp[7][8] = new RectF(1310,920-170,1945,1070-170);

        // level8
        backUp[8][0] = new RectF(1048,750,1354,1098);
        backUp[8][1] = new RectF(1048,1098,1104,1270);
        backUp[8][2] = new RectF(1298,1098,1354,1270);
        backUp[8][3] = new RectF(695,785,1048,836);
        backUp[8][4] = new RectF(695,531,746,785);
        backUp[8][5] = new RectF(1342,825,1846,880);
        backUp[8][6] = new RectF(998,700,1048,750);
        backUp[8][7] = new RectF(948,650,998,700);
        backUp[8][8] = new RectF(1167 - 50,666,1433- 50,750);
        backUp[8][9] = new RectF(1107- 50,484,1200- 50,666);
        backUp[8][10] = new RectF(1137- 50,400,1400- 50,484);
        backUp[8][11] = new RectF(1400- 50,440,1500- 50,484);
        backUp[8][12] = new RectF(1433- 50,636,1483- 50,686);
        backUp[8][13] = new RectF(1207,559,1257,609);
        backUp[8][14] = new RectF(1303,559,1353,609);


        backUp[9][0] = new RectF(300,1440 -  levels[7][0].bottom,400,1440 - levels[7][0].top);
        backUp[9][1] = new RectF(2020,1440 -  levels[7][1].bottom,2120,1440 - levels[7][1].top);
        backUp[9][2] = new RectF(960,1440 -  levels[7][2].bottom,1460,1440 - levels[7][2].top);
        backUp[9][3] = new RectF(300,1440 -  levels[7][3].bottom,650,1440 - levels[7][3].top);
        backUp[9][4] = new RectF(1770,1440 -  levels[7][4].bottom,2120,1440 - levels[7][4].top);
        backUp[9][5] = new RectF(475,1440 -  levels[7][5].bottom,1110,1440 - levels[7][5].top);
        backUp[9][6] = new RectF(475,1440 -  levels[7][6].bottom,1110,1440 - levels[7][6].top);
        backUp[9][7] = new RectF(1310,1440 -  levels[7][7].bottom,1945,1440 - levels[7][7].top);
        backUp[9][8] = new RectF(1310,1440 -  levels[7][8].bottom,1945,1440 - levels[7][8].top);

        // level0
        backUp[10][0] = new RectF(345,1440 -  levels[0][0].bottom,552,1440 - levels[0][0].top);
        backUp[10][1] = new RectF(873,1440 -  levels[0][1].bottom,1119,1440 - levels[0][1].top);
        backUp[10][2] = new RectF(1695,1440 -  levels[0][2].bottom,1874,1440 - levels[0][2].top);
        //backUpel1
        backUp[11][0] = new RectF(941,1440 -  levels[1][0].bottom,1147,1440 - levels[1][0].top);
        backUp[11][1] = new RectF(643,1440 -  levels[1][1].bottom,1643,1440 - levels[1][1].top);
        //backUpel2
        backUp[12][0] = new RectF(268,1440 -  levels[2][0].bottom,431,1440 - levels[2][0].top);
        backUp[12][1] = new RectF(940,1440 -  levels[2][1].bottom,1100,1440 - levels[2][1].top);
        backUp[12][2] = new RectF(1040,1440 -  levels[2][2].bottom,1640,1440 - levels[2][2].top);
        backUp[12][3] = new RectF(1440,1440 -  levels[2][3].bottom,1640,1440 - levels[2][3].top);
        //backUpel3
        backUp[13][0] = new RectF(350,1440 -  levels[3][0].bottom,500,1440 - levels[3][0].top);
        backUp[13][1] = new RectF(500,1440 -  levels[3][1].bottom,1000,1440 - levels[3][1].top);
        backUp[13][2] = new RectF(1420,1440 -  levels[3][2].bottom,1920,1440 - levels[3][2].top);
        backUp[13][3] = new RectF(1920,1440 -  levels[3][3].bottom,2070,1440 - levels[3][2].top);
        //backUpel4
        backUp[14][0] = new RectF(405,1440 -  levels[4][0].bottom,605,1440 - levels[4][0].top);
        backUp[14][1] = new RectF(1060,1440 -  levels[4][1].bottom,1260,1440 - levels[4][1].top);
        backUp[14][2] = new RectF(1715,1440 -  levels[4][2].bottom,1915,1440 - levels[4][2].top);
        backUp[14][3] = new RectF(405,1440 -  levels[4][3].bottom,605,1440 - levels[4][3].top);
        backUp[14][4] = new RectF(1060,1440 -  levels[4][4].bottom,1260,1440 - levels[4][4].top);
        backUp[14][5] = new RectF(1715,1440 -  levels[4][5].bottom,1915,1440 - levels[4][5].top);
        //backUpel5
        backUp[15][0] = new RectF(400,1440 -  levels[5][0].bottom,1310,1440 - levels[5][0].top);
        backUp[15][1] = new RectF(1110,1440 -  levels[5][1].bottom,1310,1440 - levels[5][1].top);
        backUp[15][2] = new RectF(1110,1440 -  levels[5][2].bottom,1900,1440 - levels[5][2].top);
        backUp[15][3] = new RectF(1700,1440 -  levels[5][3].bottom,1730,1440 - levels[5][3].top);
        backUp[15][4] = new RectF(750,1440 -  levels[5][4].bottom,950,1440 - levels[5][4].top);
        backUp[15][5] = new RectF(950,1440 -  levels[5][5].bottom,1110,1440 - levels[5][5].top);
        backUp[15][6] = new RectF(1565,1440 -  levels[5][6].bottom,1865,1440 - levels[5][6].top);
        //backUpel6
        backUp[16][0] = new RectF(1110,1440 -  levels[6][0].bottom,1310,1440 - levels[6][0].top);
        backUp[16][1] = new RectF(710,1440 -  levels[6][1].bottom,1710,1440 - levels[6][1].top);
        backUp[16][2] = new RectF(710,1440 -  levels[6][2].bottom,810,1440 - levels[6][2].top);
        backUp[16][3] = new RectF(1610,1440 -  levels[6][3].bottom,1710,1440 - levels[6][3].top);
        backUp[16][4] = new RectF(300,1440 -  levels[6][4].bottom,400,1440 - levels[6][4].top);
        backUp[16][5] = new RectF(700,1440 -  levels[6][5].bottom,800,1440 - levels[6][5].top);
        backUp[16][6] = new RectF(1600,1440 -  levels[6][6].bottom,1700,1440 - levels[6][6].top);
        backUp[16][7] = new RectF(2000,1440 -  levels[6][7].bottom,2100,1440 - levels[6][7].top);

        //backUpel8
        backUp[17][0] = new RectF(1048,1440 -  levels[8][0].bottom,1354,1440 - levels[8][0].top);
        backUp[17][1] = new RectF(1048,1440 -  levels[8][1].bottom,1104,1440 - levels[8][1].top);
        backUp[17][2] = new RectF(1298,1440 -  levels[8][2].bottom,1354,1440 - levels[8][2].top);
        backUp[17][3] = new RectF(695,1440 -  levels[8][3].bottom,1048,1440 - levels[8][3].top);
        backUp[17][4] = new RectF(695,1440 -  levels[8][4].bottom,746,1440 - levels[8][4].top);
        backUp[17][5] = new RectF(1342,1440 -  levels[8][5].bottom,1846,1440 - levels[8][5].top);
        backUp[17][6] = new RectF(998,1440 -  levels[8][6].bottom,1048,1440 - levels[8][6].top);
        backUp[17][7] = new RectF(948,1440 -  levels[8][7].bottom,998,1440 - levels[8][7].top);
        backUp[17][8] = new RectF(1167 - 50,1440 -  levels[8][8].bottom,1433- 50,1440 - levels[8][8].top);
        backUp[17][9] = new RectF(1107- 50,1440 -  levels[8][9].bottom,1200- 50,1440 - levels[8][9].top);
        backUp[17][10] = new RectF(1137- 50,1440 -  levels[8][10].bottom,1400- 50,1440 - levels[8][10].top);
        backUp[17][11] = new RectF(1400- 50,1440 -  levels[8][11].bottom,1500- 50,1440 - levels[8][11].top);
        backUp[17][12] = new RectF(1433- 50,1440 -  levels[8][12].bottom,1483- 50,1440 - levels[8][12].top);
        backUp[17][13] = new RectF(1207,1440 -  levels[8][13].bottom,1257,1440 - levels[8][13].top);
        backUp[17][14] = new RectF(1303,1440 -  levels[8][14].bottom,1353,1440 - levels[8][14].top);
        /*for (int i =0;i < levels.length;i++){
            for(int j = 0; j < levels[i].length;j++){
                backUp[i][j] = levels[i][j];
            }
        }*/


        currentLevel = rd.nextInt(18);


        GenerateLevel();
    }

    public RectF[][] getLevels(){
        return levels;
    }

    public void resetLevels(){
        for (int i = 0; i<levels.length;i++){
            for (int j = 0; j < levels[i].length;j++) {
                levels[i][j].set(
                        backUp[i][j].left,
                        backUp[i][j].top,
                        backUp[i][j].right,
                        backUp[i][j].bottom);
            }
        }

    }

    public void setSpeed(float spd){
        speed = spd;
    }

    public float getSpeed(){
        return speed;
    }

    boolean isLevel2 = false;
    boolean isLevel3 = false;

    public void Move(){
        // move current

        for (int i = 0; i<levels[currentLevel].length;i++){
            levels[currentLevel][i].set(
                    levels[currentLevel][i].left + dir * speed,
                    levels[currentLevel][i].top,
                    levels[currentLevel][i].right + dir * speed,
                    levels[currentLevel][i].bottom);
        }
        // move next
        for (int i = 0; i<levels[nextLevel].length;i++){
            levels[nextLevel][i].set(
                    levels[nextLevel][i].left + dir * speed,
                    levels[nextLevel][i].top,
                    levels[nextLevel][i].right + dir * speed,
                    levels[nextLevel][i].bottom);
        }


        //Log.d("position","current: " + (int)levels[currentLevel][0].left + " next: " + (int)levels[nextLevel][0].left);

        moveCount ++;
        if(moveCount * speed > 2420){
            moveCount = 0;

            // recover
            for (int i = 0; i<levels[currentLevel].length;i++){
                levels[currentLevel][i].set(
                        backUp[currentLevel][i].left,
                        backUp[currentLevel][i].top,
                        backUp[currentLevel][i].right,
                        backUp[currentLevel][i].bottom);
            }
            for (int i = 0; i<levels[nextLevel].length;i++){
                levels[nextLevel][i].set(
                        backUp[nextLevel][i].left,
                        backUp[nextLevel][i].top,
                        backUp[nextLevel][i].right,
                        backUp[nextLevel][i].bottom);
            }

            // generate next
            currentLevel = nextLevel;
            GenerateLevel();


        }
    }
    void GenerateLevel(){

        for (int i = 0;i<1000;i++){
            nextLevel = rd.nextInt(18);


            if(nextLevel != currentLevel && nextLevel != currentLevel + 1 && nextLevel != currentLevel - 1){
                break;
            }
        }

        if(rd.nextInt(2) == 0){
            dir = LEFT;
        }
        else dir = RIGHT;



        //Log.d("debug","param: " + currentLevel + " "+ nextLevel + "Dir: " + dir);
        //Log.d("rd test", "GenerateLevel: " + currentLevel + " " + nextLevel);

        for (int i = 0; i<levels[nextLevel].length;i++){
            levels[nextLevel][i].set(
                    backUp[nextLevel][i].left - dir * 2420,
                    backUp[nextLevel][i].top,
                    backUp[nextLevel][i].right - dir * 2420,
                    backUp[nextLevel][i].bottom);
        }

        isNext = true;
    }
}

