#include<iostream>

using namespace std;

// count total number of digits in a given number. 

int main(){
    int n=0; // number
    cin>>n; // user input;
    int count=0;

    while(n>0){
        n=n/10;
        count++;
    }

    return 0;
}
