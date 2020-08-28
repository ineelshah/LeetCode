/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int n;
        do {
        int row = rand7();
        int col = rand7();
        n = col + (row - 1) * 7; // Line 12
        } while (n > 40);
        
        return 1 + (n - 1) % 10; // line 15
    }
}


// Line 12:
/*

n = col + (row - 1) *7;
So, here n is the element number. If our matrix is like this:

	1 	2 	3 	4 	5 	6 	7
1	1 	2 	3 	4 	5 	6 	7
2	8 	9 	10 	11 	12 	13 	14 
3	15	16	17	18	19	20	21
4
5
6	AND SO ON...
7

BUT AFTER 40, IT GOES ONLY UP TO 49, WHICH WOULD RESULT INTO A NON UNIFORM DISTRIBUTION.
SO, IF WE REACH TO ANY ELEMENT ABOVE 40, WE REJECT IT.

THIS IS THE ENTIRE LOGIC BEHIND THE FACT THAT WE RE EVALUATE THE n IF IT EXCEEDS 40.


*/ 

//line 15:
 /*

We add 1 because otherwise it is a solution that uniformly gives numbers between 0 and 9 (as 10 % 10 == 0)


 */