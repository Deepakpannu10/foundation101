#include<iostream>
using namespace std;

// is a number prime?

int main(){

    int n=0; cout<<"enter your number"<<endl;
    cin>>n;
    bool isprime=true;  // assumption.
    for(int i=2;i*i<=n;i++){
        if(n%i==0){
            isprime=false;   break;
        }
    }
    if(isprime){
        cout<<"prime";
    }else{
        cout<<"not prime";
    }



        

    return 0;
}