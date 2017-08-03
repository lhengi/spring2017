#include <stdio.h>

struct p{
       int id1;
       char name;
       int id2;
       char c;
       float percentage;    
                         
};


struct pChange{
       int id1;
       int id2;
       float percentage;    
       char name;
       char c;
                         
};



struct q{
    char first[10];
    char middle_initial;
    char last[10];
    double salary;
    int numinhousehold;
};

struct qChange
{
    int numinhousehold;
    char first[10];
    char last[10];
    char middle_initial;
    double salary;
};



struct r{
char b;
int a[2];
int i;
char c;
int *p;
};

struct rChange
{
    int a[2];
    int *p;
    int i;
    char c;
    char b;
};


struct linked{
    int d;
    struct linked *next;
    struct linked *prev;
    char c;   
};

struct  linkedChange
{
    struct linked *next;
    struct linked *prev;
    int d;
    char c;
};

struct mat{
	int a[4][3];
	char b[10];
	double d;
	int c[3][3];
};

struct matChange
{
    double d;
    int c[3][3];
    int a[4][3];
    char b[10];
};


int main()
{
    printf("%d for struct  p\n",sizeof(struct p));
    printf ("%d for Changed p\n\n",sizeof(struct pChange));

    printf("%d for struct  q\n",sizeof(struct q));
    printf("%d for Changed q\n\n",sizeof(struct qChange));
     
    printf("%d for struct  r\n",sizeof(struct r));
    printf("%d for changed r\n\n",sizeof(struct rChange));

    printf("%d for struct  linked\n",sizeof(struct linked));
    printf("%d for Changed linked\n\n",sizeof(struct linkedChange));

    printf("%d for struct  mat\n",sizeof(struct mat));
    printf("%d for Changed mat\n\n",sizeof(struct matChange));
    
    /*
     Out put
     
     bertvm:~/cs261/lab4> ./a.out
     20 for struct  p
     16 for Changed p
     
     40 for struct  q
     40 for Changed q
     
     32 for struct  r
     24 for changed r
     
     32 for struct  linked
     24 for Changed linked
     
     112 for struct  mat
     104 for Changed mat
     
     
     */
  
  return 0;
}




