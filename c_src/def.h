#ifndef DEF_H
#define DEF_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

//reserved for defines

typedef unsigned char byte;
typedef unsigned short int word;
typedef unsigned int dword;
typedef enum{false,true} bool;
typedef enum{none,pilotta,mpirimpa,tichu} game;

//defined functions
int min(int a,int b);
int max(int a,int b);
double minf(double a,double b);
double maxf(double a,double b);



#endif
