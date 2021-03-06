# Laborator1PA
#Rotaru Oana-Dumitrita, B1

#Lab2:
 
 Avem urmatoarele clase:

    Destination;
    
    Factory;
    
    Main;
    
    Problem;
    
    Solution;  
    
    Warehouse;
    
    Source (clasa abstracta).

Main, instantiaza problema din enunt;

Problem, un obiect ce contine toate datele problemei, acestea fiind:

-o matrice de costuri;

-un vector de obiecte de tip Source(unde se instantiaza sursele);

-un vectorr unde se instantiaza destinatiile;

Warehouse si Factory sunt instante ale clasei abstracte Source, care definesc doua tipuri de surse;

Solution: e clasa in care se va calcula solutia problemei, si anume, va calcula costul nimin necesar transportarii a unor unitati de comodidati de la surse, care au o anumita 

capacitate, la o destinatie care cere un numar maxim de comoditati.

Optional: 

-am folosit comentarii pentru a crea un document java doc: 

/**

* returneaza tipul sursei care este WAREHOUSE

* */;

-am transformat clasa Sourse intr-una abstracta si am creat doua clase derivate din aceasta: Warehouse si Factory;

-am suprascris clasa equals pentru a nu permite existenta a doua Surse identice;

-clasa Solition care calculeaza cu un algoritm simplu solutia problemei;
   
   
  #Lab3:
  
