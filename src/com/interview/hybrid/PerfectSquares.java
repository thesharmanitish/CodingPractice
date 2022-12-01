/**
Intuition

The problem can be solved with the mathematical theorems that have been proposed and proved over time. We will break down the problem into several cases in this section.

In 1770, Joseph Louis Lagrange proved a theorem, called Lagrange's four-square theorem, also known as Bachet's conjecture, which states that every natural number can be represented as the sum of four integer squares:
p=a02+a12+a22+a32p=a_{0}^{2}+a_{1}^{2}+a_{2}^{2}+a_{3}^{2}p=a02​+a12​+a22​+a32​

where the four numbers a0,a1,a2,a3a_{0},a_{1},a_{2},a_{3}a0​,a1​,a2​,a3​ are integers.

For example, 3, 31 can be represented as the sum of four squares as follows:
3=12+12+12+0231=52+22+12+123=1^{2}+1^{2}+1^{2}+0^{2} \qquad 31=5^{2}+2^{2}+1^{2}+1^{2}3=12+12+12+0231=52+22+12+12

    Case 1). The Lagrange's four-square theorem sets the upper bound for the results of the problem, i.e. if the number n cannot be decomposed into a fewer number of squares, at least it can be decomposed into the sum of 4 square numbers, i.e. numSquares(n)≤4\text{numSquares}(n) \le 4numSquares(n)≤4.

As one might notice in the above example, the number zero is also considered as a square number, so we can consider that the number 3 can either be decomposed into 3 or 4 square numbers.

However, Lagrange's four-square theorem does not tell us directly the least numbers of square to decompose a natural number.

Later, in 1797, Adrien-Marie Legendre completed the four-square theorem with his three-square theorem, by proving a particular condition that a positive integer can be expressed as the sum of three squares:
n≠4k(8m+7)  ⟺  n=a02+a12+a22n \ne 4^{k}(8m+7) \iff n = a_{0}^{2}+a_{1}^{2}+a_{2}^{2}n=4k(8m+7)⟺n=a02​+a12​+a22​

where kkk and mmm are integers.

    Case 2). Unlike the four-square theorem, Adrien-Marie Legendre's three-square theorem gives us a necessary and sufficient condition to check if the number can ONLY be decomposed into 4 squares, not fewer.

It might be tricky to see the conclusion that we made in the case (2) from the three-square theorem. Let us elaborate the deduction procedure a bit. First of all, the three-square theorem tells us that if the number n is of the form n=4k(8m+7)n = 4^{k}(8m+7)n=4k(8m+7), then the number n cannot be decomposed into the sum of 3 numbers of squares. Further, we can also assert that the number n cannot be decomposed into the sum of two squares, neither the number itself is a square. Because suppose the number n can be decomposed as n=a02+a12n = a_{0}^{2}+a_{1}^{2}n=a02​+a12​, then by adding the square number zero into the expression, i.e. n=a02+a12+02n = a_{0}^{2}+a_{1}^{2} + 0^2n=a02​+a12​+02, we obtain the conclusion that the number n can be decomposed into 3 squares, which is contradicted to the three-square theorem. Therefore, together with the four-square theorem, we can assert that if the number does not meet the condition of the three-square theorem, it can ONLY be decomposed into the sum of 4 squares, not fewer.

If the number meets the condition of the three-square theorem, we know that if can be decomposed into 3 squares. But what we don't know is that whether the number can be decomposed into fewer squares, i.e. one or two squares. So before we attribute the number to the bottom case (three-square theorem), here are the two cases remained to check, namely:

    Case 3.1). if the number is a square number itself, which is easy to check e.g. n == int(sqrt(n)) ^ 2.

    Case 3.2). if the number can be decomposed into the sum of two squares. Unfortunately, there is no mathematical weapon that can help us to check this case in one shot. We need to resort to the enumeration approach.

Algorithm

One can literally follow the above cases to implement the solution.

    First, we check if the number n is of the form n=4k(8m+7)n = 4^{k}(8m+7)n=4k(8m+7), if so we return 4 directly.
    Otherwise, we further check if the number is of a square number itself or the number can be decomposed the sum of two squares.
    In the bottom case, the number can be decomposed into the sum of 3 squares, though we can also consider it decomposable by 4 squares by adding zero according to the four-square theorem. But we are asked to find the least number of squares.

We give some sample implementations here. The solution is inspired from the posts of TCarmic and StefanPochmann in the Discussion forum.
 */

class PerfectSquares {

  protected boolean isSquare(int n) {
    int sq = (int) Math.sqrt(n);
    return n == sq * sq;
  }

  public int numSquares(int n) {
    // four-square and three-square theorems.
    while (n % 4 == 0)
      n /= 4;
    if (n % 8 == 7)
      return 4;

    if (this.isSquare(n))
      return 1;
    // enumeration to check if the number can be decomposed into sum of two squares.
    for (int i = 1; i * i <= n; ++i) {
      if (this.isSquare(n - i * i))
        return 2;
    }
    // bottom case of three-square theorem.
    return 3;
  }
}
// class Solution {
//   Set<Integer> perfectSquareSet = new HashSet<Integer>();

//   protected boolean is_divided_by(int n, int count) {


//       if(count ==1)
//         return perfectSquareSet.contains(n);

//       for(int sq:perfectSquareSet)
//         if(is_divided_by(n-sq, count-1))
//             return true;

//     return false;
//   }

//   public int numSquares(int n) {
//     perfectSquareSet.clear();

//     for (int i = 1; i * i <= n; ++i) {
//       perfectSquareSet.add(i * i);
//     }

//     int count = 1, sroot = (int)Math.sqrt(n)+1;


//     for (; count <= sroot; ++count) {
//       if (is_divided_by(n, count))
//         return count;
//     }
//     return count;
//   }
// }

// class Solution {
//     public int numSquares(int n) {
//         int sqrt = (int)Math.sqrt(n);
//         int[] arr = new int[sqrt+1];

//         for(int i=0;i<arr.length;i++){
//             arr[i] = i*i;
//         }

//         int[] dp = new int[n+1];
//         Arrays.fill(dp, Integer.MAX_VALUE-1);
//         dp[0] = 0;
//         for(int i=1;i<dp.length;i++){
//             for(int j=1;j<arr.length;j++){
//                 if(i<arr[j])
//                     break;
//                 dp[i] = Math.min(dp[i], 1+dp[i-arr[j]]);
//             }
//         }
//         return dp[n];
//     }
// }
