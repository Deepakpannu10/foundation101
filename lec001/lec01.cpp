#include<iostream>
using namespace std;
int main(){
    // cout<<"hello! world";
    
//     int a =0;
//     cout<<"enter 1st number"<<endl;
//     cin>>a;
    
//     int b=0;
//     cout<<"enter 2nd number"<<endl;
//     cin>>b;

//     int res=a+b;
//     cout<<"your res is="<<res;




// int c=20;

//         if(a > b  && a > c ){
//             cout<<" larger is = " << a;
//         }else if(b > a && b > c ){
//            cout<<"larger is =" << b;
//         }else{
//             cout<<"larger is=" << c ;
//         }






    int n=0;
    cin>>n;
    bool isprime=true;
    for(int i=2; i<n ; i++ ){
        if(n%i==0){
            // cout<<"not prime";
            isprime=false;
            break;
        }
    }

    if(isprime == true){
        cout<<"prime";
    }else{
        cout<<"not prime";
    }

    return 0;
}

