#ifndef	CLASSES_H
#define	CLASSES_H 6.1


/** Two characters and an int */
class	FunnySize1
{
public:
    char	c1;
    char	c2;
    int		i;
};

/** Two characters and an int in between */
class	FunnySize2
{
public:
    char	c1;
    int		i;
    char	c2;
};


/** Two characters and an int, and two inline methods */
class	FunnySize3
{
public:
    char	c1;
    char	c2;
    int		i;
    void f() { i = c1 + c2; }
    void g() { i = c1 - c2; }
};


/**  Two characters and an int, and two virtual methods */
class	FunnySize4
{
public:
    char	c1;
    char	c2;
    int		i;
    virtual void f() { i = c1 + c2; }
    virtual void g() { i = c1 - c2; }
};


#endif	//CLASSES_H
