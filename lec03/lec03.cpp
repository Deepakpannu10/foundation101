#include<iostream>

using namespace std;

int main(){

    int n=0;
    cin>>n;

    // for(int cr=1;cr<=n;cr++){
    //     for(int cc=1;cc<=cr;cc++){
    //         cout<<"* ";
    //     }
    //     cout<<endl;
    // }

    // int sp=n/2;
    // int st=1;
    // for(int cr=1;cr<=n;cr++){
    //     for(int csp=1;csp<=sp;csp++){
    //         cout<<" ";
    //     }
    //     for(int cst=1;cst<=st;cst++){
    //         cout<<"*";
    //     }
    //     if(cr<=n/2){
    //         sp--;
    //         st+=2;
    //     }else{
    //         sp++;
    //         st -=2;
    //     }
    //     cout<<endl;
    // }


    int a=0;
    int b=1;

    for(int cr=1;cr<=n;cr++){
        for(int cc=1;cc<=cr;cc++){
            cout<<a<<"  ";
            int f=a+b;
            a=b;
            b=f;
        }
        cout<<endl;
    }





    return 0;
}
