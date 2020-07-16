#include <cstdlib>
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
				result = ((long long)(numbers[i])) * numbers[j];
			}
		}
	}

	return result;
}

long long MaxPairwiseProductFast(const vector<int>& numbers) {
	int n = numbers.size();

	int max_index1 = -1;
	for(int i = 0; i < n; ++i)
		if((max_index1 == -1) || (numbers[i] > numbers[max_index1]))
			max_index1 = i;
	
	int max_index2 = -1;
	for(int j = 0; j < n; ++j) {
		if((j != max_index1) && ((max_index2 == -1) || (numbers[j] > numbers[max_index2])))
			max_index2 = j;
	}
	//cout << max_index1 << ' ' << max_index2 << "\n";

	return ((long long)(numbers[max_index1])) * numbers[max_index2];
}

int main() {
	//stress test
	/*
	we start the stress test with the requirements intervals.
	When facing a bug, the values were too big to troubleshoot, so update boundaries to get smaller
	and easier to work bugs.

	The random numbers are pseudo, so the test is reproduceable - aka every test will generate the same numbers.
	*/
	/*
	while(true) {
		int n = rand() % 100 + 2;
		//int n = rand() % 4 + 2;
		cout << n << "\n";
		vector<int> a;

		for(int i = 0; i < n; ++i) {
			a.push_back(rand() % 100000);
			//a.push_back(rand() % 10);
		}

		for(int i = 0; i < n; ++i) {
			cout << a[i] << ' ';
		}
		cout << "\n";
		long long res1 = MaxPairwiseProduct(a);
		long long res2 = MaxPairwiseProductFast(a);
		if(res1 != res2) {
			cout << "Wrong answer: " << res1 << ' ' << res2 << "\n";
			break;
		}
		else
			cout << "OK\n";
	}
	*/
	//stress test end

	int n;
	cin >> n;
	vector<int> numbers(n);
	for(int i = 0; i < n; ++i) {
		cin >> numbers[i];
	}

	long long result = MaxPairwiseProductFast(numbers);
	//long long result = MaxPairwiseProductFast(vector<int>(100000,0)); //array with 10k elements of 0
	cout << result << "\n";
	return 0;
}