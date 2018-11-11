
#ifndef _LIFE_H

#endif   _LIFE_H

 

const int maxrow = 20, maxcol = 60; // grid dimensions

class Life 

{

public:

     void initialize();

     void print();

     void update();

private:

     int grid[maxrow + 2][maxcol + 2]; // Allow two extra rows and columns.

     int neighbor_count(int row, int col);

};