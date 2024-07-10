#include <stdio.h>

int main(void)
{
	long long how;
	long long i;
	long long a,b, sum, jstore, count, j,N;

	scanf("%lld", &how);

	for (i=1;i<=how;i++)
	{
		sum = 0;
		count = 0;
		scanf("%lld %lld", &a, &b);
		b -= a;
		for (j = 1;; j++)
		{
			sum += j;//1부터 j까지 계속 더함.
			if (sum * 2 + j + 1 >= b)//11223344...jjj+1 b가 이거보다는 작고
				break;//즉 11223344...j보다는 크다는 것이다.
		}
		if (sum * 2 + j + 1 == b) // b가 11223344...jjj+1인경우
			printf("%lld\n", 2 * j + 1); // 개수 바로 도출
			
		else 
		{
			N = b - sum * 2 + j;
			jstore = j;
			while (N >= 1)//b가 112233344...j 등인 경우
			{
				if (N - j < 0)
					j--;
				else
				{
					N -= j;
					count++;
				}
			}
		printf("%lld\n", 2 * (jstore - 1) + 1 + count);
		}
	}
}