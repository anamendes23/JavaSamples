/*
	Running this code in a testing environment, the test fails for the case:
	2
	100000 90000
	out: 410065408 (overflow)
	To fix, make result of long type


	Another fail, time limit exceeded (over 1s)
*/


#include <iostream>
#include <vector>

using std::vector;
using std::cin;
using std::cout;

long long MaxPairwiseProduct(const vector<int>& numbers) {
	long long result = 0;
	int n = numbers.size();
	for(int i = 0; i < n; ++i) {
		for(int j = i + 1; j < n; ++j) {
			if(((long long)numbers[i]) * numbers[j] > result) {
				result = ((long long)numbers[i]) * numbers[j];
			} 
		}
	}

	return result;
}

int main() {
	int n;
	cin >> n;
	vector<int> numbers(n);
	for(int i = 0; i < n; ++i) {
		cin >> numbers[i];
	}

	long long result = MaxPairwiseProduct(numbers);
	cout << result << "\n";
	return 0;
}